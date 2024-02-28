package furama_resort.services;


import furama_resort.models.person.Employee;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    void add(E e);

    E findByCode(String inputCode);

    void remove(String inputCode);
}
