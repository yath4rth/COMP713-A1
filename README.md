# COMP713 Assessment 2 – Peer-to-Peer Messaging System

## Overview

This project is a small peer-to-peer messaging system developed for COMP713 Assessment 2.

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
