--地域テーブル--
CREATE TABLE IF NOT EXISTS region(
  region_id INTEGER AUTO_INCREMENT NOT NULL,
  region_name VARCHAR(255) NOT NULL,
  PRIMARY KEY(region_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--教科テーブル--
CREATE TABLE IF NOT EXISTS subject(
  subject_id INTEGER AUTO_INCREMENT NOT NULL,
  subject_name VARCHAR(255) NOT NULL,
  PRIMARY KEY(subject_id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--ユーザーテーブル--
CREATE TABLE IF NOT EXISTS user(
  user_id INTEGER AUTO_INCREMENT,
  mail_address VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(65) NOT NULL,
  user_name VARCHAR(12) NOT NULL,
  profile_image VARCHAR(255),
  gender VARCHAR(10),
  age INTEGER,
  region_id INTEGER,
  self_introduction VARCHAR(300),
  PRIMARY KEY(user_id),
  FOREIGN KEY (region_id)
        REFERENCES region(region_id)
        ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--メッセージテーブル--
CREATE TABLE IF NOT EXISTS message(
  message_id BIGINT AUTO_INCREMENT NOT NULL,
  sender_user_id INTEGER NOT NULL,
  receiver_user_id INTEGER NOT NULL,
  message_content VARCHAR(300),
  message_time datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY(message_id),
  FOREIGN KEY (sender_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE,
  FOREIGN KEY (receiver_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;


--教師テーブル--
CREATE TABLE IF NOT EXISTS teacher(
  teacher_user_id INTEGER NOT NULL,
  max_wage INT,
  min_wage INT NOT NULL,
  policy VARCHAR(300),
  PRIMARY KEY(teacher_user_id),
  FOREIGN KEY (teacher_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--教師の教科--
CREATE TABLE IF NOT EXISTS lesson_subject(
  teacher_user_id INTEGER NOT NULL,
  subject_id INTEGER NOT NULL,
  PRIMARY KEY(teacher_user_id,subject_id),
  FOREIGN KEY (teacher_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE,
  FOREIGN KEY (subject_id)
        REFERENCES subject(subject_id)
        ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--レビューテーブル--
CREATE TABLE IF NOT EXISTS review(
  reviewer_user_id INTEGER NOT NULL,
  reviewee_user_id INTEGER NOT NULL,
  rate INT NOT NULL,
  review_content VARCHAR(300) NOT NULL,
  review_time datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY(reviewer_user_id,reviewee_user_id),
  FOREIGN KEY (reviewer_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE,
  FOREIGN KEY (reviewee_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--マッチング--
CREATE TABLE IF NOT EXISTS matching(
  matching_id INTEGER AUTO_INCREMENT,
  teacher_user_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  region_id INT NOT NULL,
  wage INT NOT NULL,
  application_date datetime,
  approval_date datetime,
  contact_availability BOOLEAN,
  contact_end_time datetime,
  PRIMARY KEY(matching_id),
  FOREIGN KEY (teacher_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE,
  FOREIGN KEY (user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE,
  FOREIGN KEY (region_id)
        REFERENCES region(region_id)
        ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--契約講座--
CREATE TABLE IF NOT EXISTS lesson(
  teacher_user_id INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  day_of_the_week VARCHAR(15) NOT NULL,
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  PRIMARY KEY(teacher_user_id, user_id, day_of_the_week, start_time, end_time),
  FOREIGN KEY (teacher_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE,
  FOREIGN KEY (user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

--指導可能な講座--
CREATE TABLE IF NOT EXISTS lesson_menu(
  teacher_user_id INTEGER  NOT NULL,
  day_of_the_week VARCHAR(15),
  lesson_menu_start_time TIME,
  lesson_menu_end_time TIME,
  PRIMARY KEY(teacher_user_id, day_of_the_week),
  FOREIGN KEY (teacher_user_id)
        REFERENCES user(user_id)
        ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;
