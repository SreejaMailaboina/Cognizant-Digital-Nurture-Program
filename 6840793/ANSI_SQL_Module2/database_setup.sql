/* =========================================
   CREATE DATABASE
========================================= */

CREATE DATABASE IF NOT EXISTS CommunityPortalDB;

USE CommunityPortalDB;


/* =========================================
   USERS TABLE
========================================= */

CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(50),
    registration_date DATE
);


/* =========================================
   EVENTS TABLE
========================================= */

CREATE TABLE Events (
    event_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    city VARCHAR(50),
    start_date DATE,
    end_date DATE,
    status VARCHAR(20),
    organizer_id INT
);


/* =========================================
   SESSIONS TABLE
========================================= */

CREATE TABLE Sessions (
    session_id INT PRIMARY KEY,
    event_id INT,
    title VARCHAR(100),
    speaker_name VARCHAR(100),
    start_time DATETIME,
    end_time DATETIME,
    FOREIGN KEY (event_id)
        REFERENCES Events(event_id)
);


/* =========================================
   REGISTRATIONS TABLE
========================================= */

CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY,
    user_id INT,
    event_id INT,
    registration_date DATE,

    FOREIGN KEY (user_id)
        REFERENCES Users(user_id),

    FOREIGN KEY (event_id)
        REFERENCES Events(event_id)
);


/* =========================================
   FEEDBACK TABLE
========================================= */

CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY,
    user_id INT,
    event_id INT,
    rating INT,
    comments VARCHAR(255),
    feedback_date DATE,

    FOREIGN KEY (user_id)
        REFERENCES Users(user_id),

    FOREIGN KEY (event_id)
        REFERENCES Events(event_id)
);


/* =========================================
   RESOURCES TABLE
========================================= */

CREATE TABLE Resources (
    resource_id INT PRIMARY KEY,
    event_id INT,
    resource_type VARCHAR(50),
    resource_url VARCHAR(255),
    uploaded_at DATE,

    FOREIGN KEY (event_id)
        REFERENCES Events(event_id)
);