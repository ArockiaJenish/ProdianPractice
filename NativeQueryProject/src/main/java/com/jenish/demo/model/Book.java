package com.jenish.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Book {
	
	@Id
	@GeneratedValue
	private int bId;
	
	private String bName;
	
	private String bAuthor;
	
	private int yop;
}
