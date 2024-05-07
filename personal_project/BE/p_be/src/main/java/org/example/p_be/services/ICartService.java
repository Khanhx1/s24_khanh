package org.example.p_be.services;

import org.example.p_be.models.OrderCourse;

import java.util.List;

public interface ICartService {
    void saveCart(OrderCourse orderCourse);

    List<OrderCourse> getAll();

    void deleteByCustomerAndCourse(Integer idCourse, Integer idCustomer);

    OrderCourse findCourseByIdCustomerAndIdCourse(Integer idCustomer, Integer idCourse);
}
