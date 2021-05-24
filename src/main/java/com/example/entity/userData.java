package com.example.entity;

import java.io.Serializable;
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
@ToString(exclude = { "password", "Picture" })
@Table(name="userTable")
public class userData implements Serializable{

    @Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private long id;

    @Column(name = "userName", length = 16, nullable = true)
	private String userName;

    @Column(name = "Email", length =120, nullable = false, unique = true)
	private String Email;

    @Column(name = "password", length = 400, nullable = false)
	private String password;

    @Column(columnDefinition="MEDIUMTEXT", name = "profilePicture", nullable = true)
	private String Picture;
    
    @ManyToMany(mappedBy = "user")
    private Set<PaperTable>  paperTable;

}
