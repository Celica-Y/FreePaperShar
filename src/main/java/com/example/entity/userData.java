package com.example.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = { "password", "profilePicture" })
@Table(name="userTable")
public class userData {

    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="Id")
	private long id;

    @Column(name = "userName", length = 16, nullable = true)
	private String userName;

    @Column(name = "Email", length =120, nullable = false, unique = true)
	private String Email;

    @Column(name = "password", length = 6, nullable = false)
	private String password;

    @Column(columnDefinition="TEXT", name = "profilePicture", nullable = true)
	private String profilePicture;

    @ManyToMany(mappedBy = "user")
    private Set<PaperTable>  paperTable;


}
