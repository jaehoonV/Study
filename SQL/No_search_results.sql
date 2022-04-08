SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT ENAME FROM EMP
WHERE DEPTNO = 40;

SELECT ENAME FROM EMP
WHERE DEPTNO = 40
UNION ALL -- UNION ALL과 NOT EXISTS를 이용한 출력
SELECT NULL AS ENAME
FROM EMP
WHERE NOT EXISTS 
(SELECT ENAME FROM EMP WHERE DEPTNO = 40)
AND ROWNUM = 1;

-- UNION
-- 쿼리의 결과를 합친다. 
-- 중복된(모든 컬럼값이 같은) row는 제거한다. 
-- 중복된 row를 찾는과정에서 정렬기능작동함
SELECT DEPTNO FROM EMP
UNION
SELECT DEPTNO FROM DEPT;

-- UNION ALL
-- 쿼리의 결과를 합친다. 
-- 모든 컬럼값이 같은 row도 모두 보여준다. 
-- 단순 합치는 것이므로 속도가 빠름
SELECT DEPTNO FROM EMP
UNION ALL
SELECT DEPTNO FROM DEPT;

-- EXISTS, NOT EXISTS
SELECT * FROM EMP
WHERE EXISTS ( -- EXISTS는 조회 결과가 있을때만 조회
               SELECT EMPNO 
                 FROM EMP 
                WHERE EMPNO = '7369'
              );  

SELECT * FROM EMP
WHERE NOT EXISTS ( -- NOT EXISTS는 조회 결과가 없을때만 조회
                   SELECT EMPNO 
                     FROM EMP 
                    WHERE EMPNO = '73691'
                  )