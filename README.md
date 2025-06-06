# Currency-Xchange
Java Spring Boot microservice for currency and crypto conversion

CurrencyXchange is a Spring Boot microservice that provides real-time currency and cryptocurrency conversion. It integrates with an external exchange rate API, caches rates in a local database for performance, and exposes RESTful endpoints for querying and conversion.

🚀 Features
Real-time currency & crypto exchange rate fetching

Local caching with PostgreSQL or H2

REST API endpoints to:

Convert currency/crypto values

Retrieve all exchange rates

Manually refresh the cache

Built with Spring Boot and Java

🛠️ Tools & Technologies
Tool	Version
Java	17+
Spring Boot	3.1+
PostgreSQL	13+
H2 (optional)	Embedded
Maven	3.6+
REST Template	Native

📦 Project Structure
css
Copy
Edit
CurrencyXchange/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   └── repository/
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
└── README.md
🧰 Setup Instructions
1. Clone the repository
git clone https://github.com/your-username/CurrencyXchange.git
cd CurrencyXchange
2. Configure the Database
Option A: PostgreSQL
Install and run PostgreSQL. Create a database named currencyxchange.
Edit src/main/resources/application.properties:
properties

spring.datasource.url=jdbc:postgresql://localhost:5432/currencyxchange
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
external.api.url=https://api.exchangerateprovider.com
Option B: Use H2 (for testing)
Replace postgresql dependency in pom.xml with:

xml

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
And update application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:h2:mem:currencyxchange
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
external.api.url=https://api.exchangerateprovider.com
3. Build & Run the Application
bash
Copy
Edit
./mvnw spring-boot:run
🌐 API Endpoints
Base URL: http://localhost:8080/api/v1/exchange

Method	Endpoint	Description
GET	/convert	Converts amount (params: from, to, amount)
GET	/rates	Retrieves all cached exchange rates
POST	/refresh	Manually refreshes the cached rates

🧪 Example
GET /api/v1/exchange/convert?from=USD&to=INR&amount=100
Response: 8312.56

✅ Requirements
Java 17 or higher
Maven
PostgreSQL (or use H2 for in-memory DB)

📌 Notes
External API URL must support queries like .../latest?symbol=USD_INR.

Make sure to provide a valid API key if required by your exchange rate provider.

📬 Contact
For questions or collaboration, feel free to connect:
📧 email - irakizoi2607@gmail.com
