package com.cit.activejdbc.springactivejdbc.service;

import com.cit.activejdbc.springactivejdbc.dto.request.PersonRequest;
import com.cit.activejdbc.springactivejdbc.dto.response.PersonResponse;
import com.cit.activejdbc.springactivejdbc.model.Person;

import java.util.List;

/**
 * Created by timad on 4/30/2019.
 */
public interface PersonService {

    public PersonResponse createPerson(PersonRequest request);

    public PersonResponse updatePerson(PersonRequest request);

    public PersonResponse getPersonByFirstName(String firstName);

    public List<PersonResponse> getPersonsByLastName(String lastName);

    public Boolean deletePersonById(Long id);

    public Boolean deletePersonByLastName(String lastName);

    public Boolean deleteAll();

    public List<PersonResponse> getAll();
}
