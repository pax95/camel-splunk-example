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
             "splunk://normal?consumer.bridgeErrorHandler=true&delay=5s&username={{splunk-username}}&password={{splunk-password}}&initEarliestTime=-2m&"
                 + "search=search index=camel-tweets sourcetype=twitter-feed | fields *").bean(SplunkEventTest.class);
    }

}
