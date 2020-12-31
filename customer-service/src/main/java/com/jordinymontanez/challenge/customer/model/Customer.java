package com.jordinymontanez.challenge.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   @Column(name = "lastname")
   private String lastName;
   @Column(name = "birthdate")
   @Temporal(TemporalType.TIMESTAMP)
   private Date birthDate;
   private int age;

}
