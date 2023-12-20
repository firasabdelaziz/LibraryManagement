package com.example.preexamn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long reservationID;

    @Temporal(TemporalType.DATE)
    LocalDate startDate;

    @Temporal(TemporalType.DATE)
    LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

}
