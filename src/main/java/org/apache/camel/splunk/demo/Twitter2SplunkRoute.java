package org.apache.camel.splunk.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.component.splunk.event.SplunkEvent;

public class Twitter2SplunkRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        PropertiesComponent pc = new PropertiesComponent();
        pc.setLocation("classpath:splunk-demo.properties");
        getContext().addComponent("properties", pc);
        from(
             "twitter://search?type=polling&keywords=music&delay=10&consumerKey={{consumerKey}}&consumerSecret={{consumerSecret}}&accessToken={{accessToken}}&accessTokenSecret={{accessTokenSecret}}")
            .log("${body}").convertBodyTo(SplunkEvent.class)
            .to("splunk://submit?username={{splunk-username}}&password={{splunk-password}}&index=camel-tweets&sourceType=twitter-feed&source=camelhttp");
    }

}
