package org.example.p_be.services.impl;

import org.example.p_be.models.OrderCourse;
import org.example.p_be.repositories.ICartRepository;
import org.example.p_be.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public void saveCart(OrderCourse orderCourse) {
        iCartRepository.save(orderCourse);
    }
}
