## What In this project


## Running from the command line

since our Spring boot application now have the server embedded into JAR file we can run the application using

```
java -jar mycoolapp.jar

# or

mvnw spring-boot:run
```
mvnw plugin allows:
- you to run Maven project with no need to have Maven installed or present on your path
- If the correct version of Maven is NOT found on your computer
    - automatically downloads correct version and runs Maven

```
mvnw clean test compile
```
head to the project directory

```
./mvnw package 
```

this will output a JAR file among other thing under target directory, you can then run

```
java -jar target/<application.jar>
```

![](https://i.imgur.com/Ayyymvy.png)

we can alternatively use Spring boot maven pluging

```
mvnw spring-boot:run
```

It will do the same process, and will run the application directly without using java -jar 


