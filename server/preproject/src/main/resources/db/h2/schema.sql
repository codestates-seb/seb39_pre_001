CREATE TABLE `questions` (
  `question_id` int PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255),
  `description` varchar(255),
  `created_at` datetime,
  `modified_at` datetime,
  `user_id` int,
  `answer_count` int,
  `like_count` int,
  `dislike_count` int
);

CREATE TABLE `users` (
  `user_id` int PRIMARY KEY AUTO_INCREMENT,
  `display_name` varchar(255),
  `password` varchar(255),
  `email` varchar(255),
  `regdate` datetime
);

CREATE TABLE `questions_likes` (
  `question_like_id` int PRIMARY KEY AUTO_INCREMENT,
  `question_id` int,
  `user_id` int
);

CREATE TABLE `questions_dislikes` (
  `question_dislike_id` int PRIMARY KEY AUTO_INCREMENT,
  `question_id` int,
  `user_id` int
);

CREATE TABLE `tags` (
  `tag_id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255)
);

CREATE TABLE `tags_questions` (
  `tag_question_id` int PRIMARY KEY AUTO_INCREMENT,
  `question_id` int,
  `tag_id` int
);

ALTER TABLE `questions` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `questions_likes` ADD FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`);

ALTER TABLE `questions_likes` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `questions_dislikes` ADD FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`);

ALTER TABLE `questions_dislikes` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `tags_questions` ADD FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`);

ALTER TABLE `tags_questions` ADD FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`);
