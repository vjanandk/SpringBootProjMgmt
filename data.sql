insert into projects values (1,'2019-12-31','CMOD Migration',90,'2019-09-01');

insert into parenttasks values(1,'Documents Extraction');
insert into parenttasks values(2,'CAT1 Enrichment');
insert into parenttasks values(3,'Migration Engine');

insert into tasks values(1,1,1,'2019-09-15','Build Extraction Scripts',50,'2019-09-01','In Progress');
insert into tasks values(2,1,1,'2019-09-15','Test Extraction Scripts',50,'2019-09-01','In Progress');
insert into tasks values(3,1,1,'2019-09-15','Implement Extraction Scripts',50,'2019-09-01','In Progress');

insert into users values(1,100000,'Vijay Anand','Kannadasan',1,1);
insert into users values(2,200000,'Arun Pandi','Kannadasan',1,3);
