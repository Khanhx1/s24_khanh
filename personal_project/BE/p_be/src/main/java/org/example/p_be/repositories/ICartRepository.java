package org.example.p_be.repositories;


import org.example.p_be.models.Course;
import org.example.p_be.models.Customer;
import org.example.p_be.models.OrderCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICartRepository extends JpaRepository<OrderCourse, Integer> {


    @Transactional
    @Modifying
    @Query(value = "delete from order_course where order_course.id_course = :idCourse and order_course.id_customer = :idCustomer", nativeQuery = true)
    void deleteByCustomerAndCourse(@Param("idCourse") Integer idCourse, @Param("idCustomer") Integer idCustomer);

    @Query(value = "SELECT * FROM personal_project_sp1.order_course where id_course = :idCourse and id_customer = :idCustomer", nativeQuery = true)
    OrderCourse findCourseByIdCustomerAndIdCourse(@Param("idCustomer") Integer idCustomer,@Param("idCourse") Integer idCourse);
    @Transactional
    @Modifying
    @Query(value = "UPDATE `personal_project_sp1`.`order_course` SET `id_receipt` = :idReceipt WHERE order_course.id_customer = :idCustomer and order_course.id_receipt is null", nativeQuery = true)
    void cleanAllCart(@Param("idCustomer") Integer idCustomer, @Param("idReceipt") Integer idReceipt);

    List<OrderCourse> findAllByCustomer(Customer customer);

    @Query(value = "SELECT * FROM personal_project_sp1.order_course where order_course.id_customer = :id and order_course.id_receipt is not null;", nativeQuery = true)
    List<OrderCourse> findAllBillByIdCustomer(@Param("id") Integer id);
}
