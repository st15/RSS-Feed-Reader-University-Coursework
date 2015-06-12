package com.lili.feed.reader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndImage;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

/**
 * Reads any RSS/Atom feed type.
 *
 */
public class FeedReader {

    private static Logger LOGGER = Logger.getLogger(FeedReader.class);
    
    private static final int FEEDS_COUNT = 10;

	public static FeedInfo readFeed(String url) {
		
		FeedInfo feedInfo = new FeedInfo();
		List<FeedEntryContent> feedContents = new ArrayList<>();
		feedInfo.setFeedEntries(feedContents);
		try {
			
			URL feedUrl = new URL(url);

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedUrl));
			
			feedInfo.setImage(feed.getImage());
			feedInfo.setName(feed.getTitle());
			LOGGER.debug(feed);
			
			for (int i = 0; i < FEEDS_COUNT; i++)
			{
				SyndEntry entry = feed.getEntries().get(i);
				
				FeedEntryContent feedContent = new FeedEntryContent();
				feedContent.setTitle(entry.getTitle());
				feedContent.setUrl(entry.getLink()); // entry.getUri()

				LOGGER.debug("uri: " + entry.getUri());
				LOGGER.debug("link: " + entry.getLink());
				LOGGER.debug("categories: " + entry.getCategories());
				
				if (entry.getDescription() != null)
				{
					feedContent.setDescription(entry.getDescription().getValue());
				}
				else
				{
					SyndContent syndContent = entry.getContents().get(0);
					feedContent.setDescription(syndContent.getValue());
				}
				feedContents.add(feedContent);
			}
			
		} catch (Exception ex) {
			LOGGER.error(ex.toString());
		}
		
		return feedInfo;
	}
}
