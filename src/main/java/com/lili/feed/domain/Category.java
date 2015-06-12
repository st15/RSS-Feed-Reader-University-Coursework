package com.lili.feed.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
	private Long id;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private Set<FeedEntity> feeds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
