insert into projects values (1,'2019-12-31','CMOD Migration',28,'2019-09-01');
insert into projects values (2,'2019-12-31','Filenet Migration',15,'2019-09-10');
insert into projects values (3,'2019-12-31','Whirl Hosting',20,'2019-09-20');
insert into projects values (4,'2019-12-31','Colo Migration',10,'2019-10-01');

insert into parenttasks values(1,'Documents Extraction');
insert into parenttasks values(2,'CAT1 Enrichment');
insert into parenttasks values(3,'Migration Engine');

insert into tasks values(1,1,1,'2019-09-15','Build Extraction Scripts',50,'2019-09-01','In Progress');
insert into tasks values(2,1,1,'2019-09-15','Test Extraction Scripts',50,'2019-09-01','In Progress');
insert into tasks values(3,1,1,'2019-09-15','Implement Extraction Scripts',50,'2019-09-01','In Progress');

insert into users values(1,100000,'Vijay','Kannadasan',1,0);
insert into users values(2,200000,'Arun','Kannadasan',3,0);
insert into users values(3,300000,'Maruthu','Kannadasan',2,0);
insert into users values(4,400000,'Selvi','Kannadasan',4,0);
insert into users values(5,500000,'Nandhini','Mahendran',5,0);
insert into users values(6,600000,'Salli','Mahendran',7,0);
insert into users values(7,700000,'Villi','Mahendran',8,0);
insert into users values(8,800000,'Kolli','Mahendran',6,0);

insert into projects values (1,'2019-12-31','CMOD Migration',28,'2019-09-01');
insert into projects values (2,'2019-12-31','Filenet Migration',15,'2019-09-10');
insert into projects values (3,'2019-12-31','Whirl Hosting',20,'2019-09-20');
insert into projects values (4,'2019-12-31','Colo Migration',10,'2019-10-01');