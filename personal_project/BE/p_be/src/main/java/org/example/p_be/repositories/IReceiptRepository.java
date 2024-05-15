package org.example.p_be.repositories;

import org.example.p_be.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReceiptRepository extends JpaRepository<Receipt, Integer> {

    Receipt findReceiptByCode(String code);
}
