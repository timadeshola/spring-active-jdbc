package com.cit.activejdbc.springactivejdbc.model;

import lombok.Getter;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by timad on 4/30/2019.
 */
@Table(value = "person")
public class Person extends Model {
    static {
        validatePresenceOf("first_name", "last_name", "id");
    }
}
