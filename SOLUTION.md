# Design choices for solving the challenge

* use dependency injection to supply services with data source manager, to detach execution of business code from business code itself 
* use interface for data source so that service is decoupled from the actual implementation of the data source
* use lombok to reduce boilerplate code
* use mockito to mock for unit tests
* use assertJ to compare list of objects

# Limitations
* unfortunately I could not find a way to handle the exceptions thrown by the open csv library. Thus, error 
handling with regard to the file parsing could not be implemented. It might have been a better choice
to implement or more simplistic csv parser by myself.