Uses maven-surefire-plugin to run JUnit test and maven-failsafe-plugin for integration test.

In the Maven pre-integration-test phase is the enviroment started and in post-integration-test stopped.
This is done even when the integrations tests fail. 
