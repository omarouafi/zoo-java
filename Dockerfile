
FROM tomcat:latest
COPY /target/*.war /usr/local/tomcat/webapps/zoo23.war
EXPOSE 8080
