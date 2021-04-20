package com.example.entity;


import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="PullDownPrefecture")
public class prefectureEntity {

    @Id
    @Column (name="Id")
	private long id;

    @Column (name="prefCode")
    private long prefCode;

    @Column (name="prefName")
    private String prefName;

}
