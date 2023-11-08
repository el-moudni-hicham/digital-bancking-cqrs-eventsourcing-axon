# Bank Account Management Application with Axon Framework (CQRS, Event Sourcing Patterns) and Spring Boot

```
This project aims to develop a comprehensive bank account management application that adheres to
the principles of CQRS (Command Query Responsibility Segregation) and Event Sourcing patterns.
Leveraging the Axon and Spring Boot frameworks, the application will enable users to effectively
manage their bank accounts,including creating new accounts, depositing and withdrawing funds,
and tracking account balances.
```

## Table of Contents

- [Documentation](#documentation)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Conclusion](#conclusion)



## Documentation
- Command Query Responsibility Segregation (CQRS) and Event Sourcing (ES) are two architectural patterns that are often used together. 

  - CQRS : separates the handling of commands (which update the system state) from the handling of queries (which read the system state). 

  - ES  : is a way of storing data as a sequence of events, rather than as a snapshot of the current state.

- There are a number of benefits to using CQRS and ES together. These benefits include:

    * Improved performance, Increased scalability, Improved auditability, Simplified development

## Prerequisites

- Java 8
- Axon 
- Spring Boot 
- MySQL database

## Project Structure 
```
│
├───src
│   ├───main
│   │   ├───java
│   │   │   └───ma
│   │   │       └───enset
│   │   │           └───accountscqrseventsourcingaxon
│   │   │               │   AccountsCqrsEventsourcingAxonApplication.java
│   │   │               │
│   │   │               ├───commands
│   │   │               │   ├───aggregates
│   │   │               │   │       AccountAggregate.java
│   │   │               │   │
│   │   │               │   └───controllers
│   │   │               │           AccountCommandController.java
│   │   │               │
│   │   │               ├───commonapi
│   │   │               │   ├───commands
│   │   │               │   │       BaseCommand.java
│   │   │               │   │       CreateAccountCommand.java
│   │   │               │   │       CreditAccountCommand.kt
│   │   │               │   │       DebitAccountCommand.kt
│   │   │               │   │
│   │   │               │   ├───dtos
│   │   │               │   │       CreateAccoutRequestDTO.java
│   │   │               │   │       CreditAccoutRequestDTO.java
│   │   │               │   │       DebitAccoutRequestDTO.java
│   │   │               │   │
│   │   │               │   ├───enums
│   │   │               │   │       AccountStatus.java
│   │   │               │   │       TransactionType.java
│   │   │               │   │       
│   │   │               │   ├───events
│   │   │               │   │       AccountCreatedEvent.java
│   │   │               │   │       AccountCreditedEvent.kt
│   │   │               │   │       AccountDebitedEvent.kt
│   │   │               │   │       BaseEvent.java
│   │   │               │   │
│   │   │               │   ├───exceptions
│   │   │               │   │       InsufficientBalanceException.java
│   │   │               │   │       NegativeAmountException.java
│   │   │               │   │       NegativeInitialBalanceException.java
│   │   │               │   │
│   │   │               │   └───queries
│   │   │               └───queries
│   │   │                   ├───controllers
│   │   │                   │       AccountQueryController.java
│   │   │                   │
│   │   │                   ├───entites
│   │   │                   │       Account.java
│   │   │                   │       Operation.java
│   │   │                   │
│   │   │                   ├───query
│   │   │                   │       GetAccountQuery.java
│   │   │                   │       GetAllAccountsQuery.java
│   │   │                   │
│   │   │                   ├───repository
│   │   │                   │       AccountRepository.java
│   │   │                   │       OperationRepository.java
│   │   │                   │
│   │   │                   └───services
│   │   │                           AccountEventHandlerService.java
````


## Conclusion

The Bank Account Management Application with CQRS, Event Sourcing, Axon, and Spring Boot demonstrates the practical implementation of modern architectural patterns and frameworks for building scalable, maintainable, and event-driven applications. It serves as a valuable reference for developers seeking to explore these technologies and apply them to real-world projects.
