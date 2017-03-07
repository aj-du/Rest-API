insert into user (first_name,last_name,email,login,password) values ("Artur","Borkowski","s12020@pjwstk.edu.pl","s12020","Haslo1234")
insert into user (first_name,last_name,email,login,password) values ("Zbychu","Kowalski","z.kowal@o2.pl","zkow","128dahh1jhg2")

insert into user_role (user_id,role) values (1,"ADMIN");
insert into user_role (user_id,role) values (1,"REG_USER");
insert into user_role (user_id,role) values (2,"REG_USER");


insert into schedule (user_id) values (1);

insert into task (name, description, schedule_id,status, due_date) values ("Zrobić inżynierkę", "Napisać i obronić aplikację AJDU",1,"TODO",date("2017-06-30"))
insert into task (name, description, schedule_id,status, due_date) values ("Zaliczyć semestr", "Pozaliczać wszystkie inne przedmioty",1,"TODO", date("2017-02-14"))


insert into address (city, country, line1, line2, postal_code, region) values ("Gdansk", "PL","Sala Weselna \"Olimp\"","Kartuska 123","80-012","pomorskie");
insert into address (city, country, line1, line2, postal_code, region) values ("Wejherowo", "PL","Restauracja \"Nova\"","Lęborska 12H","80-240","pomorskie");

insert into organization (name,login,password,email,address_id) values ("Sala Weselna \"Olimp\"","olimp_gda","salaweslna123a","olimp_gdansk@firma.pl",1);

insert into service (name, cost, organization_id) values ("pierwsza",1200.00,1);
insert into service (name, cost, organization_id) values ("druga",1350.00,1);
insert into service (name, cost, organization_id) values ("trzecia",1050.00,1);

insert into service_category (service_id, category) values (3,"Sala_Weselna");
insert into service_category (service_id, category) values (3,"Obsluga");
insert into service_category (service_id, category) values (2,"Obsluga");

insert into package (name, user_id) values ("Nowy Pakiet", 1);

insert into package_service (package_id, service_id) values (1,1);
insert into package_service (package_id, service_id) values (1,2);
insert into package_service (package_id, service_id) values (1,3);