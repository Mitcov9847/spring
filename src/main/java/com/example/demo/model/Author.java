package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authors") // Указываем имя таблицы (если отличается от класса)
@Getter
@Setter
@NoArgsConstructor // Безаргументный конструктор (нужен для JPA)
@AllArgsConstructor // Конструктор со всеми аргументами (удобство)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false) // Опционально указываем столбец
    private String name;

    // Конструктор только с именем (для удобства)
    public Author(String name) {
        this.name = name;
    }
}
