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

### Prerequisites

You will need the following installed:
* **Java 21** or higher
* **Git**

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/let-fughes/WeatherForecast.git
   ```
2. Change the directory:
  ```bash
  cd WeatherForecast
  ```
3. Start the application throw maven:
   Linux/Mac:
   ```bash
   ./mvnw spring-boot:run
   ```
   Windows:
   ```bash
   mvnw.cmd spring-boot:run
   ```
4. Open http://localhost:8081/v1/weather in your browser.
