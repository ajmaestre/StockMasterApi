FROM openjdk:latest

# Establecer el directorio de trabajo en el contenedor
WORKDIR /usr/src/app

# Copiar el código fuente y las bibliotecas externas
COPY . .

# Compilar el código fuente (compila todas las clases)
RUN javac -cp ".:/usr/src/app/lib/*" -d /usr/src/app/classes src/main/java/com/engineerds/stockmaster/*.java

# Establecer el directorio para las clases compiladas
WORKDIR /usr/src/app/classes

# Comando para ejecutar la aplicación
CMD ["java", "-cp", ".:/usr/src/app/lib/*", "src.main.java.com.engineerds.stockmaster.Main"]
