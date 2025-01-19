package com.xworkz.gym.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="enquiry_table")

public class EnquiryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String area;

    @Column(name="phone_no")
    private long phone;
    private int distance;
    private int age;

    private String status;
    private String reason;
}
