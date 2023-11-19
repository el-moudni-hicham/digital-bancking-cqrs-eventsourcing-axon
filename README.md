# Bank Account Management Application with Axon Framework (CQRS, Event Sourcing Patterns)

```
This project aims to develop a comprehensive bank account management application that adheres to
the principles of CQRS (Command Query Responsibility Segregation) and Event Sourcing patterns.
Leveraging the Axon and Spring Boot frameworks, the application will enable users to effectively
manage their bank accounts,including creating new accounts, depositing and withdrawing funds,
and tracking account balances.
```

## Table of Contents

- [Key Concepts](#key-concepts)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Tests](#tests)



## Key Concepts

- Command Query Responsibility Segregation (CQRS) and Event Sourcing (ES) are two architectural patterns that are often used together. 

  - **CQRS** : separates the handling of commands (which update the system state) from the handling of queries (which read the system state). 

  - **ES**  : is a way of storing data as a sequence of events, rather than as a snapshot of the current state.

- There are a number of benefits to using CQRS and ES together. These benefits include:

  - Improved performance, Increased scalability, Improved auditability, Simplified development

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

## Tests

Create an application that allows you to manage bank accounts.  


### Command Side

#### commands 

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/70f29afe-c846-48be-b99e-f5898457c550)

* Create Account

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/3dc5cad9-37a6-4d4e-b376-61fe2af8a4cc)

* Credit an account
  
![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/4dbdc0b3-5223-4859-ae52-2fc9fd0fe5a3)

* Debit an account

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/0d7c24bb-f047-4e3b-bda3-7ee2da691540)

#### events 

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/b8f96adf-6b57-4ed1-b64a-dcde42a2d8b3)

* EventStore Data Base

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/73d4a8a6-ce4c-4df3-8972-8d790511741f)

* Account events 
  
![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/7cc29007-0991-4064-9af6-f51511741550)


### Query Side

* Query Data base
  
`account`

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/13aaa680-94c7-4086-81e2-704c6229fa6e)

`operation`

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/ac797722-ca4b-4012-80cd-de2f4a2b498b)


* All accounts

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/9dceab7e-7c9a-4123-9ee0-0dd04747716a)

* Account By ID

![image](https://github.com/el-moudni-hicham/digital-bancking-cqrs-eventsourcing-axon/assets/85403056/ba8ce62a-513f-48e9-a9a5-1cf66f85bca3)









