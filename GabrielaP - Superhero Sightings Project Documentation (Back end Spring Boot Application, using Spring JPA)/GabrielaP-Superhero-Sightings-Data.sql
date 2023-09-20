
-- insert data in the super_type_details table
INSERT INTO super_type_details (type_name, type_description) VALUES
('Superhero', 'Superheroes are characterized by their moral code, strong sense of duty, and their willingness to use their powers for the greater good. They fight for justice, protect the innocent, and combat supervillains and other threats to society.'),
('Supervillain','Supervillains use their abilities for nefarious and criminal purposes, engaging in activities such as committing crimes, seeking world domination, or causing chaos and destruction.')
;

-- insert data in the super_details table
INSERT INTO super_details (super_name, super_description,super_type,super_power) VALUES 
('Storm', 'As one of the X-Men, she uses her weather-controlling powers to fight against villains and protect both mutants and humans.',1, 'Weather manipulation'),
('Loki', 'Loki, Prince of Asgard, his tricks and schemes wreak havoc across the realms.', 2, 'God of Mischief') ,
('Spider-Man', 'Your friendly neighbourhood hero.', 1, 'Spider Powers'),
('Magneto', 'Magneto is an Omega Level Mutant. He is one of the most powerful mutant.', 2, ' Magnokinesis'),
('Wonder-Woman', ' Diana Prince is an Amazonian warrior with superhuman strength, agility, and the Lasso of Truth, which compels honesty.', 1, 'Superhuman'),
('Jean', 'Powerful level 5 mutant, with extraordinary telekinesis abilities',1,'Telekinesis'),
('Flash', 'Barry Allen can move at superhuman speeds, allowing him to outrun almost anything and travel through time.',1, 'Superspeed'),
('Thor', 'The God of Thunder can summon and control lightning, wield the enchanted Mjolnir hammer, and has superhuman strength.',1,'Control over Lightning and Thunder'),
('Mystique', 'Mystique has the ability to change her appearance, mimic anyones physical appearance and voice.', 2, 'Shape-Shifting'),
('Sandman', 'The Sandman (Flint Marko) can transform his body into sand, granting him incredible shapeshifting and sand-based attacks.',2,'Sand Manipulation'),
('Poison', 'Poison Ivy (Pamela Isley) has the ability to control and manipulate plants, using them as weapons or for various purposes.', 2,' Control over Plant Life')
;

-- insert data into the organization_details table
INSERT INTO organization_details(org_name,org_description,org_contact_info,org_type) VALUES
('X-Men', ' The X-Men are known for their unique powers and their struggle for mutant rights.','Marvel Universe',1),
('Avengers','Earths Mightiest Heroes','Marvel Universe',1),
('The Brotherhood of Mutants', 'Brotherhood advocates for mutant supremacy over humans and often clashes with the X-Men','Comic Books',2),
('Justice League','The Justice League is dedicated to defending Earth from powerful supervillains and cosmic threats.','DC Universe',1),
('Sinister Six', 'This group is composed of six of Spider-Mans most formidable foes who come together to defeat their common enemy', 'Marvel Comics', 2),
('Legion of Doom', 'Legion of Doom is a gathering of some of DCs most notorious villains','DC Comics',2)
;

-- insert into superhero_organization (after inserting in each separate table - to get the IDs)
INSERT INTO super_organization(super_id, org_id) VALUES
(4,3),
(9,3),
(1,1),
(6,1),
(2,6),
(11,6),
(8,2),
(5,4),
(7,4),
(10,5),
(3,1),
(3,2)
;

-- insert data in the location_details table
INSERT INTO location_details(location_name, location_desc, location_address,location_latitude,location_longitude) VALUES
('Mystic Falls','A small, picturesque town nestled in a valley surrounded by dense forests. Known for its mysterious history and supernatural occurrences.','123 Elm Street, Mystic Falls, USA', 40.724583,-74.180832 ),
('Ironclad Tower','A massive, imposing fortress made of iron and stone, guarding a strategic mountain pass.','Ironclad Road, Citadel Peak, Ironrealm',38.987654,-82.345678),
('Starlight Observatory', 'A state-of-the-art observatory situated on a remote mountain peak, offering breathtaking views of the night sky.','Observatory Road, Starlight Peak, Astronomy Valley',-32.345678,118.901234),
('Phoenix Plaza','The bustling heart of a modern metropolis, with towering skyscrapers, neon lights, and a vibrant nightlife.','789 Downtown Avenue, Phoenix City, Metropolis',34.567890 ,-112.345678),
('Emerald Bay','Seaside with pristine beaches, crystal-clear waters, and a lush tropical landscape.','456 Oceanview Drive, Emerald Bay, Paradise Island', -23.567891, 152.987654),
('Maplewood Park', 'A serene urban park with a scenic pond, walking trails, and a playground for families to enjoy.','123 Maple Avenue, Maplewood, USA',40.712345,-74.123456)
;

-- insert data in the sighting_details table
INSERT INTO sighting_details (location_id, sighting_date) VALUES
(1,'2020-10-10'),
(2,'2020-10-10'),
(3,'2022-01-15'),
(4,'2023-01-01'),
(5,'2022-12-12'),
(6,'2008-08-08'),
(1,'2018-05-05'),
(2,'2023-04-04'),
(3,'2009-09-09'),
(4,'2007-07-07')
;

-- insert data into superhero_sighting
INSERT INTO super_sighting(sighting_id, super_id) VALUES
(1,1),
(1,2),
(1,5),
(2,8),
(2,4),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10)
;

SELECT * FROM super_type_details;
SELECT * FROM super_details;
SELECT * from organization_details;
SELECT * FROM super_organization;
SELECT * FROM location_details;
SELECT * FROM sighting_details;
SELECT * FROM super_sighting;