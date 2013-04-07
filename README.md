camel-splunk-example
====================
## Setup Instructions

## Clone Repository

*  git clone https://github.com/pax95/camel-splunk-example.git

## Build

*  navigate to root directory and run mvn clean install

## Install Splunk

*  Download from http://www.splunk.com/download
*  Browse to the Splunk Manager page and setup a new index called "camel-tweets"

## Create Twitter Application

*  browse to https://dev.twitter.com
*  click "create an app"
*  fill all the data to generate twitter app
*  update "src/main/resources/splunk-demo.properties" with your credentials

## Setup connection to your Splunk server

* update Splunk server info in the properties file as well

## Run Demo
* Remember to compile and install the camel-splunk component into your local maven repo.
The component can be found at https://github.com/pax95/camel-splunk 
* Run "org.apache.camel.splunk.demo.MainApp" or run using maven -> mvn clean compile exec:java	

