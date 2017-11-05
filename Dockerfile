FROM tomee:8-jre-7.0.3-plus

COPY target/joker-greetings.war /usr/local/tomee/webapps/
