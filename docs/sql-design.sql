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
insert into site values (null, 'MySite', '안녕하세요, 안지민의 MySite에 오신 것을 환영합니다.', '/assets/images/profile.png', '이 사이트는  웹 프로그램밍 실습과제 예제 사이트입니다.<br>
						메뉴는  사이트 소개, 방명록, 게시판이 있구요. Java 수업 + 데이터베이스 수업 + 웹프로그래밍 수업 배운 거 있는거 없는 거 다 합쳐서
						만들어 놓은 사이트 입니다.<br><br>');
select * from site;

select title, welcome, profile, description
			from site
			order by no asc
			limit 0, 1;
update site set title='YourSite' where no =1;
update site set title='MySite', welcome='Welcome to my site', profile='/assets/images/profile.png', description='환영의 인사'
		where no =1;
update site set title='MySite3', welcome='3 Welcome to my site', description='23환영의 인사2'
		where no =1;
desc gallery;
select * from gallery;

-- /assets/upload-images/20231774236846.jpeg
insert into gallery values (null, url, comments);
delete from gallery where no = 1 ;
