CREATE TABLE users (
                      id          INTEGER PRIMARY KEY,
                      created   DATE NOT NULL,
                      userName VARCHAR(64) NOT NULL,
                      email VARCHAR(64) NOT NULL,
                      fullName VARCHAR(64) NOT NULL,
                      profilePicture VARCHAR(64) NOT NULL,
                      bio VARCHAR(64) NOT NULL);

CREATE TABLE posts (
                       id          INTEGER PRIMARY KEY,
                       created   DATE NOT NULL,
                       description VARCHAR(64) NOT NULL);

CREATE TABLE likes (
                       id          INTEGER PRIMARY KEY,
                       post_id   INTEGER NOT NULL,
                       user_id INTEGER NOT NULL);

CREATE TABLE follows (
                       follower_id          INTEGER NOT NULL,
                       following_id  INTEGER NOT NULL);

INSERT INTO posts (id, created, description) VALUES
                                                      (1, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post1'),
                                                      (2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post2'),
                                                      (3, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post3'),
                                                      (4, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post4'),
                                                      (5, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post5'),
                                                      (6, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post6'),
                                                      (7, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post7'),
                                                      (8, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post8'),
                                                      (9, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'post9'),;

INSERT INTO users (id, created, userName, email, fullName, profilePicture, bio) VALUES
                                                 (1, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'mustafa', 'mustafa@gmail', 'Mustafa Demir', 'picture', 'born in turkey'),
                                                 (2, TO_DATE('17/12/2015', 'DD/MM/YYYY'), 'jon', 'jon@gmail', 'Jon snow', 'picture', 'born in winterfell');

INSERT INTO likes (id, post_id, user_id) VALUES
    (1, 1, 1);

INSERT INTO follows (follower_id, following_id) VALUES
    (2, 1);