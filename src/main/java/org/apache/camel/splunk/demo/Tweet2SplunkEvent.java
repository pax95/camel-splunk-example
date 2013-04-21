package org.apache.camel.splunk.demo;

import org.apache.camel.Converter;
import org.apache.camel.component.splunk.event.SplunkEvent;

import twitter4j.Status;

@Converter
public class Tweet2SplunkEvent {
    @Converter
    public static SplunkEvent convertTweet(Status status) {
        SplunkEvent data = new SplunkEvent("twitter-message", "twitter");
        data.addPair("source", status.getSource());
        data.addPair("from_user", status.getUser());
        data.addPair("from_user_id", status.getId());
        data.addPair("created_at", status.getCreatedAt());
        data.addPair("text", status.getText());
        return data;
    }
}
