package com.example.ims.dto;

import lombok.Data;

@Data
public class CustomerReturnDTO {
    long id;
    String name;
    String Address;
    String email;
    String phone;

    public CustomerReturnDTO() {
        this.id = -1;
        this.name = "";
        Address = "";
        this.email = "";
        this.phone = "";
    }
    public CustomerReturnDTO(long id, String name, String address, String email, String phone) {
        this.id = id;
        this.name = name;
        Address = address;
        this.email = email;
        this.phone = phone;
    }

}
