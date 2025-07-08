# java-contactbook-app
A simple Java web application for managing contacts (CRUD) built using:
- **Java Servlets & JSP**
- **Apache Tomcat**
- **MySQL**
- **Maven** for build management
---

## Technologies Used

| Tech         | Purpose                          |
|--------------|----------------------------------|
| Java         | Core language                    |
| JSP/Servlets | Web layer                        |
| MySQL        | Database backend                 |
| Maven        | Dependency and build management |
| Tomcat       | Local server for deployment      |
---

## 📁 Project Structure
```
java-contactbook-app/
├── contactbook/ # Java Maven project (main logic)
├── src/ 
├── tomcat/ # Local Tomcat setup for deployment
```
```
cd contactbook/src
 vagrant@vagrant:~/java-contactbook-app/contactbook/src$
.
└── src
    └── main
        ├── java
        │   └── com
        │       └── contactbook
        │           ├── dao
        │           │   └── ContactDAO.java
        │           ├── model
        │           │   └── Contact.java
        │           └── servlet
        │               ├── AddContactServlet.java
        │               ├── DeleteContactServlet.java
        │               ├── EditContactServlet.java
        │               ├── ListContactsServlet.java
        │               └── UpdateContactServlet.java
        ├── resources
        └── webapp
            ├── edit-contact.jsp
            ├── index.jsp
            ├── list-contacts.jsp
            └── WEB-INF

 ```
---

### Prerequisites
- Java 21+
- Apache Maven 3.8+
- MySQL
- Tomcat Server version: Apache Tomcat/11.0.8

###  Build the App

```bash
cd contactbook
mvn clean package
```
.war file will be generated under target/.

### To deploy the app
Copy the .war file into your tomcat webapps/ directory.

#### Install Tomcat
```bash
wget https://downloads.apache.org/tomcat/tomcat-11/v11.0.9/bin/apache-tomcat-11.0.9.tar.gz
tar -xvzf apache-tomcat-11.0.9.tar.gz
mv apache-tomcat-11.0.9 tomcat
```
#### Deploy WAR (Copy WAR file into the Tomcat webapps directory) :
```bash
cp target/contactbook.war ~/java-contactbook-app/tomcat/webapps/
```

Start Tomcat:
```bash
cd ../tomcat/bin
./startup.sh
```
Visit in your browser:
```bash
http://192.168.56.14:8080/contactbook
```

