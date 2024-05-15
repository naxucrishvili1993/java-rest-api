package com.gacebook.example.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Service
public class StudentService {
   private final StudentRepository studentRepository;
   private final StudentMapper studentMapper;

   public StudentResponseDto saveStudent(StudentDto dto) {
      var student = studentMapper.toStudent(dto);
      var savedStudent = studentRepository.save(student);
      return studentMapper.toStudentResponseDto(savedStudent);
   }

   public List<StudentResponseDto> findAll() {
      return this.studentRepository.findAll()
            .stream()
            .map(this.studentMapper::toStudentResponseDto)
            .collect(Collectors.toList());
   }

   public StudentResponseDto findStudentById(Integer id) {
      return this.studentRepository.findById(id)
            .map(this.studentMapper::toStudentResponseDto)
            .orElse(null);
   }

   public List<StudentResponseDto> findStudentsByName(String name) {
      return this.studentRepository.findAllByFirstNameContaining(name)
            .stream()
            .map(this.studentMapper::toStudentResponseDto)
            .collect(Collectors.toList());
   }

   public void deleteStudent(Integer id) {
      this.studentRepository.deleteById(id);
   }
}
