package com.example.preexamn.services;

import com.example.preexamn.entities.Author;
import com.example.preexamn.entities.Book;
import com.example.preexamn.entities.Reservation;
import com.example.preexamn.entities.Student;
import com.example.preexamn.entities.enums.Status;

import java.util.List;

public interface IPreExamnService {
    Author addAuthor(Author author);
    Student addStudent(Student student);

    Book addBookAndAssignToAuthor(Book book,long authorId);

    Student assignStudentToBook(Reservation reservation,long studentId,long isbn);

    List<Student> retrieveStudentByStatus(Status status);

    List<Student> retrieveStudentsByAuthorName(String firstName,String lastName);

    void updateLibraryCardStatus();

}
