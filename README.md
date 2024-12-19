# Java Chat Application

## **Project Description**
This project is a Java-based client-server chat application that uses **Swing** and **AWT** for the GUI and **Sockets** for network communication. The project includes a client-side and a server-side application, allowing real-time text communication between two systems.

---

## **Features**
### **Client-Side**
- Graphical User Interface (GUI) designed using Swing and AWT.
- Chat interface includes user profile, video, call, and more options icons.
- Send and receive messages in real-time.
- Displays message timestamps.
- Exit application with a back button.

### **Server-Side**
- GUI similar to the client-side for a consistent user experience.
- Handles multiple client connections (basic implementation provided).
- Displays received messages in real-time.
- Sends messages to the connected client.

---

## **Technical Stack**
- **Frontend**: Java Swing and AWT
- **Backend**: Java Sockets for network communication
- **IDE**: IntelliJ IDEA / Eclipse
- **Protocol**: TCP (Transmission Control Protocol)

---

## **How to Run the Project**
### **Prerequisites**
1. Install **Java JDK 8+**.
2. Install any IDE like **IntelliJ IDEA** or **Eclipse**.

### **Steps to Run**
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/java-chat-application.git
2. Open the project in your IDE.
3. Compile and run the Server program:
4. Navigate to the Server.java file and run the main method.
5. Ensure the server is listening on port 6001.
6. Compile and run the Client program:
7. Navigate to the Client.java file and run the main method.
8. The client connects to the server on 127.0.0.1 and port 6001.
9. Start chatting between the client and server!

---

### **Project Structure**
  
  ```bash
     src/
      ├── Client.java    // Client-side application
      ├── Server.java    // Server-side application
      └── icons/         // Images used for GUI elements
```

---

### **Demo**
Here’s how the application looks when running:

**Client-Side**
![image](https://github.com/user-attachments/assets/fdc18ff6-0427-4955-a880-5d80ffe1996a)

**Server-Side**
![image](https://github.com/user-attachments/assets/2338ae35-5f51-4b40-8ea3-7aec1ca46f72)

###  **Acknowledgements**
Developed by [Abhinav Anpan] to explore the fundamentals of Java GUI development and socket programming.

