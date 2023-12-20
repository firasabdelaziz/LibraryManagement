package com.example.preexamn.repositories;

import com.example.preexamn.entities.LibraryCard;
import com.example.preexamn.entities.enums.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LibraryCardRepository extends CrudRepository<LibraryCard,Long> {

    List<LibraryCard> findByStartDateBeforeAndStatusNot(LocalDate date, Status status);

}
