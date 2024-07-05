package com.realstatemanager.dto.address;

import com.realstatemanager.entities.AddressEntity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class AddressCreationPayload {

    @NotEmpty(message = "You must provide a street")
    @Size(min = 1, max = 45)
    private String street;

    @NotEmpty(message = "You must provide a zipcode")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Invalid Brazilian ZIP code format")
    private String zipcode;

    @NotEmpty(message = "You must provide a number")
    @Positive(message = "Number must be positive")
    private Integer number;

    @NotEmpty(message = "You must provide a city")
    @Size(max = 20)
    private String city;

    @NotEmpty(message = "You must provide a state")
    @Size(max = 2)
    private String state;

    public AddressEntity toEntity() {
        return new AddressEntity(street, zipcode, number, city, state);
    }
}
