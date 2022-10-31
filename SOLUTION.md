# Design choices for solving the challenge

* use dependency injection to supply services with data source manager, to detach execution of business code from business code itself 
* use interface for data source so that service is decoupled from the actual implementation of the data source