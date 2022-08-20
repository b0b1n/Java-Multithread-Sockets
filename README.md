# Multithread-Sockets
TCP program with multiple threads using Java

# ServerMain
Writing the ServerMain class that is going to launch the server

# ServerThread
Writing the ServerThread class that specifies the instructions to be ran for each thread, in this case, each client connected 

# ServerClient
The client class

# Client_Identification
- Modified the ServerMain class, where when it calls the server_thread it passes itself (this).
And whenever a Client is disconnected is displays its ID.

- Modifed the ServerThread class, to create for each client connected an ID.

- Modified the Client class, by changing the message shown in the console( showing the generated ID for the Client when it connects).
