package com.example.DataController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name="userData")
public class userData {
    
    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="Id")
	private long id;

    @Column(name = "mail", length = 45, nullable = false)
	private long mail;

    @Column(name = "name", length = 16, nullable = false)
	private long name;

    @Column(name = "password", length = 6, nullable = false)
	private long password;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "profilePicture")
	private byte[] profilePicture;
}
