# du kan ändra till din version av java om du använder nyare
FROM eclipse-temurin:25-jre
WORKDIR /app
# ändra target/app.jar till target/<namnet_på_din_jar_fil>
COPY target/JavaSpringBootDemo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

ENV DB_URL="jdbc:postgresql://ep-cold-unit-ahnmadd2-pooler.c-3.us-east-1.aws.neon.tech:5432/neondb?sslmode=require"
ENV DB_USERNAME="neondb_owner"
ENV DB_PASSWORD="npg_Olz9EJLjZXK8"