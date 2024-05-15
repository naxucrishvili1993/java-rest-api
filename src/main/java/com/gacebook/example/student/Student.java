package com.gacebook.example.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gacebook.example.studentprofile.StudentProfile;
import com.gacebook.example.school.School;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

   @Id
   @GeneratedValue
   private Integer id;

   @Column(
         name = "first_name"
   )
   private String firstName;

   private String lastName;

   @Column(unique = true, nullable = false)
   private String email;

   private Integer age;

   @OneToOne(
         mappedBy = "student",
         cascade = CascadeType.ALL
   )
   private StudentProfile studentProfile;

   @ManyToOne
   @JoinColumn(
         name = "school_id"
   )
   @JsonBackReference
   private School school;


   public Student(String firstName, String lastName, String email, Integer age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.age = age;
   }
}
