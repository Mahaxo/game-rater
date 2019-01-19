REPLACE INTO `roles` VALUES (1,'ADMIN');
REPLACE INTO `roles` VALUES (2,'USER');

REPLACE INTO `platforms` VALUES (1,'Playstation 4');
REPLACE INTO `platforms` VALUES (2,'Nintendo Switch');
REPLACE INTO `platforms` VALUES (3,'Xbox One');
REPLACE INTO `platforms` VALUES (4,'PC');

REPLACE INTO `publishers` VALUES (1,'Nintendo');
REPLACE INTO `publishers` VALUES (2,'Ubisoft');
REPLACE INTO `publishers` VALUES (3,'Electronic Arts');
REPLACE INTO `publishers` VALUES (4,'Square Enix');
REPLACE INTO `publishers` VALUES (5,'Microsoft');
REPLACE INTO `publishers` VALUES (6,'Bandai Namco Games');
REPLACE INTO `publishers` VALUES (7,'Activision Blizzard');
REPLACE INTO `publishers` VALUES (8,'Atlus Co');
REPLACE INTO `publishers` VALUES (9,'Sega');
REPLACE INTO `publishers` VALUES (10,'Capcom');

REPLACE INTO `genres` VALUES (1,'Action');
REPLACE INTO `genres` VALUES (2,'Action-adventure');
REPLACE INTO `genres` VALUES (3,'Adventure');
REPLACE INTO `genres` VALUES (4,'Simulation');
REPLACE INTO `genres` VALUES (5,'Strategy');
REPLACE INTO `genres` VALUES (6,'Sports');

REPLACE INTO `games` VALUES (1, 12, 'Call of Duty', 80.00, 1, 2);
REPLACE INTO `games` VALUES (2, 16,'Red Dead', 60.00, 4, 5);
REPLACE INTO `games` VALUES (3, 18, 'Croc', 54.00, 2, 3);
REPLACE INTO `games` VALUES (4, 6,'Super Mario', 99.00, 6, 10);
REPLACE INTO `games` VALUES (5, 3, 'DBZ', 78.00, 5, 7);
REPLACE INTO `games` VALUES (6, 0, 'Super Smash Bros', 50.00, 2, 4);
REPLACE INTO `games` VALUES (7, 16, 'Splatoon', 89.00, 1, 6);
REPLACE INTO `games` VALUES (8, 10, 'Crash Bandicoot', 65.00, 2, 5);
REPLACE INTO `games` VALUES (9, 6, 'The Darkness', 72.00, 3, 3);
REPLACE INTO `games` VALUES (10, 3, 'Kingdom Hearts', 78.00, 1, 9);