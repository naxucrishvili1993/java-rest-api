package com.gacebook.example.studentprofile;

import com.gacebook.example.student.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class StudentProfile {
   @Id
   @GeneratedValue
   private Integer id;

   private String bio;

   @OneToOne
   @JoinColumn(
         name = "student_id"
   )
   private Student student;

   public StudentProfile(String bio) {
      this.bio = bio;
   }
}
