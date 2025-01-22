package com.xworkz.gym.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
@Table(name="admin_table")

@NamedQuery(name="getNameByEmailAndPassword", query="select p.name from AdminEntity p where p.email = :byEmail AND p.password = :byPassword")
//@NamedQuery(name="countByName", query = "select count(e) from AdminEntity e where e.name = :setName")
//@NamedQuery(name="countByEmail", query = "select count(e) from AdminEntity e where e.email = :setEmail")
//@NamedQuery(name="countByPassword",query = "select count(e) from AdminEntity e where e.password = :setPassword")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;

}


