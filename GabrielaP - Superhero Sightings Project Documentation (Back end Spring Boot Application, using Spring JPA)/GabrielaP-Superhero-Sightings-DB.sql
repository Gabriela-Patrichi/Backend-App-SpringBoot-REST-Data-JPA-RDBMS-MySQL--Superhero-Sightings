DROP DATABASE IF EXISTS superhero_sightings;

CREATE DATABASE superhero_sightings;

USE superhero_sightings;

-- type_details (for heroes/villains and organizations superheroes/supervillains)
CREATE TABLE super_type_details(
type_id INT AUTO_INCREMENT PRIMARY KEY,
type_name VARCHAR (13) NOT NULL,
type_description TINYTEXT NOT NULL
);

-- super table (supers can be heros or villains - super_type_details) 
CREATE TABLE super_details(
super_id INT AUTO_INCREMENT PRIMARY KEY,
super_name VARCHAR(100) NOT NULL,
super_description VARCHAR(255),
super_type INT NOT NULL,
super_power VARCHAR(150) NOT NULL, -- 1 hero has 1 superpower, and at the same time, the superpower is unique to only 1 superhero
FOREIGN KEY (super_type) REFERENCES super_type_details(type_id)
);

-- organization table
CREATE TABLE organization_details(
org_id INT auto_increment PRIMARY KEY,
org_name VARCHAR(100) NOT NULL,
org_description VARCHAR(255),
org_contact_info VARCHAR(150),
org_type INT NOT NULL,
FOREIGN KEY (org_type) REFERENCES super_type_details(type_id)
);

-- because superhero - organization represents a many-to-many relationship
-- hero_organization table 
CREATE TABLE super_organization(
super_org_id INT AUTO_INCREMENT PRIMARY KEY,
super_id INT, 
org_id INT,
FOREIGN KEY (super_id) REFERENCES super_details(super_id),
FOREIGN KEY (org_id) REFERENCES organization_details(org_id)
);


-- location table
CREATE TABLE location_details(
location_id INT AUTO_INCREMENT PRIMARY KEY,
location_name VARCHAR (100) NOT NULL,
location_desc VARCHAR(255),
location_address VARCHAR (255) NOT NULL,
location_latitude DECIMAL (8,6) NOT NULL,
location_longitude DECIMAL (9,6) NOT NULL
);

-- sighting details table 
CREATE TABLE sighting_details(
sighting_id INT AUTO_INCREMENT PRIMARY KEY,
location_id INT NOT NULL,
sighting_date DATE NOT NULL, 
FOREIGN KEY (location_id) REFERENCES location_details(location_id)
);

-- because superhero - sighting represents a many-to-many relationship
-- superhero_sighting table
DROP TABLE if exists super_sighting;
CREATE TABLE super_sighting(
super_sighting_id INT AUTO_INCREMENT PRIMARY KEY,
sighting_id INT,
super_id INT,
-- FK CONSTRAINTS
FOREIGN KEY (super_id) REFERENCES super_details(super_id),
FOREIGN KEY (sighting_id) REFERENCES sighting_details(sighting_id)
);
