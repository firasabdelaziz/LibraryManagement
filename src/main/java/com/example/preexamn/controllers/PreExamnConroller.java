package com.example.preexamn.controllers;

import com.example.preexamn.entities.Author;
import com.example.preexamn.entities.Book;
import com.example.preexamn.entities.Reservation;
import com.example.preexamn.entities.Student;
import com.example.preexamn.entities.enums.Status;
import com.example.preexamn.services.IPreExamnService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
@AllArgsConstructor
public class PreExamnConroller {

    IPreExamnService iPreExamnService;

    @PostMapping("addAuthor")
    public Author addAuthor(@RequestBody Author author){
        return iPreExamnService.addAuthor(author);
    }

    @PostMapping("addStudent")
    public Student addStudent(@RequestBody Student student) {
        return iPreExamnService.addStudent(student);
    }

    @PostMapping("addBookAndAssignToAuthor")
    public Book addBookAndAssignToAuthor(@RequestBody Book book, @RequestParam long authorId){
        return iPreExamnService.addBookAndAssignToAuthor(book,authorId);
    }

    @PostMapping("assignStudentToBook")
    public Student assignStudentToBook(@RequestBody Reservation reservation,@RequestParam long studentId,@RequestParam long isbn){
        return iPreExamnService.assignStudentToBook(reservation,studentId,isbn);
    }

    @GetMapping("retrieveStudentByStatus")
    public List<Student> retrieveStudentByStatus(@RequestParam Status status){
        return iPreExamnService.retrieveStudentByStatus(status);
    }

    @GetMapping("retrieveStudentsByAuthorName")
    public List<Student> retrieveStudentsByAuthorName(@RequestParam String firstName,@RequestParam String lastName){
        return iPreExamnService.retrieveStudentsByAuthorName(firstName,lastName);
    }


}
