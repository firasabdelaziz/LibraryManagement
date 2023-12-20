package com.example.preexamn.repositories;

import com.example.preexamn.entities.Student;
import com.example.preexamn.entities.enums.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    @Query("SELECT DISTINCT s FROM Student s JOIN FETCH s.libraryCards lc WHERE lc.status =:status")
    List<Student> findByStatus(Status status);

    @Query("SELECT DISTINCT s FROM Student s " +
            "JOIN s.reservations r " +
            "JOIN r.book b " +
            "WHERE b.title IN (" +
            "   SELECT DISTINCT b.title FROM Book b " +
            "   JOIN b.reservations r " +
            "   JOIN r.student s " +
            "   WHERE s.firstName = :firstName AND s.lastName = :lastName" +
            ")")
    List<Student> findByAuthorName(String firstName,String lastName);
}
