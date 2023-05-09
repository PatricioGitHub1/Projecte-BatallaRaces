insert into PLAYERS (Player_name,Total_Points) values ('Root',150);

insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (1,'Daga','./imagenes/daga.jpg',3,0);
insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (2,'Espasa','./imagenes/espasa.jpg',1,1);
insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (3,'Destral','./imagenes/destral.jpg',0,3);
insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (4,'Espases_dobles','./imagenes/espases_dobles.jpg',2,2);
insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (5,'Simitarra','./imagenes/simitarra.jpg',2,1);
insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (6,'Arc','./imagenes/arc.jpg',5,1);
insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (7,'Katana','./imagenes/katana.jpg',3,2);
insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (8,'Punyal','./imagenes/punyal.jpg',4,0);
insert into WEAPONS (Weapon_id,Weapon_name,Weapon_Image_Path,Speed,Strength) values (9,'Destral_dues_mans','./imagenes/destral_dues_mans.jpg',0,5);

insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (1,'Arwen','./imagenes/elfo1.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (2,'Legolas','./imagenes/elfo2.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (3,'Celeborn','./imagenes/elfo3.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (4,'Míriel','./imagenes/elfo4.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (5,'Thorin','./imagenes/enano1.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (6,'Gimli','./imagenes/enano2.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (7,'Ori','./imagenes/enano3.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (8,'Nori','./imagenes/enano4.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (9,'Cristian','./imagenes/humano1.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (10,'Patricio','./imagenes/humano2.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (11,'Alex','./imagenes/humano3.jpg');
insert into WARRIORS (Warrior_id,Warrior_name,Warrior_Image_Path) values (12,'Cbum','./imagenes/humano4.jpg');


insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (1,1);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (1,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (1,4);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (1,5);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (1,6);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (1,8);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (2,1);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (2,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (2,4);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (2,5);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (2,6);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (2,8);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (3,1);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (3,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (3,4);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (3,5);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (3,6);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (3,8);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (4,1);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (4,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (4,4);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (4,5);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (4,6);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (4,8);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (5,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (5,3);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (5,8);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (5,9);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (6,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (6,3);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (6,8);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (6,9);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (7,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (7,3);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (7,8);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (7,9);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (8,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (8,3);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (8,8);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (8,9);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (9,1);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (9,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (9,3);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (9,4);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (9,5);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (9,7);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (9,8);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (10,1);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (10,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (10,3);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (10,4);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (10,5);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (10,7);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (10,8);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (11,1);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (11,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (11,3);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (11,4);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (11,5);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (11,7);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (11,8);

insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (12,1);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (12,2);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (12,3);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (12,4);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (12,5);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (12,7);
insert into WEAPONS_AVAILABLE (Warrior_id,Weapon_id) values (12,8);

insert into BATTLE (Player_id,Warrior_id,Warrior_Weapon_id,Opponent_id,Opponent_Weapon_id,
Injuries_Caused,Injuries_Suffered,Battle_Points) values(1,2,4,9,8,40,35,100);

insert into ROUNDS (Round_id,Battle_id,Warrior_id,Warrior_Weapon_id,Opponent_id,Opponent_Weapon_id,
Injuries_Caused,Injuries_Suffered) values(1,1,2,4,9,9,7,0);



