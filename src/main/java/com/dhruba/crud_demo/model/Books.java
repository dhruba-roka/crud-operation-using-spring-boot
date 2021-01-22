package com.dhruba.crud_demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int bookid;

    @Column
    private String bookname;

    @Column
    private String author;
    @Column
    private int price;
}
