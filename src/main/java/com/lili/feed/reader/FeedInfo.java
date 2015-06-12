package com.lili.feed.reader;

import java.util.List;

import com.rometools.rome.feed.synd.SyndImage;

public class FeedInfo {
	
	private SyndImage image;
	
	private String name;
	private List<FeedEntryContent> feedEntries;
	
	public List<FeedEntryContent> getFeedEntries() {
		return feedEntries;
	}
	public void setFeedEntries(List<FeedEntryContent> feedEntries) {
		this.feedEntries = feedEntries;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SyndImage getImage() {
		return image;
	}
	public void setImage(SyndImage image) {
		this.image = image;
	}
	
}
