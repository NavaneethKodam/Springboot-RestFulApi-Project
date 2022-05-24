package com.nava.springbootproject.model;

import lombok.*;

import javax.persistence.*;

//@Data   // only @Data Annotation is used instead of getters and setters, along with setters and getters method it creates lots of method..so avoid it
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity   //  to make this class as a jpa entity ( jpa table)
@Table(name="employees")
public class Employee {

   @Id   // to make this as primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="employee_id")
    private Long id;

   @Column(name="first_name")
    private String firstName;

   @Column(name="last_name")
    private String lastName;

   @Column(name="email_id")
    private String emailId;
}
