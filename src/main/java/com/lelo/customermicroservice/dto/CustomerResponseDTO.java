package com.lelo.customermicroservice.dto;

public class CustomerResponseDTO {
    private String customerId;
    private String name;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
