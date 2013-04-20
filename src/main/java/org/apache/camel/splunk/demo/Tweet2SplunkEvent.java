package org.apache.camel.splunk.demo;

import org.apache.camel.Converter;
import org.apache.camel.component.splunk.event.SplunkEvent;

import twitter4j.Tweet;

@Converter
public class Tweet2SplunkEvent {
    @Converter
    public static SplunkEvent convertTweet(Tweet tweet) {
        SplunkEvent data = new SplunkEvent("twitter-message", "twitter");
        data.addPair("source", tweet.getSource());
        data.addPair("from_user", tweet.getFromUser());
        data.addPair("from_user_id", tweet.getFromUserId());
        data.addPair("created_at", tweet.getCreatedAt());
        data.addPair("text", tweet.getText());
        return data;
    }
}
