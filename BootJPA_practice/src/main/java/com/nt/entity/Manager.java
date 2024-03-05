package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="boot_jpa_manager")
public class Manager
{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
 private  Integer mid;
@Column(length=20)
 private String name;
@Column(length=20)
 private Integer age;
@Column(length=20)
 private String email;
 @Column(length=20)
 private  Employee emp;
}
