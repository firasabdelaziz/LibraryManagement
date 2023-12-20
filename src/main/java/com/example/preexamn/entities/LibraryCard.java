package com.example.preexamn.entities;

import com.example.preexamn.entities.enums.Status;
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
public class LibraryCard implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long cardId;

    @Enumerated(value = EnumType.STRING)
    Status status;

    @Temporal(TemporalType.DATE)
    LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
}
