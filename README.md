# Library Management System

This project is a comprehensive refactoring of a Library Management System, aimed at implementing **SOLID Principles**, **Layered Architecture**, and **Advanced Java Features** (Generics, Lambdas, Reflection, Streams) as per Assignment 4 requirements.
 

Architecture Design (Layered)

The application follows a strict separation of concerns using a **Layered Architecture**:

1.  **Controller Layer** (`controller.LibraryController`)
    * Handles user interaction via CLI (Command Line Interface).
    * Delegates business logic to the Service layer.
2.  **Service Layer** (`service.BookService`)
    * Contains business rules and input validation.
    * Follows **SRP** by focusing only on business logic.
3.  **Repository Layer** (`repository.BookRepositoryImpl`)
    * Handles direct communication with the **PostgreSQL** database using JDBC.
    * Implements a generic `CrudRepository<T>` interface.
4.  **Model Layer** (`model.*`)
    * Defines the data structure (`BookBase`) and specific entities (`EBook`, `PhysicalBook`).

---

# SOLID Principles Implementation

This project strictly adheres to the 5 SOLID principles:

# 1. Single Responsibility Principle (SRP)
* **Applied:** Each class has a single purpose. `BookBase` manages data, `BookRepository` manages SQL queries, and `BookService` manages logic.
* **Benefit:** Changes to the database logic do not affect business rules.

# 2. Open/Closed Principle (OCP)
* **Applied:** The system allows adding new book types (e.g., `AudioBook`) without modifying the existing `BookService` or `BookRepository` logic.
**Mechanism:** `BookBase` is abstract, and specific behaviors are extended in `EBook` and `PhysicalBook`.

# 3. Liskov Substitution Principle (LSP)
* **Applied:** `EBook` and `PhysicalBook` can be used interchangeably wherever `BookBase` is expected.
* **Example:** The repository accepts `BookBase`, so it can save any subclass without checking the specific type manually.

# 4. Interface Segregation Principle (ISP)
* **Applied:** Instead of a large "God Interface", we use small, specific interfaces:
    * `Validatable` (for validation logic)
    * `PricedItem` (for pricing logic)
    * `CrudRepository` (for database logic)

# 5. Dependency Inversion Principle (DIP)
* **Applied:** High-level modules (`BookService`) do not depend on low-level modules (`BookRepositoryImpl`).
* **Mechanism:** `BookService` depends on the **abstraction** (`BookRepository` interface).The implementation is injected via the constructor in `Main.java`

---

#  Advanced OOP Features

1. Generics 
* **Usage:** Used in the Repository layer to define a standard CRUD contract for any entity type.
* **Code:** `public interface CrudRepository<T>`

2. Lambda Expressions
* **Usage:** Used in `BookService` to sort books by name concisely.
* **Code:** `books.sort((b1, b2) -> b1.getName().compareToIgnoreCase(b2.getName()));`

3. Reflection API
* **Usage:** A utility class `ReflectionUtils` inspects the `PhysicalBook` class at runtime, printing its fields and methods dynamically.

4. Interface Default & Static Methods 
* **Usage:** The `Validatable` interface includes a `default` method (`logValidation`) to provide shared logging behavior and a `static` method (`isPositive`) for utility checks.

---

# 🗄️ Database Schema

The project uses **PostgreSQL**.

**Schema Setup:**
```sql
CREATE DATABASE library_db;

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author_name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL
);

# Screenshots

# 1. Application Menu & Reflection Output
*Shows the console menu and the ReflectionUtils output inspecting the class structure.*
![Application Menu](![img.png](img.png))

# 2. Database Structure (PostgreSQL)
*Shows the `library_db` and `books` table successfully created.*

![Database Structure](![img_1.png](img_1.png))
