package org.example.p_be.controllers;

import org.example.p_be.config.service.JwtService;
import org.example.p_be.models.*;
import org.example.p_be.repositories.IReceiptRepository;
import org.example.p_be.repositories.IUserRepository;
import org.example.p_be.services.ICartService;
import org.example.p_be.services.ICourseService;
import org.example.p_be.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private ICourseService iCourseService;
    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICartService iCartService;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private IReceiptRepository iReceiptRepository;

    @GetMapping("/save")
    public ResponseEntity<?> saveToCart(@RequestParam("id") Integer id, @RequestHeader("Authorization") String token) {
        String newToken = token.substring(7);
        String username = jwtService.getUsernameFromJwtToken(newToken);
        User user = iUserService.findUserByUsername(username);
        Customer customer = user.getCustomer();
        Course course = iCourseService.findById(id);
        OrderCourse orderCourse = new OrderCourse();
        orderCourse.setCourse(course);
        orderCourse.setCustomer(customer);
        orderCourse.setDelete(false);

        Boolean statusSave = true;
        List<OrderCourse> orderCourseList = iCartService.getAll();
        for (OrderCourse orderCourse1 : orderCourseList) {
            if (orderCourse1.getCourse().getId().equals(id) && customer.getId().equals(orderCourse1.getCustomer().getId())) {
                statusSave = false;
                break;
            }
        }

        if (statusSave) {
            iCartService.saveCart(orderCourse);
            return new ResponseEntity<>("successfull", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCart(@RequestHeader("Authorization") String token) {
        String newToken = token.substring(7);
        String username = jwtService.getUsernameFromJwtToken(newToken);
        User user = iUserService.findUserByUsername(username);
        Integer id = user.getCustomer().getId();
        List<Course> orderCourses = iCourseService.findAllCartByIdCustomer(id);
        return new ResponseEntity<>(orderCourses, HttpStatus.OK);
    }

    @GetMapping("/deleteByIdCourse")
    public ResponseEntity<?> deleteCartByIdCourse(@RequestParam("id") Integer idCourse, @RequestHeader("Authorization") String token) {
        String newToken = token.substring(7);
        String username = jwtService.getUsernameFromJwtToken(newToken);
        User user = iUserService.findUserByUsername(username);
        Integer idCustomer = user.getCustomer().getId();
        iCartService.deleteByCustomerAndCourse(idCourse, idCustomer);
        return ResponseEntity.ok("delete cart successfully");
    }

    @GetMapping("/checkCourseStatus")
    public ResponseEntity<?> checkCourseStatus(@RequestParam("id") Integer idCourse, @RequestHeader("Authorization") String token) {
        String newToken = token.substring(7);
        String username = jwtService.getUsernameFromJwtToken(newToken);
        User user = iUserService.findUserByUsername(username);
        Integer idCustomer = user.getCustomer().getId();
        OrderCourse orderCourse = iCartService.findCourseByIdCustomerAndIdCourse(idCustomer, idCourse);
        String status = "original";
        if (orderCourse != null) {
            if (orderCourse.getReceipt() != null) {
                status = "purchased";
            } else {
                status = "cart";
            }
        } else {
            status = "original";
        }

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/clean")
    public ResponseEntity<?> cleanAllCart(@RequestHeader("Authorization") String token) {
        String newToken = token.substring(7);
        String username = jwtService.getUsernameFromJwtToken(newToken);
        User user = iUserService.findUserByUsername(username);
        Integer idCustomer = user.getCustomer().getId();

        List<OrderCourse> orderCourseList = iCartService.findAllByCustomer(user.getCustomer());
        int couuntk = 0;
        Boolean valid = true;
        for (OrderCourse orderCourse: orderCourseList) {
            if (orderCourse.getReceipt() == null) {
              couuntk++;
            }
        }
        if (couuntk != 0) {
            valid = true;
        } else {
            valid = false;
        }

        if (valid) {
            String code = "";
            int count = 0;
            List<Receipt> receipts= iReceiptRepository.findAll();
            do {
                count = 0;
                code = generateFiveDigitInteger();
                for (Receipt receipt: receipts) {
                    if (receipt.getCode().equals(code)){
                        count++;
                        break;
                    }
                }
            } while (count != 0);

            LocalDate date = LocalDate.now();
            Receipt receipt = new Receipt();
            receipt.setCode(code);
            receipt.setTotalAmount(0);
            receipt.setDate(date);
            iReceiptRepository.save(receipt);

            Receipt receipt1 = iReceiptRepository.findReceiptByCode(code);
            Integer idReceipt = receipt1.getId();


            iCartService.cleanAllCart(idCustomer, idReceipt);
            return ResponseEntity.ok("clean all cart successfully");
        }

        return ResponseEntity.badRequest().build();


    }

    @GetMapping("/bill")
    public ResponseEntity<?> getBill(@RequestHeader("Authorization") String token) {
        String newToken = token.substring(7);
        String username = jwtService.getUsernameFromJwtToken(newToken);
        User user = iUserService.findUserByUsername(username);
        Integer id = user.getCustomer().getId();
        List<OrderCourse> orderCourses = iCartService.findAllBillByIdCustomer(id);
        return new ResponseEntity<>(orderCourses, HttpStatus.OK);
    }







    public String generateFiveDigitInteger() {
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(randomNumber);
    }

}


