INSERT INTO Role(id, role)
VALUES (1, 'Admin');
INSERT INTO Role(id, role)
VALUES (2, 'Member');

INSERT INTO User(id, firstname, lastname, email, password,gender, age, description, role, job )
VALUES (1, 'leo','messi','leo@gemail.com','Leo123',MALE,'keine',30, 1,'IT');

INSERT INTO User(id, firstname, lastname, email, password,gender, age, description, role, job )
VALUES (2, 'thomas','albori','thomi@gemail.com','thomA123',MALE,40,'keine',2,'IT');

INSERT INTO Room(id, title, free, Booking)
VALUES(1,'room 10',TRUE, 1)

INSERT INTO Booking(id, title, description, status, user, room, startDate, endDate, halfDay)
VALUES (2,'grossRoom','mit Klima', ACCEPTED, 2, 1, )

