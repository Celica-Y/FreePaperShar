package com.example.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
// @ToString(exclude = {"cityList"})
@Table(name="PullDownPrefecture")
public class prefectureEntity {

    @Id
    @Column (name="Id")
	private long id;

    @Column (name="prefCode")
    private long prefCode;

    @Column (name="prefName")
    private String prefName;

    // @OneToMany(mappedBy="prefId", fetch = FetchType.EAGER)
    // private List<cityEntity> cityList;

}
