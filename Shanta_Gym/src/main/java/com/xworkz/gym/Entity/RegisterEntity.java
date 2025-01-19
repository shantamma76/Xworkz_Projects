package com.xworkz.gym.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="register_table")

@NamedQuery(name="updatedDetailsByName" ,query="update RegisterEntity p set p.trainer = :trainerBy, p.amount = :amountBy, p.balance = :balanceBy where p.packages = :packagesBy")
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;
    private String packages;
    private String trainer;
    private long phone;
    private String gymName;
    private String amount;
    private String discount;
    private int paid;
    private double balance;
    private double installment;




}
