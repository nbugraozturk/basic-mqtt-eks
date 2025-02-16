# JDK 17 base image kullan
FROM eclipse-temurin:17-jdk-focal as build

# Maven'ı yükle
RUN apt-get update && apt-get install -y maven

# Çalışma dizinini belirle
WORKDIR /app

# Sadece pom.xml ve src klasörünü kopyala
COPY pom.xml .
COPY src src

# Maven ile uygulamayı derle
RUN mvn clean package -DskipTests

# Runtime image oluştur
FROM eclipse-temurin:17-jre-focal

WORKDIR /app

# Sadece derlenmiş jar dosyasını kopyala
COPY --from=build /app/target/*.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]