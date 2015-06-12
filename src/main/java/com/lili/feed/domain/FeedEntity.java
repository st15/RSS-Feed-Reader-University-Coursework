package com.lili.feed.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "feed")
public class FeedEntity implements Serializable {

	private static final Logger LOG = Logger.getLogger(FeedEntity.class);

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@Column(unique=true)
	public String url;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@JsonIgnore
	@ManyToMany(mappedBy = "feed", fetch = FetchType.EAGER)
	private Set<User> users;

	@JsonIgnore
	public FeedEntity() {
		super();
	}

	public FeedEntity(String url) {
		super();
		this.url = url;
	}

	@JsonIgnore
	public FeedEntity(User user, String url) {
		this.url = url;
		if (users == null) {
			LOG.debug("users is null");
			users = new HashSet<>();
		}
		users.add(user);
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@JsonIgnore
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FeedEntity [id=" + id  + ", url=" + url + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonIgnore
	public Set<User> getUsers() {
		return users;
	}

	@JsonIgnore
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
