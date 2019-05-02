package com.cit.activejdbc.springactivejdbc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by timad on 4/30/2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

    private Integer id;
    private String firstName;
    private String lastName;
}
