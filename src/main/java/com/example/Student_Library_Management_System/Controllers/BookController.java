package com.example.Student_Library_Management_System.Controllers;


import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody BookRequestDto bookRequestDto){

        bookService.addBook(bookRequestDto);
        return new ResponseEntity<>("book added Suiccessfully", HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBook(@RequestParam("id") int id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("book deleted successfully",HttpStatus.OK);
    }

}
