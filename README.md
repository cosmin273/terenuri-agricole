# Agricultural Land Management System

## 📌 Overview
A comprehensive web application designed to digitize agricultural management. [cite_start]The system allows farmers to map land plots using GPS coordinates, track agricultural activities, manage hybrids/herbicides, and analyze production yields and fuel consumption[cite: 10, 11, 16].

[cite_start]The project is built as a **Full-Stack** solution with a decoupled architecture: a **Java Spring Boot** backend serving a **Vue 3** frontend[cite: 119].

## 🚀 Key Features
* **Geospatial Management:** Draw and measure land plots on Google Maps. [cite_start]Implemented spherical geometry algorithms to calculate **Area (ha)** and **Perimeter (m)** based on coordinate vectors[cite: 12, 361].
* [cite_start]**Farm Activity Tracking:** Log activities (planting, harvesting, fertilizing) linking specific workers to lands and dates[cite: 13, 102].
* [cite_start]**Resource Management:** Database registries for Hybrids (Seeds) and Herbicides with detailed technical specifications[cite: 14, 92].
* [cite_start]**Production Analytics:** Automatic calculation of total yield based on average production per hybrid and land surface[cite: 15, 236].
* [cite_start]**Fuel Consumption:** Annual reporting module for diesel consumption visualization using Chart.js[cite: 16, 258].

## 🛠️ Tech Stack

### Backend
* [cite_start]**Framework:** Spring Boot 3 (Java 17) [cite: 53]
* [cite_start]**Database:** MySQL 8.0 (Relational Schema, ACID compliance) [cite: 59]
* [cite_start]**ORM:** Spring Data JPA + Hibernate (Entity mapping, Cascade policies) [cite: 57, 58]
* [cite_start]**Build Tool:** Maven [cite: 54]

### Frontend
* [cite_start]**Framework:** Vue 3 (Composition API) [cite: 37]
* [cite_start]**Maps:** Google Maps JavaScript API (@googlemaps/js-api-loader) [cite: 44]
* [cite_start]**Styling:** CSS3, Flexbox, Responsive Grid [cite: 35]
* [cite_start]**Tools:** Vite, Axios[cite: 42, 121].

## 🗄️ Database Schema
The application uses a normalized relational database designed in **MySQL Workbench**.
* **Core Entities:** `Teren` (Land), `Coordonate` (GPS Points), `Lucrare` (Work Type), `Producie` (Yield).
* **Relationships:**
    * [cite_start]**1:N** (One-to-Many): One Land has multiple GPS Coordinates[cite: 110].
    * [cite_start]**1:N**: One Land has multiple Production records[cite: 112].
    * [cite_start]**Cascade Deletion:** Deleting a Land automatically removes associated coordinates and activity logs to maintain integrity[cite: 82].

<img width="779" height="610" alt="image" src="https://github.com/user-attachments/assets/b35fbeed-6ee2-44a2-813f-c163ecaa8723" />


## ⚙️ Setup & Installation

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/cosmin273/terenuri-agricole.git](https://github.com/cosmin273/terenuri-agricole.git)
    ```

2.  **Database Configuration**
    * Create a MySQL database named `terenuri_db`.
    * Configure `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/terenuri_db
    spring.datasource.username=user
    spring.datasource.password=Ypassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Run Backend**
    ```bash
    mvn spring-boot:run
    ```

4.  **Run Frontend**
    ```bash
    cd frontend
    npm install
    npm run dev
    ```

## 📬 Contact
**Cosmin Bolohan**
* [**Email:** cosmin_273@yahoo.com
