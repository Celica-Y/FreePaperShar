package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="category")
public class PullDownCategory {
    @Id
    @Column (name="Id")
	private long id;

    @Column(name = "categoryCode")
    private int categoryCode;

    @Column(name = "categoryName")
    private String categoryName;
}
