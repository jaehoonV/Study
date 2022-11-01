-- 계층형 쿼리

CREATE TABLE EX_TBL_01(
    YR VARCHAR2(4 BYTE) NOT NULL,       -- 년도
    CD VARCHAR2(20 BYTE)	NOT NULL,   -- 코드
    CD_NM VARCHAR2(200 BYTE)NOT NULL,   -- 명칭
    PJT_CD VARCHAR2(30 BYTE),           -- 프로젝트코드
    COST NUMBER DEFAULT 0,              -- 금액
    RMK VARCHAR2(4000 BYTE),            -- 비고
    REGIT VARCHAR2(50 BYTE),            -- 등록자아이디
    REG_DT DATE,                        -- 등록일자
    ITEM_SEQ NUMBER NOT NULL,           -- 아이템시퀀스
    UP_ITEM_SEQ NUMBER NOT NULL         -- 상위아이템시퀀스
);

-- PK 생성
ALTER TABLE EX_TBL_01 ADD CONSTRAINT EX_TBL_01_PK PRIMARY KEY (YR, CD);

-- 데이터 삽입
--insert into EX_TBL_01 values('2022', 'A', '', 'A1101', 10000, '비고', 'jaehoon', sysdate, 1, 0);
--insert into EX_TBL_01 values('2022', 'A-01', '국비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 2, 1);
--insert into EX_TBL_01 values('2022', 'A-02', '지방비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 3, 1);
--insert into EX_TBL_01 values('2022', 'A-03', '자부담', 'A1101', 10000, '비고', 'jaehoon', sysdate, 4, 1);
--insert into EX_TBL_01 values('2022', 'B', '지출', 'A1101', 10000, '비고', 'jaehoon', sysdate, 5, 0);
--insert into EX_TBL_01 values('2022', 'B-01', '공사비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 6, 5);
--insert into EX_TBL_01 values('2022', 'B-01-01', '순공사비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 7, 6);
--insert into EX_TBL_01 values('2022', 'B-01-01-01', '기초생활문화복지', 'A1101', 10000, '비고', 'jaehoon', sysdate, 8, 7);
--insert into EX_TBL_01 values('2022', 'B-01-01-01-01', '청소년사랑방조성', 'A1101', 10000, '비고', 'jaehoon', sysdate, 9, 8);
--insert into EX_TBL_01 values('2022', 'B-01-01-01-02', '주민자치센터리모델링', 'A1101', 10000, '비고', 'jaehoon', sysdate, 10, 8);
--insert into EX_TBL_01 values('2022', 'B-01-01-01-03', '농어민체육센터리모델링', 'A1101', 10000, '비고', 'jaehoon', sysdate, 11, 8);
--insert into EX_TBL_01 values('2022', 'B-01-01-02', '경관개선(경관생태)', 'A1101', 10000, '비고', 'jaehoon', sysdate, 12, 7);
--insert into EX_TBL_01 values('2022', 'B-01-01-02-01', '전통시장정비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 13, 12);
--insert into EX_TBL_01 values('2022', 'B-01-01-02-02', '하늘공원조성', 'A1101', 10000, '비고', 'jaehoon', sysdate, 14, 12);
--insert into EX_TBL_01 values('2022', 'B-01-01-02-03', '생태주차장조성', 'A1101', 10000, '비고', 'jaehoon', sysdate, 15, 12);
--insert into EX_TBL_01 values('2022', 'B-01-01-03', '역량강화', 'A1101', 10000, '비고', 'jaehoon', sysdate, 16, 7);
--insert into EX_TBL_01 values('2022', 'B-01-01-03-01', '교육', 'A1101', 10000, '비고', 'jaehoon', sysdate, 17, 16);
--insert into EX_TBL_01 values('2022', 'B-01-01-03-02', '홍보 및 마케팅', 'A1101', 10000, '비고', 'jaehoon', sysdate, 18, 16);
--insert into EX_TBL_01 values('2022', 'B-01-01-03-03', '컨설팅', 'A1101', 10000, '비고', 'jaehoon', sysdate, 19, 16);
--insert into EX_TBL_01 values('2022', 'B-01-01-04', '기타', 'A1101', 10000, '비고', 'jaehoon', sysdate, 20, 7);
--insert into EX_TBL_01 values('2022', 'B-01-02', '지급자재대', 'A1101', 10000, '비고', 'jaehoon', sysdate, 21, 6);
--insert into EX_TBL_01 values('2022', 'B-01-03', '기타공사비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 22, 6);
--insert into EX_TBL_01 values('2022', 'B-01-03-01', '한전불입금', 'A1101', 10000, '비고', 'jaehoon', sysdate, 23, 22);
--insert into EX_TBL_01 values('2022', 'B-01-03-02', '사유전검사수수료', 'A1101', 10000, '비고', 'jaehoon', sysdate, 24, 22);
--insert into EX_TBL_01 values('2022', 'B-01-03-03', '폐기물처리용역', 'A1101', 10000, '비고', 'jaehoon', sysdate, 25, 22);
--insert into EX_TBL_01 values('2022', 'B-01-03-04', '정밀안전진단비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 26, 22);
--insert into EX_TBL_01 values('2022', 'B-01-03-05', 'BF인증용역', 'A1101', 10000, '비고', 'jaehoon', sysdate, 27, 22);
--insert into EX_TBL_01 values('2022', 'B-02', '보상비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 28, 5);
--insert into EX_TBL_01 values('2022', 'B-03', '시설부대경비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 29, 5);
--insert into EX_TBL_01 values('2022', 'B-03-01', '기본계획비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 30, 29);
--insert into EX_TBL_01 values('2022', 'B-03-02', '세부설계비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 31, 29);
--insert into EX_TBL_01 values('2022', 'B-03-03', '공사감독비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 32, 29);
--insert into EX_TBL_01 values('2022', 'B-03-04', '사업관리비', 'A1101', 10000, '비고', 'jaehoon', sysdate, 33, 29);
--insert into EX_TBL_01 values('2022', 'B-03-05', '잡지출', 'A1101', 10000, '비고', 'jaehoon', sysdate, 34, 29);
--insert into EX_TBL_01 values('2022', 'B-04', '예비비(낙찰자액)', 'A1101', 10000, '비고', 'jaehoon', sysdate, 35, 5);
--insert into EX_TBL_01 values('2022', 'C', '합계', 'A1101', 10000, '비고', 'jaehoon', sysdate, 36, 0);

SELECT
    LPAD(' ',2 * (LEVEL - 1)) || CD_NM as 명칭,
    LEVEL LVL,
    A.*,
    DECODE(CONNECT_BY_ISLEAF,1,'true','false') AS LEAF,
    CASE WHEN LEVEL < TO_NUMBER('5') THEN 'true' ELSE 'false' END AS EXPANDED
FROM
    (SELECT YR, CD, CD_NM, PJT_CD, COST, RMK, ITEM_SEQ, UP_ITEM_SEQ
    FROM EX_TBL_01
    WHERE yr = '2022'
        AND PJT_CD = 'A1101') A
START WITH UP_ITEM_SEQ = '0'
CONNECT BY PRIOR A.ITEM_SEQ = A.UP_ITEM_SEQ
ORDER BY A.CD;