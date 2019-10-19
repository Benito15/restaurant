CREATE DATABASE restaurant;
CREATE USER 'benito15'@'localhost' IDENTIFIED BY 'benito15';
GRANT ALL ON restaurant.* TO 'benito15'@'localhost';
FLUSH PRIVILEGES;


