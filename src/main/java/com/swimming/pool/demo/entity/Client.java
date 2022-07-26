package com.swimming.pool.demo.entity;

import javax.persistence.*;
import java.util.List;

// POJO класс по клиенту
@Entity
@Table(name = "client_table")
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

    // создаём связь с датами
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "client_date",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "date_id"))
    private List<TimeTable> dateList;

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

    public List<TimeTable> getDateList() {
        return dateList;
    }

    public void setDateList(List<TimeTable> dateList) {
        this.dateList = dateList;
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
