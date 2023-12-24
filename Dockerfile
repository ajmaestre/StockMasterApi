FROM openjdk:latest

WORKDIR /usr/src/app

# Copiar el código fuente
COPY . .

# Copiar las librerías externas al contenedor
COPY lib/*.jar /usr/src/app/lib/

RUN javac src/main/java/com/engineerds/stockmaster/Main.java

CMD ["java", "-cp", ".:/usr/src/app/lib/*", "Main"]
