USE CommunityPortalDB;

/* =========================
   USERS
========================= */

INSERT INTO Users VALUES
(1,'Rahul Sharma','rahul@gmail.com','Hyderabad','2025-01-10'),
(2,'Priya Reddy','priya@gmail.com','Chennai','2025-01-15'),
(3,'Amit Kumar','amit@gmail.com','Bangalore','2025-02-01'),
(4,'Sneha Rao','sneha@gmail.com','Hyderabad','2025-02-10'),
(5,'Kiran Patel','kiran@gmail.com','Mumbai','2025-03-05');


/* =========================
   EVENTS
========================= */

INSERT INTO Events VALUES
(101,'Music Festival',
'Live Music Event',
'Hyderabad',
'2025-06-10',
'2025-06-11',
'Upcoming',
1),

(102,'Food Carnival',
'Food Exhibition',
'Chennai',
'2025-06-15',
'2025-06-16',
'Upcoming',
2),

(103,'Dance Competition',
'Dance Event',
'Bangalore',
'2025-06-20',
'2025-06-20',
'Upcoming',
3),

(104,'Book Fair',
'Book Exhibition',
'Hyderabad',
'2025-05-10',
'2025-05-11',
'Completed',
1);


/* =========================
   SESSIONS
========================= */

INSERT INTO Sessions VALUES

(1,101,
'Rock Night',
'DJ Arjun',
'2025-06-10 18:00:00',
'2025-06-10 20:00:00'),

(2,101,
'Classical Music',
'Anita Rao',
'2025-06-11 10:00:00',
'2025-06-11 12:00:00'),

(3,102,
'Street Foods',
'Chef Kumar',
'2025-06-15 10:00:00',
'2025-06-15 12:00:00'),

(4,103,
'Hip Hop Dance',
'Ravi Dance',
'2025-06-20 15:00:00',
'2025-06-20 17:00:00');


/* =========================
   REGISTRATIONS
========================= */

INSERT INTO Registrations VALUES

(1,1,101,'2025-05-01'),
(2,2,101,'2025-05-02'),
(3,3,102,'2025-05-03'),
(4,4,103,'2025-05-04'),
(5,5,104,'2025-04-25');


/* =========================
   FEEDBACK
========================= */

INSERT INTO Feedback VALUES

(1,1,101,5,'Excellent Event','2025-06-12'),

(2,2,101,4,'Very Good Event','2025-06-12'),

(3,3,102,5,'Amazing Food Festival','2025-06-17'),

(4,5,104,3,'Good Event','2025-05-12');


/* =========================
   RESOURCES
========================= */

INSERT INTO Resources VALUES

(1,101,
'PDF',
'https://sample.com/music-guide.pdf',
'2025-06-01'),

(2,101,
'Video',
'https://sample.com/music-video.mp4',
'2025-06-02'),

(3,102,
'PDF',
'https://sample.com/food-guide.pdf',
'2025-06-05'),

(4,103,
'Presentation',
'https://sample.com/dance-ppt.pptx',
'2025-06-10');