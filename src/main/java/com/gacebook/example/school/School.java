package com.gacebook.example.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gacebook.example.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class School {
   @Id
   @GeneratedValue
   private Integer id;

   private String name;

   @OneToMany(
         mappedBy = "school"
   )
   @JsonManagedReference
   private List<Student> students;

   public School(String name) {
      this.name = name;
   }
}
