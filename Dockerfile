FROM openjdk

WORKDIR /app

COPY target/petz-0.0.1-SNAPSHOT.jar /app/petz.jar

ENTRYPOINT ["java","-jar","petz.jar"]