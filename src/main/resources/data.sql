



INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , marital_state , password ,app_user_role, username)
VALUES (27,'Bachelor','admin@example.com','Admin','Male' ,'Admin','Single','$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Admin','admin');
-- INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , marital_state , password ,app_user_role , username)
-- VALUES (35,'Master','admin2@example.com','Admin2','Female','Admin2','Married','$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Admin','admin2');

INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , marital_state , password ,app_user_role, username)
VALUES (27,'Doctorate','teacher@example.com','Teacher','Male' ,'Teacher','Single','$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Teacher','teacher');
INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , marital_state , password ,app_user_role, username)
VALUES (27,'Diploma','teacher2@example.com','Teacher2','Female' ,'Teacher2','Married','$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Teacher','teacher2');

INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , marital_state , password ,app_user_role, username)
VALUES (27,'Just_a_Student','student@example.com','student','Male' ,'student','Single','$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Student','student');
INSERT INTO application_user (age ,degree , email , first_name , gender , last_name , marital_state , password ,app_user_role, username)
VALUES (27,'Just_a_Student','student2@example.com','student2','Female' ,'student2','Married','$2a$10$O9jWFnnr8i/YfMQ/N8uH9ufCPlIk37MdOF0YIOj.vVoZJlgTxXRam','Student','student2');




INSERT INTO role (name) VALUES ('ADMIN'); -- id -> 1
INSERT INTO role (name) VALUES ('TEACHER'); -- id -> 2
INSERT INTO role (name) VALUES ('STUDENT'); -- id -> 3



INSERT INTO course (description, name)
VALUES ('The Course provides a good insight into cultural ' ||
        'and social topics such as the values, traditions,' ||
        ' social life, religions and geography of the Arab World.' ||
        'The course helps in creating cultural awareness and a ' ||
        'better understanding of the Arabic norms and values. ' ||
        'The course also includes an optional cultural trip.','Arabic');
INSERT INTO course (description, name)
VALUES ('Develops algebraic concepts and skills needed to graph and' ||
' solve linear equations and inequalities. Evaluating algebraic expressions' ||
' and formulas according to the rules of operations is also developed. Not open' ||
' to students with credit for a higher level math course.','Math');
INSERT INTO course (description, name)
VALUES ('English I: This course emphasizes the fundamental language skills of ' ||
        'reading, writing, speaking, listening, thinking, viewing and presenting. ' ||
        'An emphasis on vocabulary and composition skills will be an on-going part of' ||
        ' the program.','English');
INSERT INTO course (description, name)
VALUES ('This curriculum allows students to learn computer science concepts at the same ' ||
        'time as learning other subjects like language arts, math, and science — with more ' ||
        'to come. Through CS Connections, K-12 classrooms can explore their usual subjects in ' ||
        'exciting new ways!','Computer Science');



INSERT INTO announcement (created_at,department,description,published_by)
VALUES (LOCALTIMESTAMP,'Finance','Dear students, please note that the last date for paying fees is 1/12/2022.','admin');
INSERT INTO announcement (created_at,department,description,published_by)
VALUES (LOCALTIMESTAMP,'Admission_and_Registration','Dear students, please ' ||
                       'note that the last date for registration is 9/9/2022, ' ||
                        'after which any new registration application will not be considered','admin');
INSERT INTO announcement (created_at,department,description,published_by)
VALUES (LOCALTIMESTAMP,'Academic','Colleagues, teachers, please note that work will' ||
                                 ' start on 1/10/2022, a week before the students start work, ' ||
                                  'for the purpose of developing semester plans.','admin2');





INSERT INTO student_course (student_id , course_id) VALUES (4,1) ;
INSERT INTO student_course (student_id , course_id) VALUES (4,2);
INSERT INTO student_course (student_id , course_id) VALUES (5,3);
INSERT INTO student_course (student_id , course_id) VALUES (5,4);



INSERT INTO user_role (user_id, role_id) VALUES (1, 1); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (2, 2); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (3, 2); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (4, 3); -- account oneal has Admin Account
INSERT INTO user_role (user_id, role_id) VALUES (5, 3); -- account oneal has Admin Account


