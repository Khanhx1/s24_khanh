package org.example.p_be.services.impl;

import org.example.p_be.models.Course;
import org.example.p_be.models.Customer;
import org.example.p_be.models.OrderCourse;
import org.example.p_be.repositories.ICartRepository;
import org.example.p_be.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public void saveCart(OrderCourse orderCourse) {
        iCartRepository.save(orderCourse);
    }

    @Override
    public List<OrderCourse> getAll() {
        return iCartRepository.findAll();
    }

    @Override
    public void deleteByCustomerAndCourse(Integer idCourse, Integer idCustomer) {
        iCartRepository.deleteByCustomerAndCourse(idCourse, idCustomer);
    }

    @Override
    public OrderCourse findCourseByIdCustomerAndIdCourse(Integer idCustomer, Integer idCourse) {
        return iCartRepository.findCourseByIdCustomerAndIdCourse(idCustomer, idCourse);
    }

    @Override
    public void cleanAllCart(Integer idCustomer, Integer idReceipt) {
        iCartRepository.cleanAllCart(idCustomer, idReceipt);
    }

    @Override
    public List<OrderCourse> findAllByCustomer(Customer customer) {
        return iCartRepository.findAllByCustomer(customer);
    }

    @Override
    public List<OrderCourse> findAllBillByIdCustomer(Integer id) {
        return iCartRepository.findAllBillByIdCustomer(id);
    }
}
