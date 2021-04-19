package com.example.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="PaperTable")
public class PaperTable {

    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="Id")
	private long id;

    @Column(name = "PaperName", length = 50, nullable = false)
	private String PaperName;

    @Column(name = "prefectures", length = 50, nullable = false)
	private String prefectures;

    @Column(name = "city", length = 50, nullable = false)
	private String city;

    @Column(name = "category", length = 50, nullable = false)
	private String category;

    @Column(name = "year", length = 50, nullable = false)
	private String year;

    @Column(name = "month", length = 50, nullable = false)
	private String month;

    @Column(name = "comment", length = 200, nullable = true)
	private String comment;

    @Column(columnDefinition="MIDIUMTEXT", name = "uploadImg", nullable = true)
	private String uploadImg;

    @Column(name="create_date")
	private Date createDate;

    @Column(name="update_date")
	private Date updateDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<userData> user;
}
