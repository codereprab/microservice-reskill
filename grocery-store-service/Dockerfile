FROM openjdk:11

ADD ./target/grocery-store-service-0.0.1-SNAPSHOT.jar /usr/src/grocery-store-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "grocery-store-service-0.0.1-SNAPSHOT.jar"]