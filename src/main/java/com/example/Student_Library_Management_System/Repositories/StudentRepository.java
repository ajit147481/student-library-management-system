package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "select * from Student where email=:email",
            nativeQuery = true)
    Student findByEmail(String email);

    //select * from student where country=India;   //Return of Entities
    @Query(value = "select * from Student where country=:country",
            nativeQuery = true)
    List<Student> findByCountry(String country);
}
