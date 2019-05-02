package com.cit.activejdbc.springactivejdbc.service.impl;

import com.cit.activejdbc.springactivejdbc.dto.request.PersonRequest;
import com.cit.activejdbc.springactivejdbc.dto.response.PersonResponse;
import com.cit.activejdbc.springactivejdbc.model.Person;
import com.cit.activejdbc.springactivejdbc.service.PersonService;
import com.cit.activejdbc.springactivejdbc.utils.AppUtils;
import com.cit.activejdbc.springactivejdbc.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timad on 4/30/2019.
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Override
    public PersonResponse createPerson(PersonRequest request) {
        Person person = new Person();
        person.set("id", request.getId());
        person.set("first_name", request.getFirstName());
        person.set("last_name", request.getLastName());
        boolean insert = person.insert();
        log.info("Record inserted successfully:: {}", insert);
        return ResponseUtils.getPersonResponse(person);
    }

    @Override
    public PersonResponse updatePerson(PersonRequest request) {
        Model person = Person.findFirst("id = ?", request.getId());
        person.set("first_name", request.getFirstName());
        person.set("last_name", request.getLastName());
        person.saveIt();
        log.info("Person Record updated successfully");
        return ResponseUtils.getPersonResponse(person);
    }

    @Override
    public PersonResponse getPersonByFirstName(String firstname) {
        Model person = Person.findFirst("first_name = ?", firstname);
        return ResponseUtils.getPersonResponse(person);

    }

    @Override
    public List<PersonResponse> getPersonsByLastName(String lastName) {
        List<Model> people = Person.where("last_name = ?", lastName);
        List<PersonResponse> responses = new ArrayList<>();
        for (Model person : people) {
            PersonResponse personResponse = ResponseUtils.getPersonResponse(person);
            responses.add(personResponse);
        }
        return responses;
    }

    @Override
    public Boolean deletePersonById(Long id) {
        Model person = Person.findById(id);
        person.delete();
        log.info("person deleted :: {}", person);
        return true;
    }

    @Override
    public Boolean deletePersonByLastName(String lastName) {
        Model person = Person.findFirst("last_name = ?", lastName);
        person.delete();
        log.info("person deleted :: {}", person);
        return true;
    }

    @Override
    public Boolean deleteAll() {
        Person.deleteAll();
        return true;
    }

    @Override
    public List<PersonResponse> getAll() {
        List<PersonResponse> responses = new ArrayList<>();
        LazyList<Model> persons = Person.findAll();
        for (Model person : persons) {
            PersonResponse personResponse = ResponseUtils.getPersonResponse(person);
            responses.add(personResponse);
        }
        return responses;
    }
}
