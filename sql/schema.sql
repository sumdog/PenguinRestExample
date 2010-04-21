USE PenguinRest;

CREATE TABLE clients (
	id INT UNSIGNED PRIMARY KEY,
	nm_first VARCHAR(50),
	nm_last  VARCHAR(50)
);

CREATE TABLE offers (
	id INT UNSIGNED PRIMARY KEY,
	svc_name VARCHAR(50)
);

CREATE TABLE locations (
	id INT UNSIGNED PRIMARY KEY,
	customer_id INT UNSIGNED,
	str VARCHAR(100),
	strext VARCHAR(100),
	city VARCHAR(100),
	st VARCHAR(12),
	postal_code VARCHAR(10)
);

CREATE TABLE subscriptions (
	id INT UNSIGNED PRIMARY KEY,
	address_id UNSIGNED INT,
	service_id UNSIGNED INT
);