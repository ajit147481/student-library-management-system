package com.example.Student_Library_Management_System.Controllers;


import com.example.Student_Library_Management_System.DTOs.StudentUpdateMobRequestDto;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }


    @GetMapping("/get_user")
    public ResponseEntity<String> getNameByEmail(@RequestParam("email")String email){

        return new ResponseEntity<>(studentService.findNameByEmail(email),HttpStatus.OK);
    }


    @PutMapping("/update_mob")
    public ResponseEntity<String> updateMob(@RequestBody StudentUpdateMobRequestDto studentReqDto){
        return new ResponseEntity<>(studentService.updateMobNo(studentReqDto),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam("emailId") String emailId){
        studentService.deleteStudent(emailId);
        return new ResponseEntity<>("student deleted successfully",HttpStatus.OK);
    }

}
