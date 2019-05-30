package com.x.ess.dao.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String country;
    private String city;
    private String street;
    private String houseNumber;
    private String zipDode;

}
