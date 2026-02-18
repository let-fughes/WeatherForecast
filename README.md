# Weather Web Application

![Weather-Web-App](https://github.com/let-fughes/WeatherForecast/blob/master/screenshots/img.png)

A Java-based pet project built with Spring Boot that aggregates and displays weather data from multiple sources. This application allows users to compare forecasts and choose their preferred weather data provider.

---

## Features

* **Multi-Source Integration:** Fetches data from various weather APIs.
* **Source Customization:** Users can choose the weather source manually.
* **Modern Stack:** Built using **Java 21** and **Spring Boot 3**.
* **Clean UI:** Simple web interface to view real-time data.

---

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

## Prerequisites

You will need the following installed:
* **Java 21** or higher
* **Git**

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/let-fughes/WeatherForecast.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd WeatherForecast
   ```
3. **Run the application:**
   <br>
   **Linux/macOS:**
   ```bash
   ./mvnw spring-boot:run
   ```
  **Windows:**
  ```bash
  mvnw.cmd spring-boot:run
  ```
**Or you can run it throw the Docker:**
3. **Build docker image:**
  ```bash
  docker build -t weather-dashboard .
  ```
4. **Run it:**
   ```bash
   docker run -p 8081:8081 \
    -e OPENWEATHER_API_KEY=ваш_ключ_1 \
    -e WEATHERBIT_API_KEY=ваш_ключ_2 \
    weather-dashboard
   ```
## Tech Stack

This project is built using a modern Java development stack, focusing on modularity and seamless integration with external services.

### Backend
* **Java 21** — Utilizing the latest language features like Records and Pattern Matching.
* **Spring Boot 3.x** — The core framework for application development.
* **Spring Web** — For creating REST controllers and handling HTTP requests.
* **Spring Data JPA** — (If applicable) for database management and ORM.
* **Maven** — Project build tool and dependency management.

### Integration & APIs
* **RestTemplate / WebClient** — For interacting with third-party Weather APIs.
* **Jackson** — For efficient JSON deserialization of weather data responses.
* **Lombok** — To reduce boilerplate code (Getters, Setters, Constructors).

### Infrastructure & Tools
| Tool | Description |
| :--- | :--- |
| **Maven Wrapper** | Running the project without a pre-installed Maven instance |
| **Git** | Version control system |
