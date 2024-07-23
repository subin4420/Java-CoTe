-- 1 평균 일일 대여 요금 구하기
-- 코드를 입력하세요
SELECT ROUND(AVG(DAILY_FEE), 0) as AVERAGE_FEE 
from CAR_RENTAL_COMPANY_CAR where CAR_TYPE = 'SUV';

-- 2 흉부외과 또는 일반외과 의사 목록 출력하기
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD,'%Y-%m-%d') AS HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME ASC;
-- 3 과일로 만든 아이스크림 고르기
SELECT i.Flavor
FROM ICECREAM_INFO as I join FIRST_HALF AS F
ON i.FLAVOR = f.FLAVOR
WHERE TOTAL_ORDER >= 3000 and INGREDIENT_TYPE = 'fruit_based';

-- 4 3월에 태어난 여성 회원 목록 출력하기
-- 코드를 입력하세요 ID, 이름, 성별, 생년월일
SELECT MEMBER_ID,MEMBER_NAME,GENDER,DATE_FORMAT(DATE_OF_BIRTH,'%Y-%m-%d') AS DATE_OF_BIRTH
from member_profile
where DATE_FORMAT(DATE_OF_BIRTH,'%m') = '03' and TLNO IS NOT NULL and GENDER = 'W'
order by MEMBER_ID asc
-- 5 서울에 위치한 식당 목록 출력하기
-- 코드를 입력하세요
SELECT I.REST_ID,REST_NAME,FOOD_TYPE,FAVORITES,ADDRESS,ROUND(AVG(REview_SCORE),2) as SCORE
from REST_INFO I
join REST_REVIEW R ON I.REST_ID = R.REST_ID
Where ADDRESS LIKE "서울%"
Group BY REST_ID
order by SCORE desc, Favorites desc
-- 6 조건에 부합하는 중고거래 댓글 조회하기
-- 코드를 입력하세요
#SELECT * from USED_GOODS_BOARD;
# SELECT * from USED_GOODS_REPLY
# order by BOARD_ID;

select B.Title, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE,"%Y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD B join USED_GOODS_REPLY R
ON B.BOARD_ID = R.BOARD_ID
#WHERE SUBSTR(B.CREATED_DATE, 1, 7) = '2022-10'
where DATE_FORMAT(R.CREATED_DATE, "%Y-%m") = '2022-10'
order by R.CREATED_DATE asc, B.Title asc

# SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
# FROM USED_GOODS_BOARD AS B
# INNER
# JOIN USED_GOODS_REPLY AS R
# ON B.BOARD_ID = R.BOARD_ID
# WHERE SUBSTR(B.CREATED_DATE, 1, 7) = '2022-10'
# ORDER BY R.CREATED_DATE ASC, B.TITLE ASC;
-- 7 인기있는 아이스크림
-- 코드를 입력하세요
SELECT flavor from FIRST_HALF
order by TOTAL_ORDER desc, SHIPMENT_ID asc
-- 8 강원도에 위치한 생산공장 목록 출력하기
-- 코드를 입력하세요
SELECT FACTORY_ID,FACTORY_NAME,ADDRESS
from FOOD_FACTORY
where ADDRESS like "강원도%"
order by FACTORY_ID asc
-- 9 12세 이하인 여자 환자 목록 출력하기
-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE,  COALESCE(TLNO, 'NONE') as TLNO
from PATIENT
where AGE <= 12 and GEND_CD = 'W'
order by AGE desc, PT_NAME asc

-- 10. 조건에 맞는 도서 리스트 출력하기
-- 코드를 입력하세요
SELECT BOOK_ID,DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d')
from book
where year(PUBLISHED_DATE) = '2021' and category = '인문'
order by PUBLISHED_DATE