package com.lelo.customermicroservice.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = Customer.TABLE_NAME)
public class Customer {

    public static final String TABLE_NAME = "Customer";
    private static final String ID_COLUMN = "ID";


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = Customer.ID_COLUMN)
    private String customerId;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    @Column(unique = true)
    private String email;
    private String phone;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return Objects.equals(customerId, customer.customerId) &&
//                Objects.equals(name, customer.name) &&
//                Objects.equals(password, customer.password) &&
//                Objects.equals(email, customer.email) &&
//                Objects.equals(phone, customer.phone) &&
//                Objects.equals(addresses, customer.addresses);
//    }
//
//    @Override
//    public int hashCode() {
//        return 0;
//    }
}
