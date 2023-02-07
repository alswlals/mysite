-- user
desc user;
select * from user;
-- join
insert into user values(null, 'test', 'test@test.com', password('test'),'male',now());

-- login
-- 해당되는 값을 반환시켜주기 
select no, name from user where email='test03@test.com' and password = password('test');

alter table user add column role enum("ADMIN","USER") default "USER" after gender;
insert into user values(null, '관리자', 'admin@mysite.com', password('1234'), 'male', "ADMIN", now());

desc site;
insert into site values (null, 'MySite', '안녕하세요, 안지민의 MySite에 오신 것을 환영합니다.', '/assets/images/profile.png', '');
select * from site;