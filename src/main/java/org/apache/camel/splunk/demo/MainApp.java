package org.apache.camel.splunk.demo;

import org.apache.camel.main.Main;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.enableHangupSupport();
		main.addRouteBuilder(new Twitter2SplunkRoute());
		main.run();
	}

}
