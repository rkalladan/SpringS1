FROM tomcat:8.0.52-jre8
COPY /target/SpringS1.war /usr/local/tomcat/webapps/ 
