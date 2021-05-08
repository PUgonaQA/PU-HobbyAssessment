DROP TABLE IF EXISTS restaurant_hobby CASCADE;
CREATE TABLE restaurant_hobby (
	id BIGINT AUTO_INCREMENT, 
	dish VARCHAR(255), 
	location VARCHAR(255), 
	rating INTEGER, 
    restaurant_name VARCHAR(255),
	PRIMARY KEY (id));