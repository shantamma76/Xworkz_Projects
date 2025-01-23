package com.xworkz.gym.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="register_table")

@NamedQuery(name="updatedDetailsByName" ,query="update RegisterEntity p set p.packages = :packagesBy, p.trainer = :trainerBy, p.amount = :amountBy, p.balance = :balanceBy where p.name = :nameBy")

@NamedQuery(name="countNameBy", query = "select count(e) from RegisterEntity e where e.name = :setName")
@NamedQuery(name="countByEmail", query = "select count(e) from RegisterEntity e where e.email = :setEmail")
@NamedQuery(name="countByTrainer", query = "select count(e) from RegisterEntity e where e.trainer = :setTrainer")
@NamedQuery(name="countByPhone", query = "select count(e) from RegisterEntity e where e.phone = :phoneBy")
@NamedQuery(name = "countByGymName", query = "select count(e) from RegisterEntity e where e.gymName = :setGymName")
@NamedQuery(name = "countByPaid", query = "select count(e) from RegisterEntity e where e.paid = :setPaid")
@NamedQuery(name="countByInstallment", query = "select count(e) from RegisterEntity e where e.installment = :setInstallment")

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



