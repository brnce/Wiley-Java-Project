package com.bernice.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class DVD {
	
	@Id
	 private int dvdID;
	 private String title;
	 private LocalDate releaseDate;
	 private String rating;
	 private String directorName;
	 private String studio;
	 private String ratingComments;
}
