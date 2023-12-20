package com.example.preexamn.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Data
public class Book implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long isbn;

    String title;

    @OneToMany
    List<Reservation> reservations;
}
