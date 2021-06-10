package com.test.spring.mvc.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("unused")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="films")
public class Film {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String genre;
    private String year;
    
    
    
    
    public Film(String name, String genre, String year) {
        super();
        this.name = name;
        this.genre = genre;
        this.year = year;
    }
    public Film(String name, String genre, String year,Timestamp createdTs) {
        super();
        this.name = name;
        this.genre = genre;
        this.year = year;
    }
}
