insert into role (role_name) values ("ADMIN");
insert into role (role_name) values ("REG_USER");
insert into role (role_name) values ("ADD_USER");
insert into role (role_name) values ("ORG_USER");

insert into user (first_name,last_name,email,login,password) values ("Artur","Borkowski","s12020@pjwstk.edu.pl","s12020","Haslo1234")
insert into user (first_name,last_name,email,login,password) values ("Zbychu","Kowalski","z.kowal@o2.pl","zkow","128dahh1jhg2")

insert into user_role (user_id,role_id) values (1,1);
insert into user_role (user_id,role_id) values (1,2);
insert into user_role (user_id,role_id) values (2,2);

insert into task_status (name) values ("TODO");
insert into task_status (name) values ("INPROGRESS");
insert into task_status (name) values ("DONE");

insert into schedule (user_id) values (1);

insert into task (name, description, schedule_id, status_id, due_date) values ("Zrobić inżynierkę", "Napisać i obronić aplikację AJDU",1,2,date("2017-06-30"))
insert into task (name, description, schedule_id, status_id, due_date) values ("Zaliczyć semestr", "Pozaliczać wszystkie inne przedmioty",1,1,date("2017-02-14"))

insert into category (name) values ("Sala weselna");
insert into category (name) values ("Zespół");
insert into category (name) values ("Catering");
insert into category (name) values ("Obsługa");
insert into category (name) values ("Fotografia");
insert into category (name) values ("Film");
insert into category (name) values ("Fryzjer");
insert into category (name) values ("Kwiaciarnia");
insert into category (name) values ("Wystrój");
insert into category (name) values ("Samochód");
insert into category (name) values ("Koordynacja");
insert into category (name) values ("Hotel");
insert into category (name) values ("Transport");
insert into category (name) values ("Odzież");
insert into category (name) values ("Atrakcje dodatkowe");

insert into address (city, country, line1, line2, postal_code, region) values ("Gdansk", "PL","Sala Weselna \"Olimp\"","Kartuska 123","80-012","pomorskie");
insert into address (city, country, line1, line2, postal_code, region) values ("Wejherowo", "PL","Restauracja \"Nova\"","Lęborska 12H","80-240","pomorskie");

insert into organization (name,login,password,email,address_id) values ("Sala Weselna \"Olimp\"","olimp_gda","salaweslna123a","olimp_gdansk@firma.pl",1);

insert into organization_category (organization_id,category_id) values (1,1);
insert into organization_category (organization_id,category_id) values (1,3);
insert into organization_category (organization_id,category_id) values (1,4);
insert into organization_category (organization_id,category_id) values (1,12);

insert into service (name, cost, organization_id) values ("pierwsza",1200.00,1);
insert into service (name, cost, organization_id) values ("druga",1350.00,1);
insert into service (name, cost, organization_id) values ("trzecia",1050.00,1);

insert into package (name, user_id) values ("Nowy Pakiet", 1);

insert into package_service (package_id, service_id) values (1,1);
insert into package_service (package_id, service_id) values (1,2);
insert into package_service (package_id, service_id) values (1,3);