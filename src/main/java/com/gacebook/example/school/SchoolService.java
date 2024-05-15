package com.gacebook.example.school;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SchoolService {

   private final SchoolRepository schoolRepository;
   private final SchoolMapper schoolMapper;

   public SchoolDto create(SchoolDto schoolDto) {
      var school = this.schoolMapper.toSchool(schoolDto);
      this.schoolRepository.save(school);

      return schoolDto;
   }

   public List<SchoolDto> getAllSchools() {
      return this.schoolRepository.findAll()
            .stream()
            .map(this.schoolMapper::toSchoolDto)
            .collect(Collectors.toList());
   }
}
