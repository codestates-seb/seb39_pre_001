INSERT INTO USERS(user_id, display_name, password, email, regdate)
VALUES(1, 'user1', '1234', 'user1@gmail.com', current_timestamp);

INSERT INTO USERS(user_id, display_name, password, email, regdate)
VALUES(2, 'user2', '1234', 'user2@gmail.com', current_timestamp);

INSERT INTO USERS(user_id, display_name, password, email, regdate)
VALUES(3, 'user3', '1234', 'user3@gmail.com', current_timestamp);

INSERT INTO USERS(user_id, display_name, password, email, regdate)
VALUES(4, 'user4', '1234', 'user4@gmail.com', current_timestamp);

INSERT INTO USERS(user_id, display_name, password, email, regdate)
VALUES(5, 'user5', '1234', 'user5@gmail.com', current_timestamp);

--
--INSERT INTO TAGS (tag_id, name)
--VALUES(1, 'java');
--
--INSERT INTO TAGS (tag_id, name)
--VALUES(2, 'mysql');
--
--INSERT INTO TAGS (tag_id, name)
--VALUES(3, 'react');

INSERT INTO QUESTIONS(question_id, title, description, user_id)
VALUES (1, 'question1', 'question1', 1);

INSERT INTO QUESTIONS(question_id, title, description, user_id)
VALUES (2, 'question2', 'question2', 2);

--INSERT INTO TAGS_QUESTIONS(tag_question_id, question_id, tag_id)
--VALUES (1, 1, 1);
--
--INSERT INTO TAGS_QUESTIONS(tag_question_id, question_id, tag_id)
--VALUES (2, 1, 2);
--
--INSERT INTO TAGS_QUESTIONS(tag_question_id, question_id, tag_id)
--VALUES (3, 2, 3);

--INSERT INTO ANSWER(answer_id, content, question_id, user_id)
--VALUES (10, '답변 내용1', 1, 1);
--
--INSERT INTO ANSWER(answer_id, content, question_id, user_id)
--VALUES (11, '답변 내용2', 1, 2);