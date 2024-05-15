package com.gacebook.example.student;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
public class StudentController {

   private final StudentService studentService;

   @PostMapping("/students")
   public StudentResponseDto saveStudent(
         @Valid @RequestBody StudentDto studentDto
   ) {
      return this.studentService.saveStudent(studentDto);
   }

   @GetMapping("/students")
   public List<StudentResponseDto> findAllStudents() {
      return this.studentService.findAll();
   }

   @GetMapping("/students/{id}")
   public StudentResponseDto findStudentById(@PathVariable Integer id) {
      return this.studentService.findStudentById(id);
   }

   @GetMapping("/students/search/{student-name}")
   public List<StudentResponseDto> findStudentsByName(@PathVariable("student-name") String firstName) {
      return this.studentService.findStudentsByName(firstName);
   }

   @DeleteMapping("/students/{student-id}")
   @ResponseStatus(HttpStatus.OK)
   public void deleteStudent(@PathVariable("student-id") Integer id) {
      this.studentService.deleteStudent(id);
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<?> handleMethodArgumentNotValidException(
         MethodArgumentNotValidException exception
   ) {
      var errors = new HashMap<String, String>();
      exception.getBindingResult().getAllErrors().
            forEach(error -> {
               var fieldName = ((FieldError) error).getField();
               var errorMessage = error.getDefaultMessage();
               errors.put(fieldName, errorMessage);
            });

      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
   }
}
