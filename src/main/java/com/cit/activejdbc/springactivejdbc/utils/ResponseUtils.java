package com.cit.activejdbc.springactivejdbc.utils;

import com.cit.activejdbc.springactivejdbc.dto.response.PersonResponse;
import lombok.extern.slf4j.Slf4j;
import org.javalite.activejdbc.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timad on 5/2/2019.
 */
@Slf4j
public class ResponseUtils {

    public static PersonResponse getPersonResponse(Model person) {
        Object id = person.get("id");
        Object firstName = person.get("first_name");
        Object lastName = person.get("last_name");
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("id", id);
        objectMap.put("firstName", firstName);
        objectMap.put("lastName", lastName);
        String personToJson = AppUtils.toJSON(objectMap);
        log.info("person json:: {}", personToJson);
        PersonResponse response = AppUtils.fromJSON(personToJson, PersonResponse.class);
        log.info("person object :: {}", response);
        return response;
    }

}
