DROP SCHEMA IF EXISTS stars;
CREATE SCHEMA stars;
USE stars;

CREATE TABLE star_pattern (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    translation VARCHAR(255),
    discovery_period VARCHAR(255),
    pattern_type VARCHAR(255),
    main_star_count VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE stars (
	star_id VARCHAR(255) Not NULL,
	name VARCHAR(255),
	color VARCHAR(255),
        star_type VARCHAR(255),
        pattern_id INT NOT NULL,
	PRIMARY KEY (star_id),
	FOREIGN KEY (pattern_id) REFERENCES star_pattern(id)
);

CREATE TABLE starInformation (
	star_info_id VARCHAR(255) Not NULL,
	name VARCHAR(255),
    	color VARCHAR(255),
        star_type VARCHAR(255),
	    related_myths VARCHAR(255),
        star_age_in_years VARCHAR(255),
        stars_id VARCHAR(255) NOT NULL,
	PRIMARY KEY (star_info_id),
	FOREIGN KEY (stars_id) REFERENCES stars(star_id)
);

INSERT INTO star_pattern (name, translation, discovery_period, pattern_type, main_star_count) VALUES
('Canes Venatici', 'The Hunting Dogs', 'Modern', 'Constellation', 3 ),
('Sagitta', 'The Arrow', 'Ancient', 'Constellation', 4 ),
('Septentrio', 'Seven Plough Oxen', 'Ancient', 'Asterism', 7 ),
('Summer Triangle', 'The Summer Triangle', 'Modern', 'Asterism', 3 ),
('Ursa Minor', 'The Little Bear', 'Ancient', 'Constellation', 7 );

INSERT INTO stars ( star_id, name, color, star_type, pattern_id ) VALUES
('S01', 'Cor Caroli', 'yellow-white', 'main-sequence/ variable binary', 1 ),
('S02', 'Chara', 'yellow', 'main sequence', 1 ),
('S03', '20 Canum Venaticorum', 'yellow-white', 'giant', 1 ),
('S04', 'Sham', 'yellow', 'luminous giant', 2 ),
('S05', 'Beta Sagittae', 'yellow', 'luminous giant', 2 ),
('S06', 'Gamma Sagittae', 'orange-red', 'giant', 2 ),
('S07', 'Delta Sagittae', 'red', 'spectroscopic binary', 2 ),
('S08', 'Alioth', 'blue-white', 'variable', 3 ),
('S09', 'Dubhe', 'blue-white', 'spectroscopic binary', 3 ),
('S10', 'Alkaid', 'blue', 'main sequence', 3 ),
('S11', 'Mizar', 'blue-white', 'spectroscopic binary', 3 ),
('S12', 'Megrez', 'blue-white', 'main sequence', 3 ),
('S13', 'Phecda', 'blue-white', 'main sequence', 3 ), 
('S14', 'Merak', 'blue-white', 'main sequence', 3 ),
('S15', 'Altair', 'blue-white', 'subgiant', 4 ),
('S16', 'Deneb', 'blue-white', 'evolved supergiant', 4 ),
('S17', 'Vega', 'blue-white', 'main sequence', 4 ),
('S18', 'Polaris', 'yellow-white', 'multiple star system', 5 ),
('S19', 'Kochab', 'orange-red', 'variable giant', 5 ),
('S20', 'Pherkad', 'blue-white', 'giant', 5 ),
('S21', 'Yildun', 'blue-white', 'main sequence', 5 ),
('S22', 'Epsilon Ursae Minoris', 'yellow', 'giant', 5 ),
('S23', 'Akhfa Al Farkadain', 'blue-white', 'variable', 5 ),
('S24', 'Anwar Al Farkadain', 'yellow-white', 'main sequence', 5 );

INSERT INTO starInformation ( star_info_id, name, color, star_type, related_myths, star_age_in_years, stars_id ) VALUES
('SI01', 'Cor Caroli', 'yellow-white', 'main-sequence/ variable binary',
'Asterion and Chara are the hunting dogs of Boötes', '190 million years', 'S01' ),
('SI02', 'Chara', 'yellow', 'main sequence', 
'Asterion and Chara are the hunting dogs of Boötes', '7.1 million years', 'S01' ),
('SI03', '20 Canum Venaticorum', 'yellow-white', 'giant', 
'Asterion and Chara are the hunting dogs of Boötes', '750 million years', 'S01' );

SELECT * FROM star_pattern;
SELECT * FROM stars;
SELECT * FROM starInformation;
