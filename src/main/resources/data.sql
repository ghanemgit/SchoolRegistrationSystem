



-- INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , material_statues , password ,role, username)
-- VALUES (27,2,'admin@example.com','Admin',1 ,'Admin',1,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Admin','admin');
-- INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , material_statues , password ,role , username)
-- VALUES (35,3,'admin2@example.com','Admin2',1,'Admin2',2,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Admin','admin2');
--
INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , material_statues , password ,role, username)
VALUES (27,2,'teacher@example.com','Teacher',1 ,'Teacher',1,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Teacher','teacher');
INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , material_statues , password ,role, username)
VALUES (27,2,'teacher2@example.com','Teacher2',1 ,'Teacher2',1,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Teacher','teacher2');

INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , material_statues , password ,role, username)
VALUES (27,2,'student@example.com','student',1 ,'student',1,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Teacher','student');
INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , material_statues , password ,role, username)
VALUES (27,2,'student2@example.com','student2',1 ,'student2',1,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Student','student2');


-- INSERT INTO role (name) VALUES ('ADMIN'); -- id -> 1
-- INSERT INTO role (name) VALUES ('TEACHER'); -- id -> 2
-- INSERT INTO role (name) VALUES ('STUDENT'); -- id -> 3



-- INSERT INTO user_role (user_id, role_id) VALUES (1, 1); -- account oneal has Admin Account
-- INSERT INTO user_role (user_id, role_id) VALUES (2, 1); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (4, 2); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (5, 2); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (6, 3); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (7, 3); -- account oneal has Admin Account
-- INSERT INTO `account_role` (`account_id`, `role_id`) VALUES (1, 1); -- account jason has Student Account
