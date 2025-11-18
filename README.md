# Agricultural Land Management System

## 📌 Overview
A comprehensive web application designed to digitize agricultural management. The system allows farmers to map land plots using GPS coordinates, track agricultural activities, manage hybrids/herbicides, and analyze production yields and fuel consumption.

The project is built as a **Full-Stack** solution with a decoupled architecture: a **Java Spring Boot** backend serving a **Vue 3** frontend.

## 🚀 Key Features
* **Geospatial Management:** Draw and measure land plots on Google Maps. Implemented spherical geometry algorithms to calculate **Area (ha)** and **Perimeter (m)** based on coordinate vectors.
* **Farm Activity Tracking:** Log activities (planting, harvesting, fertilizing) linking specific workers to lands and dates.
* **Resource Management:** Database registries for Hybrids (Seeds) and Herbicides with detailed technical specifications.
* **Production Analytics:** Automatic calculation of total yield based on average production per hybrid and land surface.
* **Fuel Consumption:** Annual reporting module for diesel consumption visualization using Chart.js.

## 🛠️ Tech Stack

### Backend
* **Framework:** Spring Boot 3 (Java 17)
* **Database:** MySQL 8.0 (Relational Schema, ACID compliance)
* **ORM:** Spring Data JPA + Hibernate (Entity mapping, Cascade policies)
* **Build Tool:** Maven

### Frontend
* **Framework:** Vue 3 (Composition API)
* **Maps:** Google Maps JavaScript API (@googlemaps/js-api-loader)
* **Styling:** CSS3, Flexbox, Responsive Grid
* **Tools:** Vite, Axios

## 🗄️ Database Schema
The application uses a normalized relational database designed in **MySQL Workbench**.
* **Core Entities:** `Teren` (Land), `Coordonate` (GPS Points), `Lucrare` (Work Type), `Producie` (Yield).
* **Relationships:**
    * **1:N** (One-to-Many): One Land has multiple GPS Coordinates.
    * **1:N**: One Land has multiple Production records.
    * **Cascade Deletion:** Deleting a Land automatically removes associated coordinates and activity logs to maintain integrity.

![Database Schema](https://github.com/user-attachments/assets/b35fbeed-6ee2-44a2-813f-c163ecaa8723)

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
    spring.datasource.username=YOUR_USERNAME
    spring.datasource.password=YOUR_PASSWORD
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
* **Email:** cosmin_273@yahoo.com
