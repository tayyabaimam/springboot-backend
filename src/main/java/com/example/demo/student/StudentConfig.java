package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args->{
            Student tayyaba = new Student("Tayyaba", LocalDate.of(2024, Month.JUNE,5),"tayyaba.imam@gmail.com");
            Student alex = new Student("Alex", LocalDate.of(2024, Month.JUNE,5),"alex@gmail.com");
           repository.saveAll(List.of(tayyaba,alex));
        };
    }
}
