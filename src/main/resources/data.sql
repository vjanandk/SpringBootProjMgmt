insert into projects values (1,'2019-12-31','FileNet Migration',30,'2019-09-01');
insert into projects values (2,'2019-12-31','CMOD Migration',90,'2019-09-01');

insert into parenttasks values(1,'Documents Extraction');
insert into parenttasks values(2,'CAT1 Enrichment');
insert into parenttasks values(3,'Migration Engine');
insert into parenttasks values(4,'Bundling & Transfer');
insert into parenttasks values(5,'CAT3 Enrichment');
insert into parenttasks values(6,'Bulk Load');

insert into tasks values(1,'2019-09-15','Build Extraction Scripts',50,'2019-09-01','In Progress',1,1);
insert into tasks values(2,'2019-09-15','Test Extraction Scripts',50,'2019-09-01','In Progress',1,1);
insert into tasks values(3,'2019-09-15','Implement Extraction Scripts',50,'2019-09-01','In Progress',1,1);
insert into tasks values(4,'2019-09-15','Build CAT1 Enrichment Scripts',50,'2019-09-01','In Progress',2,1);
insert into tasks values(5,'2019-09-15','Test CAT1 Enrichment Scripts',50,'2019-09-01','In Progress',2,1);
insert into tasks values(6,'2019-09-15','Implement CAT1 Enrichment Scripts',50,'2019-09-01','In Progress',2,1);
insert into tasks values(7,'2019-09-15','Build Migration Engine Scripts',50,'2019-09-01','In Progress',3,1);
insert into tasks values(8,'2019-09-15','Test Migration Engine Scripts',50,'2019-09-01','In Progress',3,1);
insert into tasks values(9,'2019-09-15','Implement Migration Engine Scripts',50,'2019-09-01','In Progress',3,1);

insert into users values(1,100000,'Vijay Anand','Kannadasan',1,1);
insert into users values(2,200000,'Arun Pandi','Kannadasan',1,4);