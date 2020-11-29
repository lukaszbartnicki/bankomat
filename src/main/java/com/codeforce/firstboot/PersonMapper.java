package com.codeforce.firstboot;

import com.codeforce.firstboot.repositories.*;
import com.codeforce.firstboot.resources.*;

import java.util.Random;

public class PersonMapper {



    public static PersonResource getResource(PersonEntity personEntity) {
        PersonResource result = new PersonResource();
        result.setName(personEntity.getName());
        result.setSurname(personEntity.getSurname());
        result.setAge(personEntity.getAge());
        result.setPhone(personEntity.getPhone());
        result.setEmail(personEntity.getEmail());
        result.setId(personEntity.getId());

        AddressResource adres = new AddressResource();
        adres.setId(personEntity.getAddress().getId());
        adres.setCity(personEntity.getAddress().getCity());
        adres.setStreet(personEntity.getAddress().getStreet());
        adres.setNumber(personEntity.getAddress().getNumber());
        result.setAddress(adres);

        AccountResource account = new AccountResource();
        account.setCardNumber(personEntity.getAccount().getCardNumber());
        account.setBalance(personEntity.getAccount().getBalance());
        result.setAccount(account);

        return result;
    }

    public static PersonResource getConfirmation(PersonEntity personEntity) {
        PersonResource result = new PersonResource();
        result.setName(personEntity.getName());
        result.setSurname(personEntity.getSurname());
        result.setAge(personEntity.getAge());
        result.setPhone(personEntity.getPhone());
        result.setEmail(personEntity.getEmail());
        result.setId(personEntity.getId());

        AccountResource account = new AccountResource();
        account.setCardNumber(personEntity.getAccount().getCardNumber());
        account.setBalance(personEntity.getAccount().getBalance());
        result.setAccount(account);

        AddressResource adres = new AddressResource();
        adres.setId(personEntity.getAddress().getId());
        adres.setCity(personEntity.getAddress().getCity());
        adres.setStreet(personEntity.getAddress().getStreet());
        adres.setNumber(personEntity.getAddress().getNumber());
        result.setAddress(adres);

        PasswordResource password = new PasswordResource();
        password.setId(personEntity.getPassword().getId());
        password.setPin(personEntity.getPassword().getPin());
        result.setPassword(password);

        return result;
    }

    public static PersonEntity getEntity(PersonResource person) {
        PersonEntity entity = new PersonEntity();
        entity.setName(person.getName());
        entity.setSurname(person.getSurname());
        entity.setAge(person.getAge());
        entity.setPhone(person.getPhone());
        entity.setEmail(person.getEmail());

        return entity;
    }

    public static PersonEntity getEntity(PersonModel model) {
        PersonEntity entity = new PersonEntity();
        entity.setName(model.getName());
        entity.setSurname(model.getSurname());
        entity.setAge(model.getAge());
        entity.setPhone(model.getPhone());
        entity.setEmail(model.getEmail());

        AddressEntity adres = new AddressEntity();
        adres.setCity(model.getCity());
        adres.setStreet(model.getStreet());
        adres.setNumber(model.getNumber());
        entity.setAddress(adres);

        PasswordEntity password = new PasswordEntity();
        password.setPin(model.getPin());
        entity.setPassword(password);

        AccountEntity account = new AccountEntity();
        account.setCardNumber(new Long(Math.abs(entity.hashCode())));
        account.setBalance(0);
        entity.setAccount(account);


        return entity;
    }
}
