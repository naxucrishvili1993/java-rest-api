package com.gacebook.example.student;

import com.gacebook.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
   public Student toStudent(StudentDto dto) {
      var school = new School();
      school.setId(dto.schoolId());

      var student = new Student();
      student.setFirstName(dto.firstName());
      student.setLastName(dto.lastName());
      student.setEmail(dto.email());
      student.setSchool(school);

      return student;
   }

   public StudentResponseDto toStudentResponseDto(Student student) {
      return new StudentResponseDto(
            student.getFirstName(),
            student.getLastName(),
            student.getEmail()
      );
   }
}
