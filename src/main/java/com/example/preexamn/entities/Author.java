package com.example.preexamn.entities;

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
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long author;

    String firstName;

    String lastName;

    @OneToMany
    Set<Book> bookList;
}
