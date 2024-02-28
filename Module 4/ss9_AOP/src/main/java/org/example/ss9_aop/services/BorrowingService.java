package org.example.ss9_aop.services;

import org.example.ss9_aop.models.Book;
import org.example.ss9_aop.models.Borrowing;
import org.example.ss9_aop.repositories.IBorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class BorrowingService implements IBorrowingService {

    @Autowired
    private IBorrowingRepository iBorrowingRepository;

    public Integer generateRandomCode(){
        Random random = new Random();
        int firstDigit = random.nextInt(9) + 1;
        StringBuilder concatenatedNumber = new StringBuilder();
        concatenatedNumber.append(firstDigit);
        for (int i = 0; i < 4; i++) {
            // tao so random 0 -> 9
            int randomNumber = random.nextInt(10);
            concatenatedNumber.append(randomNumber);
        }
        int finalNumber = Integer.parseInt(concatenatedNumber.toString());
        return finalNumber;
    }

    @Override
    public Integer addBorrowing(Book book) {

        Integer randomCode = null;
        int count = 0;
        List<Borrowing> borrowingList = null;
        do {
            count = 0;
            randomCode = generateRandomCode();
            borrowingList = iBorrowingRepository.findAll();
            for (Borrowing borrowing: borrowingList){
                if(borrowing.getBorrowingCode().equals(randomCode)){
                    count++;
                    break;
                }
            }
        }while (count != 0);

        Borrowing borrowing = new Borrowing(null,randomCode, book);
        iBorrowingRepository.save(borrowing);
        return randomCode;
    }

    @Override
    public Integer findIdBook(Integer randomCode) {
        List<Borrowing> borrowingList = iBorrowingRepository.findAll();
        for (Borrowing borrowing: borrowingList) {
            if(borrowing.getBorrowingCode().equals(randomCode)){
                return borrowing.getBook().getIdBook();
            }
        }
        return null;
    }

    @Override
    public void deleteBorrowing(Integer randomCode) {
        Integer idBorrowing = null;
        List<Borrowing> borrowingList = iBorrowingRepository.findAll();
        for (Borrowing borrowing: borrowingList) {
            if(borrowing.getBorrowingCode().equals(randomCode)){
                idBorrowing = borrowing.getIdBorrowing();
                break;
            }
        }
        iBorrowingRepository.deleteById(idBorrowing);
    }
}
