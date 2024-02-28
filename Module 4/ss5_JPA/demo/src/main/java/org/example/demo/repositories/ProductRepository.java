package org.example.demo.repositories;

import org.example.demo.models.Product;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList;

    static {
        Product product1 = new Product(1, "Product1", 10, 12);
        Product product2 = new Product(2, "Product2", 20, 15);
        Product product3 = new Product(3, "Product3", 30, 36);
        Product product4 = new Product(4, "Product4", 40, 88);

        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
    }

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = entityManager.createQuery("select s from product s", Product.class).getResultList();
        return products;
    }

    @Override
    public void add(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        Product product = (Product) entityManager.createQuery("select s from product s where id = :id").setParameter("id", id).getSingleResult();
        return product;
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.remove(product);
            entityTransaction.commit();
        }
    }

    @Override
    public void edit(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> search(String search) {
        List<Product> products = entityManager.createQuery("select s from product s where name like :search").setParameter("search", search).getResultList();
        return products;
    }
}
