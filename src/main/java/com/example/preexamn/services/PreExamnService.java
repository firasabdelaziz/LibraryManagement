package com.example.preexamn.services;

import com.example.preexamn.entities.*;
import com.example.preexamn.entities.enums.Status;
import com.example.preexamn.repositories.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class PreExamnService implements IPreExamnService {
    AuthorRepository authorRepository;
    StudentRepository studentRepository;
    BookRepository bookRepository;
    ReservationRepository reservationRepository;
    LibraryCardRepository libraryCardRepository;
    private static final Logger logger = LoggerFactory.getLogger(PreExamnService.class);

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
    @Override
    public Student addStudent(Student student){

        if (student.getLibraryCards() != null) {
            for (LibraryCard libraryCard : student.getLibraryCards()) {
                libraryCard.setStudent(student);
            }
        }


        return studentRepository.save(student);

    }

    @Override
    @Transactional
    public Book addBookAndAssignToAuthor(Book book,long authorId){
        //save the book
        bookRepository.save(book);
        //Retrieve the author
        Author author = authorRepository.findById(authorId).orElse(null);
        if(author != null){
            //Add the book to the author's bookList
            author.getBookList().add(book);
            //Save the author (to update the relationship)
            authorRepository.save(author);

            return book;

        }else {
            //Handle the case when the authoe is not found
            throw new RuntimeException("Author with id "+ authorId +"not found");
        }

    }


    @Override
    public Student assignStudentToBook(Reservation reservation, long studentId, long isbn) {
        // save reservation
        reservationRepository.save(reservation);
        // find student
        Student student = studentRepository.findById(studentId).orElse(null);
        // find book
        Book book = bookRepository.findById(isbn).orElse(null);

        if (student != null) {
            if (book != null) {
                // Update bidirectional association on Student side
                student.getReservations().add(reservation);

                // Update bidirectional association on Book side
                book.getReservations().add(reservation);

                // Save the updated entities
                studentRepository.save(student);
                bookRepository.save(book);

                return student;
            } else {
                // Handle the case when the Book is not found
                throw new RuntimeException("Book with id " + isbn + " not found");
            }
        } else {
            // Handle the case when the student is not found
            throw new RuntimeException("Student with id " + studentId + " not found");
        }
    }

    @Override
    public List<Student> retrieveStudentByStatus(Status status){
        return studentRepository.findByStatus(status);
    }
    //TO DO continue to develop of task
    @Override
    public List<Student> retrieveStudentsByAuthorName(String firstName,String lastName){
        this.updateLibraryCardStatus();
        return studentRepository.findByAuthorName(firstName,lastName);
    }

    //TO DO continue develop of task cronJob

    // Scheduled method to update the status of LibraryCards after 30 seconds of the previous execution
    @Scheduled(fixedDelay = 30000) // 30 seconds (in milliseconds)
    @Override
    public void updateLibraryCardStatus() {

        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        List<LibraryCard> libraryCards = libraryCardRepository.findByStartDateBeforeAndStatusNot(thirtyDaysAgo, Status.EXPIRED);

        for (LibraryCard libraryCard : libraryCards) {
            libraryCard.setStatus(Status.EXPIRED);
            libraryCardRepository.save(libraryCard);
        }

    }






}
