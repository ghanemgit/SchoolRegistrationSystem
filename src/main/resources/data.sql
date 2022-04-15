INSERT INTO application_user (date_of_birth ,degree , email , first_name , gender , last_name , material_statues , password , username)
VALUES ('15-4-2022',2,'admin@example.com','Admin',1 ,'Admin',1,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','admin');
INSERT INTO application_user (date_of_birth ,degree , email , first_name , gender , last_name , material_statues , password , username)
VALUES ('15-4-2022',3,'admin2@example.com','Admin2',1,'Admin2',2,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','admin2');
--
-- INSERT INTO applicationUsers (date_of_birth ,degree , email , first_name , gender , last_name , material_statues , password , username)
-- VALUES ('15-4-2022',3,'teacher@example.com','Mohammad',1,'Abu-laila',1,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','teacher');
-- INSERT INTO applicationUsers (date_of_birth ,degree , email , first_name , gender , last_name , material_statues , password , username)
-- VALUES ('15-4-2022',5,'teacher2@example.com','Manal',2,'Salameh',4,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','teacher2');
--
-- INSERT INTO applicationUsers (date_of_birth ,degree , email , first_name , gender , last_name , material_statues , password , username)
-- VALUES ('15-4-2022',1,'student@example.com','Mohammad',1,'Ghanem',1,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','student');
-- INSERT INTO applicationUsers (date_of_birth ,degree , email , first_name , gender , last_name , material_statues , password , username)
-- VALUES ('15-4-2022',1,'student2@example.com','Ayah',2,'Ahmad',5,'$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','student2');


INSERT INTO role (name) VALUES ('ADMIN'); -- id -> 1
INSERT INTO role (name) VALUES ('TEACHER'); -- id -> 2
INSERT INTO role (name) VALUES ('STUDENT'); -- id -> 3



INSERT INTO user_role (user_id, role_id) VALUES (1, 1); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (2, 1); -- account oneal has Admin Account
-- INSERT INTO user_role (user_id, role_id) VALUES (3, 2); -- account oneal has Admin Account
-- INSERT INTO user_role (user_id, role_id) VALUES (4, 2); -- account oneal has Admin Account
-- INSERT INTO user_role (user_id, role_id) VALUES (5, 3); -- account oneal has Admin Account
-- INSERT INTO user_role (user_id, role_id) VALUES (6, 3); -- account oneal has Admin Account

-- INSERT INTO `account_role` (`account_id`, `role_id`) VALUES (1, 1); -- account jason has Student Account
