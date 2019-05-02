package com.cit.activejdbc.springactivejdbc.controller;

import com.cit.activejdbc.springactivejdbc.dto.request.PersonRequest;
import com.cit.activejdbc.springactivejdbc.dto.response.PersonResponse;
import com.cit.activejdbc.springactivejdbc.model.Person;
import com.cit.activejdbc.springactivejdbc.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by timad on 4/30/2019.
 */
@RestController
@RequestMapping(value = "persons")
@Api(value = "persons", tags = "Person Management Endpoint", description = "API for managing persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ApiOperation(value = "Create person endpoint", tags = "Create Person", nickname = "createPerson")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest request) {
        PersonResponse person = personService.createPerson(request);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Update person endpoint", tags = "Update Person", nickname = "updatePerson")
    public ResponseEntity<PersonResponse> updatePerson(@RequestBody PersonRequest request) {
        PersonResponse updatePerson = personService.updatePerson(request);
        return new ResponseEntity<>(updatePerson, HttpStatus.OK);
    }

    @GetMapping("{firstName}")
    @ApiOperation(value = "Fetch person by first name endpoint", tags = "Fetch Person", nickname = "getPersonByFirstName")
    public ResponseEntity<PersonResponse> getPersonByFirstName(@ApiParam(name = "firstName", required = true) @PathVariable String firstName) {
        PersonResponse person = personService.getPersonByFirstName(firstName);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("{lastName}/list")
    @ApiOperation(value = "Fetch persons by last name endpoint", tags = "Fetch Persons", nickname = "getPersonsByLastName")
    public ResponseEntity<List<PersonResponse>> getPersonsByLastName(@ApiParam(name = "lastName", required = true) @PathVariable String lastName) {
        List<PersonResponse> persons = personService.getPersonsByLastName(lastName);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete person by person ID endpoint", tags = "Delete Person", nickname = "deletePersonById")
    public ResponseEntity<Boolean> deletePersonById(@ApiParam(name = "id", required = true) @RequestParam Long id) {
        Boolean aBoolean = personService.deletePersonById(id);
        return new ResponseEntity<>(aBoolean, HttpStatus.OK);
    }

    @DeleteMapping("{lastName}")
    @ApiOperation(value = "Delete person by person last name endpoint", tags = "Delete Person", nickname = "deletePersonByLastName")
    public ResponseEntity<Boolean> deletePersonByLastName(@ApiParam(name = "lastName", required = true) @PathVariable String lastName) {
        Boolean aBoolean = personService.deletePersonByLastName(lastName);
        return new ResponseEntity<>(aBoolean, HttpStatus.OK);
    }

    @DeleteMapping("all")
    @ApiOperation(value = "Delete all persons endpoint", tags = "Delete Persons", nickname = "deleteAll")
    public ResponseEntity<Boolean> deleteAll() {
        Boolean aBoolean = personService.deleteAll();
        return new ResponseEntity<>(aBoolean, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Fetch all persons endpoint", tags = "Fetch All Persons", nickname = "getAll")
    public ResponseEntity<List<PersonResponse>> getAll() {
        List<PersonResponse> persons = personService.getAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
}
