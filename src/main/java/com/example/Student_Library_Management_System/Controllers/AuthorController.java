package com.example.Student_Library_Management_System.Controllers;


import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        return new ResponseEntity<>(authorService.createAuthor(authorEntryDto),HttpStatus.OK);
    }

    @GetMapping("/getAuthor")
    public ResponseEntity<AuthorResponseDto> getAuthor(@RequestParam("authorId")Integer authorId){
        return new ResponseEntity<>(authorService.getAuthor(authorId),HttpStatus.OK);
    }








}
