create table `user` (
	`email`    varchar(40) not null, 
	`password` varchar(20) not null, 
	`name`     varchar(50) not null  
);


alter table `user`
	add constraint `pk_user` 
		primary key (
			`email` 
		);


create table `community` (
	`com_no`   integer      not null, 
	`com_nm`   varchar(255) not null, 
	`com_des`  varchar(255) not null, 
	`com_date` timestamp    not null  
);


alter table `community`
	add constraint `pk_community`
		primary key (
			`com_no`
		);

alter table `community`
	modify column `com_no` integer not null auto_increment;

alter table `community`
	auto_increment = 1;

create table `club` (
	`club_no`     integer      not null, 
	`com_no`      integer      not null, 
	`category_no` integer      not null,
	`club_nm`     varchar(255) not null, 
	`club_des`    varchar(255) not null, 
	`club_date`   timestamp    not null  
);

alter table `club`
	add constraint `pk_club` 
		primary key (
			`club_no` 
		);

alter table `club`
	modify column `club_no` integer not null auto_increment;

alter table `club`
	auto_increment = 1;

create table `communitymember` (
	`email`      varchar(40) not null, 
	`com_no`     integer     not null, 
	`is_manager` char(1)     null      
);

alter table `communitymember`
	add constraint `pk_communitymember`
		primary key (
			`email`, 
			`com_no`  
		);


create table `clubmember` (
	`email`   varchar(40) not null, 
	`club_no` integer     not null, 
	`type`    char(1)     not null  
);

alter table `clubmember`
	add constraint `pk_clubmember` 
		primary key (
			`email`,   
			`club_no`  
		);


create table `clubcategory` (
	`category_no` integer     not null, 
	`com_no`      integer     not null, 
	`category_nm` varchar(50) not null  
);


alter table `clubcategory`
	add constraint `pk_clubcategory` 
		primary key (
			`category_no`, 
			`com_no`      
		);