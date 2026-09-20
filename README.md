# COMP713 Assignment 1 – Option B Small Peer-to-Peer Message-Passing System

## Overview

This project is a small peer-to-peer messaging system developed for COMP713 Assignment 1.

The system uses three independent Java peers that communicate directly with each other using TCP sockets. There is no central server.

Each peer can:
- Send messages to another peer
- Receive messages from another peer
- Maintain a Lamport logical clock
- Display its current Lamport clock
- Handle invalid commands
- Handle failed connections

## Software and Tools

- Java 21
- IntelliJ IDEA
- TCP sockets
- Git and GitHub

## Architecture

Each peer acts as both a client and a server.

- `ServerSocket` listens for incoming connections.
- `Socket` is used to connect to another peer.
- Each peer runs independently.
- Messages are sent directly between peers.

Three peers are used:

| Peer | Port |
|---|---|
| Peer 1 | 5001 |
| Peer 2 | 5002 |
| Peer 3 | 5003 |

## Setup and Running

Open the project in IntelliJ IDEA using Java 21.

Create three run configurations for `Peer.java`.

### Peer 1
Program arguments:
```text
1 5001
```

### Peer 2
Program arguments:
```text
2 5002
```

### Peer 3
Program arguments:
```text
3 5003
```

Run all three peers at the same time.

## Commands
Send a message
```text
connect <port>
```

For example:
```text
connect 5002
```
## Check Lamport clock
```text
clock
```

### Invalid command
Any unsupported command displays an error message and the available commands.

## Message Format
Messages use the following format:
```text
Peer<ID>|<LamportTimestamp>|<Message>
```
Example:
```text
Peer1|1|hello
```

## Lamport logical clock
The project uses Lamport logical clock to represent the order of distributed events.
Before sending a message:
```text
lamportClock[0]++;
```

When receiving a message:
```text
Clock = max(Current
```
For example, if Peer 1 sends a message at time 1, Peer 3 receives it and updates its clock to 2.

## Testing
The system was tested using three running peers.
Tests include:
- Peer 1 sending a message to Peer 3.
- Peer 2 sending a message to Peer 1.
- Receiving messages and updating Lamport clocks.
- Checking the clock using the clock command.
- Entering an invalid command such as banana.
- Connecting to an unavailable port such as connect 1999.

## Repository
The project is maintained using Git and GitHub, with multiple commits showing the development process.
