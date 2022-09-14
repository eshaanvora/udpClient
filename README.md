# udpclient
This repository contains a MyUdpClient.java program and a UdpServer.java program.
The Client repeatedly prompts the user to type a sentence until the user types "Goodbye".
Before prompting the user for the next sentence, the Client sends the inputted sentence to the Server and the Server returns a capitalized version of the sentence to the Client. 


## Identifying Information

* Name: Eshaan Vora
* Email: EshaanVora@gmail.com

## Source Files  
* MyUdpClient.java
* UdpServer.java
* udp.input

## References

* Geeksforgeeks.org/working-udp-datagramsockets-java/

## Known Errors

* N/A

## Build Insructions
* Compile: javac MyUdpClient.java , javac UdpServer.java
* Run: java MyUdpClient , java UdpServer

## Execution Instructions
* Run checkstyle linter: checkstyle MyUdpClient.java
* Run with input file: java MyUdpClient < udp.input
