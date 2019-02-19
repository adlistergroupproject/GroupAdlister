USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ad_categories;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    password VARCHAR(256) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(128) NOT NULL,
    description TEXT         NOT NULL,
    view_count  INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ad_categories (
    ad_id INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES users(id)
       ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories (id)
       ON DELETE CASCADE
);

CREATE USER IF NOT EXISTS 'adlister_admin'@'localhost' IDENTIFIED BY 'supersqlpswrd';

GRANT SELECT, INSERT, UPDATE, DELETE ON adlister_db.* TO 'adlister_admin'@'localhost';