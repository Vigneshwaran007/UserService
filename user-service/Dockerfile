FROM openjdk:11-jdk-slim
RUN addgroup spring && adduser spring --gid 1000 -q
USER spring:spring
WORKDIR /app
ADD target/user-service-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
#CMD ["java","-jar","app.jar"]