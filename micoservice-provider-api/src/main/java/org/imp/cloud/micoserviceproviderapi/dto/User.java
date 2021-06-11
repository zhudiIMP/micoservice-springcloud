package org.imp.cloud.micoserviceproviderapi.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class User {
    private int id;
    private String username;
    private String name;
    private int age;
    private BigDecimal balance;
}