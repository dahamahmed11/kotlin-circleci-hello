FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN ./gradlew installDist

CMD ["./app/build/install/app/bin/app"]
