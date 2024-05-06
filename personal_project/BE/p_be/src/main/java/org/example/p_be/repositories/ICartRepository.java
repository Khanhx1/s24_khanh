package org.example.p_be.repositories;


import org.example.p_be.models.OrderCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICartRepository extends JpaRepository<OrderCourse, Integer> {


    @Transactional
    @Modifying
    @Query(value = "delete from order_course where order_course.id_course = :idCourse and order_course.id_customer = :idCustomer", nativeQuery = true)
    void deleteByCustomerAndCourse(@Param("idCourse") Integer idCourse, @Param("idCustomer") Integer idCustomer);
}
