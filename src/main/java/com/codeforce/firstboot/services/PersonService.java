package com.codeforce.firstboot.services;

import com.codeforce.firstboot.PersonMapper;

import com.codeforce.firstboot.repositories.AccountEntity;
import com.codeforce.firstboot.repositories.PersonEntity;
import com.codeforce.firstboot.repositories.PersonRepository;
import com.codeforce.firstboot.resources.PersonResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<PersonEntity> getAll() {
        return personRepository.findAll();
    }

    public PersonResource create(PersonEntity person) {
        PersonEntity entity = personRepository.save(person);
        return PersonMapper.getConfirmation(entity);
    }


    public PersonResource getPersonByName(String name) {
        PersonEntity person = personRepository.findByName(name);
        return PersonMapper.getResource(person);
    }

    public String login(Long cardNumber, Long pin) {
        PersonEntity person = personRepository.findByAccountCardNumber(cardNumber);
        if (pin == person.getPassword().getPin())
            return "Zalogowano!";
        else return "Zły Pin!";
    }

    public String checkBalance(Long cardNumber, Long pin) {
        PersonEntity person = personRepository.findByAccountCardNumber(cardNumber);
        if (pin == person.getPassword().getPin())
            return String.valueOf(person.getAccount().getBalance());
        else return "Zły Pin!";
    }

    public String deposit(Long cardNumber, Long pin, long depositAmount) {
        PersonEntity account = personRepository.findByAccountCardNumber(cardNumber);
        AccountEntity currentBalance = personRepository.findByAccountCardNumber(cardNumber).getAccount();
        if (pin == account.getPassword().getPin()) {
            account.getAccount().setBalance(currentBalance.getBalance() + depositAmount);
            personRepository.save(account);
            return "Pomyślnie wpłacono: " + depositAmount + "\nAktualny stan konta: " + currentBalance.getBalance();
        } else return "Zły pin!";
    }

    public String withdrawal(Long cardNumber, Long pin, long withdrawalAmount) {
        PersonEntity account = personRepository.findByAccountCardNumber(cardNumber);
        AccountEntity currentBalance = personRepository.findByAccountCardNumber(cardNumber).getAccount();
        if (pin == account.getPassword().getPin()) {
            if (currentBalance.getBalance() < withdrawalAmount) {
                return "Brak środków na koncie!";
            } else {
                account.getAccount().setBalance(currentBalance.getBalance() - withdrawalAmount);
                personRepository.save(account);
            }
            return "Pomyślnie wypłacono: " + withdrawalAmount + "\nAktualny stan konta: " + currentBalance.getBalance();
        } else return "Zły pin!";
    }

}