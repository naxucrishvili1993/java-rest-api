package com.gacebook.example.school;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class SchoolController {
   private final SchoolService schoolService;


   @PostMapping("/schools")
   public SchoolDto create(@RequestBody SchoolDto dto) {
      return this.schoolService.create(dto);
   }


   @GetMapping("/schools")
   public List<SchoolDto> getAllSchools() {
      return this.schoolService.getAllSchools();
   }
}
