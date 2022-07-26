package com.swimming.pool.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

// POJO
// класс содержит информацию по дате и количество человек зарегистрированных в это время
@Entity
@Table(name = "date_table")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int id;
    @Column(name = "time")
    private String time;
    @Column(name = "count")
    private int count;

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

    @Override
    public String toString() {
        return "Date{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", count=" + count +
                '}' + "\n";
    }
}
