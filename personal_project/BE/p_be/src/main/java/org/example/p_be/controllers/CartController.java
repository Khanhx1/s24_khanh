package org.example.p_be.controllers;

import org.example.p_be.config.service.JwtService;
import org.example.p_be.models.Course;
import org.example.p_be.models.Customer;
import org.example.p_be.models.OrderCourse;
import org.example.p_be.models.User;
import org.example.p_be.repositories.IUserRepository;
import org.example.p_be.services.ICartService;
import org.example.p_be.services.ICourseService;
import org.example.p_be.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
