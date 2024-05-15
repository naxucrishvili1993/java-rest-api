package com.gacebook.example.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
      @NotEmpty(message = "First name should not be empty!")
      String firstName,

      @NotEmpty(message = "Last name should not be empty!")
      String lastName,

      @NotEmpty(message = "Email should not be empty!")
      @Email(message = "Email is not valid!")
      String email,

      Integer schoolId
) {
}
