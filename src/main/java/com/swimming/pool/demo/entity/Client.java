package com.swimming.pool.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

// POJO класс по клиенту
@Entity
@Table(name = "client_table")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client {
    // ид клиента
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    // имя клиента
    @Column (name = "name")
    private String name;

    // телефонный номер клиента
    @Column (name = "phone")
    private String phone;

    // электронная почта клиента
    @Column (name = "email")
    private String email;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", telephineNumber='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}' + "\n";
    }
}
