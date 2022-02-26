-- Jsp 프로젝트 데이터베이스

-- 의사 테이블
create table Doctors(
    docID varchar2(20) primary key,
    docPW varchar2(20) not null,
    docName varchar2(20) not null,
    medicalDepartment varchar2(20) not null,
    phoneNum varchar2(20)
);

select * from Doctors;
drop table Doctors;
desc Doctors;

-- 환자 테이블
create table Patients(
    patientID varchar2(20) primary key,
    patientName varchar2(20) not null,
    diagnosis varchar2(50),
    prescription varchar2(255),
    p_docID varchar2(20)
);

select * from Patients;
select count(*) from Patients;
select * from (select * from Patients order by patientid) where ROWNUM between 0 and 0+3;

SELECT * FROM(
    SELECT A.*, ROWNUM AS RNUM FROM(
        SELECT * FROM Patients ORDER BY patientid) 
        A WHERE ROWNUM <= 6+3)
WHERE RNUM > 6;

desc Patients;
drop table Patients;

-- 환자 content
create table Patients_content(
    ID varchar2(20) primary key,
    diagnosis varchar2(50),
    prescription varchar2(255)
);

select * from Patients_content;
desc Patients_content;
drop table Patients_content;