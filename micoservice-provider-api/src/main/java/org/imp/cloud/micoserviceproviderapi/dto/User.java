package org.imp.cloud.micoserviceproviderapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable {

    public User(int id, String username) {
        super();
        this.id = id;
        this.username = username;
    }
    public User() {
        super();
    }

    private int id;
    private String username;
    private String name;
    private int age;
    private BigDecimal balance;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}