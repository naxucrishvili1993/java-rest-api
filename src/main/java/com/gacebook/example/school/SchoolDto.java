package com.gacebook.example.school;

import jakarta.validation.constraints.NotNull;

public record SchoolDto(
      @NotNull
      String name
) {
}
