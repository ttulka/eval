First compile without testing to create a fat JAR.
Then run the test. Test is the server consuming log events in JSON format.

mvn clean package -DskipTests
mvn test 