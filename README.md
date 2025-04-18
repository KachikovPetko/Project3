# Countries Management System

A Java-based system for managing different types of states and their relationships. This project implements an object-oriented approach to handle various state types, their governance, and international relations.

## Project Structure

The project consists of the following main components:

- `State.java` - Abstract base class for all state types
- `DemocraticState.java` - Implementation for democratic states
- `AuthoritarianState.java` - Implementation for authoritarian states
- `Union.java` - Class representing unions between states
- `InternationalRelations.java` - Handles international relations between states
- `Menu.java` - User interface for interacting with the system
- `Main.java` - Entry point of the application

## Features

- Create and manage different types of states (Democratic and Authoritarian)
- Track state information including:
  - Name
  - Capital
  - Population
- Manage state governance
- Handle tax collection
- Form and manage unions between states
- Track international relations

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (recommended) or command line

### Running the Application

1. Compile all Java files:
```bash
javac *.java
```

2. Run the application:
```bash
java Countries.Main
```

## Class Hierarchy

- `State` (Abstract)
  - `DemocraticState`
  - `AuthoritarianState`
- `Union`
- `InternationalRelations`

## State Management

Each state in the system has the following basic attributes:
- Name
- Capital
- Population

States can perform the following actions:
- Govern their territory
- Collect taxes
- Display their details

## Contributing

Feel free to submit issues and enhancement requests.

## License

This project is open source and available under the MIT License. 
