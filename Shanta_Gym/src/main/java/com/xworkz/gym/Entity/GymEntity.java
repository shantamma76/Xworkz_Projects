package com.xworkz.gym.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="admin_table")

@NamedQuery(name="getNameByEmailAndPassword", query="select p.name from GymEntity p where p.email = :byEmail AND p.password = :byPassword")
public class GymEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;

}


