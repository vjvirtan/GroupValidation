package com.validation.dao;

import java.util.*;

import org.springframework.data.annotation.Id;

import lombok.*;

public abstract class UUIDGen {

	@Id
	@Getter
	@Setter
	private String id;
	private Date created;

	public UUIDGen() {
		this.id = UUID.randomUUID().toString();
		this.created = new Date();
	}

}