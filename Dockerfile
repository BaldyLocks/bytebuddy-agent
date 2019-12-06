FROM tomcat:8.5-slim

EXPOSE 8080

COPY target/header-agent-*.jar /var/tmp/header-agent.jar