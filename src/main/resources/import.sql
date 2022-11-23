INSERT INTO user_role (id, role) VALUES (1,'admin');
INSERT INTO user_role (id, role) VALUES (2,'member');

INSERT INTO coworking_user (job, role_id, description,age, password, email, lastname, firstname, id)
VALUES ('Student',1,'CEO',55, 'Leo123','leo.ll@hotmail.com','leo', 'messi', 1);

INSERT INTO coworking_user (job, role_id, description,age, password, email, lastname, firstname, id)
VALUES ('Informatiker',2,'er ist ruhig',23, 'Manuuu123','manu44@gmail.com','Borli', 'Manuel', 2);

INSERT INTO coworking_user (job, role_id, description,age, password, email, lastname, firstname, id)
VALUES ('lehrer',2,'keine',30, 'Tjsek123','mynameIs@hotmail,com','Alpori', 'Temo', 3);

INSERT INTO booking (user_id, room_id, title, startDate, halfDay, endDate, description, Status, id)
VALUES (2, 1, 'mr', '2022-22-10',TRUE, '2022-23-10','keine',ACCEPTED, 1);

INSERT INTO booking (user_id, room_id, title, startDate, halfDay, endDate, description, Status, id)
VALUES (3, 3, 'mr', '2022-22-10',TRUE, '2022-23-10','keine',ACCEPTED, 2);

INSERT INTO room (title, free,id)
VALUES ('room mit klima', TRUE, 1);

INSERT INTO room (title, free,id)
VALUES ('room ohne klima', FALSE, 2);

INSERT INTO room (title, free,id)
VALUES ('kleines Zimmer', TRUE, 3);

INSERT INTO canteen (Price, name, id)
VALUES (2.5, 'Ahmed', 1);

INSERT INTO canteen (Price, name, id)
VALUES (3.5, 'Ali', 2);

INSERT INTO canteen (Price, name, id)
VALUES (4.5, 'Al', 3);

INSERT INTO canteen_user (snack_idfs, user_idfs)
VALUES (1, 2);

INSERT INTO canteen_user (snack_idfs, user_idfs)
VALUES (2, 3);

INSERT INTO coworking_user_coworking_user(othermembers_id, User_id)
VALUES (1,2);

INSERT INTO coworking_user_coworking_user(othermembers_id, User_id)
VALUES (2,3);



