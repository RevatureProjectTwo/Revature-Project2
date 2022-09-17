DROP TABLE user_details2;

CREATE TABLE user_details2
  (user_id INT GENERATED ALWAYS AS IDENTITY (MINVALUE  1 START WITH 1 INCREMENT BY 1) PRIMARY KEY,
   user_username VARCHAR(50) NOT NULL,
   user_password VARCHAR(100) NOT NULL, 
   user_first_name VARCHAR(100),
   user_last_name VARCHAR(100),
   user_address VARCHAR(300),
   user_email VARCHAR(50),
   user_contact_number VARCHAR(50),
   user_is_employee boolean);

