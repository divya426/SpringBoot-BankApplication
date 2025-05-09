package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="sbi_bank")
@NoArgsConstructor
@AllArgsConstructor

public class Account {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
    
     @NonNull
     @Column(name="account_holder_name", length=30)
	private String accountHolderName;
	private Double balance;
	
}
