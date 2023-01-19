-- user
desc user;
select * from user;
-- join
insert into user values(null, 'test', 'test@test.com', password('test'),'male',now());
