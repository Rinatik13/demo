package com.swimming.pool.demo.entity;

import javax.persistence.*;
import java.util.List;

// POJO
// класс содержит информацию по дате и количество человек зарегистрированных в это время
@Entity
@Table(name = "date_table")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "time")
    private String time;
    @Column(name = "count")
    private int count;

    // создаём связь с клиентом, список клиентов зарегистрированных на эту дату.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_date",
    joinColumns = @JoinColumn(name = "date_id"),
    inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clientList;

    public TimeTable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "Date{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", count=" + count +
                '}' + "\n";
    }
}
