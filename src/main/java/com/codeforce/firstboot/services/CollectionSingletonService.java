package com.codeforce.firstboot.services;


import com.codeforce.firstboot.resources.PersonResource;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CollectionSingletonService {

    private HashMap<String, PersonResource> personMap = new HashMap();

    public void addPerson(PersonResource person) {
        personMap.put(person.getName(), person);
    }

    public HashMap<String, PersonResource> getPersonMap() {
        return personMap;
    }
}
