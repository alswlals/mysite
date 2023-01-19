-- user
desc user;
select * from user;
-- join
insert into user values(null, 'test', 'test@test.com', password('test'),'male',now());

-- login
-- 해당되는 값을 반환시켜주기 
select no, name from user where email='test03@test.com' and password = password('test');