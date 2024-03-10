package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_marriage_seekar")
public class MarriageSeekar implements Serializable {
	@Id
	/*@SequenceGenerator(name = "gen1", sequenceName = "id_seq", initialValue = 100, allocationSize = 3)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	*/
	// @GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "se1")
	@Column(name = "person_id")
	private Integer id;
	@NonNull
	@Column(name = "person_name", length = 25)
	private String name;
	@Column(name = "addrsess", length = 25)
	@NonNull
	private String address;
	@Lob
	@NonNull
	@Column(name = "photo")
	private byte[] photo;
	@Lob
	@NonNull
	@Column(name = "bio_data")
	private char[] bioData;
	@NonNull
	@Column(name = "dob")
	private LocalDateTime dob;
	@NonNull
	@Column(name = "Indian")
	private Boolean indian;

}