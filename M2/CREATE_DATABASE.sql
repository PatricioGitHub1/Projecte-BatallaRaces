use sys;
drop database if exists RacesPAC;
create database RacesPAC character set utf8;
use RacesPAC;

create table if not exists WEAPONS(
Weapon_id int primary key auto_increment,
Weapon_name varchar(30),
Weapon_Image_Path varchar(100));

create table if not exists WARRIORS(
Warrior_id int primary key auto_increment,
Warrior_name varchar(45),
Warrior_Image_Path varchar (100));

create table if not exists PLAYERS(
player_id int,
player_name varchar(45));

create table if not exists WEAPONS_AVAILABLE(
Warrior_id int,	
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
Round_id int primary key auto_increment,
Battle_id int,
Warrior_id int,
Warrior_Weapon_id int,
Opponent_id int,
Opponent_Weapon_id int,
Injuries_Caused int,
Injuries_Suffered int,
Battle_Points int);


    
    






