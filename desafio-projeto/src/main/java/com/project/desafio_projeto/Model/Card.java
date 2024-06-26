package com.project.desafio_projeto.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String number;

	@Column(precision = 2, scale = 15)
	private BigDecimal limit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getLimit() {
		return limit;
	}

	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}
}
