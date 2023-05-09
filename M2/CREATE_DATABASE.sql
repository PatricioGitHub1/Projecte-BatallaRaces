
drop database if exists RacesPAC;
create database RacesPAC character set utf8;
use RacesPAC;

create table if not exists WEAPONS(
Weapon_id int primary key,
Weapon_name varchar(30),
Weapon_Image_Path varchar(100),
Speed int,
Strength int);

create table if not exists WARRIORS(
Warrior_id int primary key auto_increment,
Warrior_name varchar(45),
Warrior_Image_Path varchar (100));

create table if not exists PLAYERS(
Player_id int primary key auto_increment,
Player_name varchar(45),
Total_Points int);

create table if not exists WEAPONS_AVAILABLE(
Warrior_id int not null,	
Weapon_id int);

create table if not exists BATTLE(
Battle_id int  primary key auto_increment,
Player_id int,
Warrior_id int,
Warrior_Weapon_id int,
Opponent_id int,
Opponent_Weapon_id int,
Injuries_Caused int,
Injuries_Suffered int,
Battle_Points int);


create table if not exists ROUNDS(
Round_id int,
Battle_id int,
Warrior_id int,
Warrior_Weapon_id int,
Opponent_id int,
Opponent_Weapon_id int,
Injuries_Caused int,
Injuries_Suffered int);


alter table ROUNDS add constraint PK_ROUNDS primary key (Round_id,Battle_id);
alter table BATTLE add constraint FK_PLAYER_BATTLE
	foreign key(Player_id)
    references PLAYERS(Player_id);

alter table ROUNDS add constraint FK_BATTLE_ROUNDS
foreign key(Battle_id)
	references BATTLE(Battle_id);
    
    alter table WEAPONS_AVAILABLE add constraint FK_WARRIORS_WEAPONS_AVAILABLE
foreign key(Warrior_id)
	references WARRIORS(Warrior_id);
    
    
    alter table WEAPONS_AVAILABLE add constraint FK_WEAPONS_WEAPONS_AVAILABLE
foreign key(Weapon_id)
	references WEAPONS(Weapon_id);
    
    
    
    
alter table BATTLE add constraint FK_WARRIORS_BATTLE
foreign key(Warrior_id)
	references WARRIORS(Warrior_id);
    
alter table BATTLE add constraint FK_OPPONENT_BATTLE
foreign key(Opponent_id)
	references WARRIORS(Warrior_id);
    
    
    
    
alter table BATTLE add constraint FK_OPPONENTW_BATTLE
foreign key(Opponent_Weapon_id)
	references WEAPONS(Weapon_id);
    
    
alter table BATTLE add constraint FK_WEAPONS_BATTLE
foreign key(Warrior_Weapon_id)
	references WEAPONS(Weapon_id);
    


    
    






