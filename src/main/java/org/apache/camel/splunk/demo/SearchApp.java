package org.apache.camel.splunk.demo;

import org.apache.camel.main.Main;

public class SearchApp {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new SplunkTwitterSearchRoute());
        main.run();
    }

}
