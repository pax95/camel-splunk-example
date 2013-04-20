package org.apache.camel.splunk.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;

public class SplunkTwitterSearchRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        PropertiesComponent pc = new PropertiesComponent();
        pc.setLocation("classpath:splunk-demo.properties");
        getContext().addComponent("properties", pc);

        from(
             "splunk://twees?delay=5s&username={{splunk-username}}&password={{splunk-password}}&" + "searchMode=NORMAL&initEarliestTime=-10s&latestTime=now&"
                 + "search=search index=camel-tweets sourcetype=twitter-feed").log("${body}");
    }

}
