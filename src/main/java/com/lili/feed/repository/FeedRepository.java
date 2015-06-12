package com.lili.feed.repository;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lili.feed.domain.FeedEntity;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
	
    Collection<FeedEntity> findByUsersEmail(String email);
    
    Optional<FeedEntity> findByUrl(String url);
}
