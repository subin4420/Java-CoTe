#평균 일일 대여 요금 구하기
SELECT ROUND(AVG(DAILY_FEE)) AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV';

#흉부외과 또는 일반외과 의사 목록 출력하기
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') HIRE_YMD
FROM DOCTOR
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
ORDER BY HIRE_YMD DESC, DR_NAME ASC;

#과일로 만든 아이스크림 고르기
SELECT F.FLAVOR FROM FIRST_HALF F
INNER JOIN ICECREAM_INFO I
ON F.FLAVOR = I.FLAVOR
WHERE F.TOTAL_ORDER >= 3000 AND I.INGREDIENT_TYPE = 'fruit_based'
ORDER BY F.TOTAL_ORDER DESC;

#3월에 태어난 여성 회원 목록 출력하기
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE SUBSTR(DATE_OF_BIRTH,6,2) = '03' AND TLNO IS NOT NULL AND GENDER = 'W'
ORDER BY MEMBER_ID ASC;

#서울에 위치한 식당 목록 출력하기
SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(R.REVIEW_SCORE), 2) SCORE
FROM REST_INFO I INNER JOIN REST_REVIEW R ON I.REST_ID = R.REST_ID
WHERE SUBSTR(I.ADDRESS,1,2) = '서울'
GROUP BY REST_ID
ORDER BY 6 DESC, 4 DESC;

#조건에 부합하는 중고거래 댓글 조회하기
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.created_date, '%Y-%m-%d') "CREATED_DATE"
from used_goods_board b
join used_goods_reply r
on b.board_id = r.board_id
where substr(b.created_date,1,7) = '2022-10'
order by r.created_date asc, b.title asc;

#인기있는 아이스크림
SELECT FLAVOR FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC;

#강원도에 위치한 생산공장 목록 출력하기
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE SUBSTR(ADDRESS, 1, 3) = '강원도'
ORDER BY FACTORY_ID ASC;

#12세 이하인 여자 환자 목록 출력하기
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC;

#조건에 맞는 도서 리스트 출력하기
SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') PUBLISHED_DATE
FROM BOOK
WHERE YEAR(PUBLISHED_DATE) = '2021'
AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE ASC;

#재구매가 일어난 상품과 회원 리스트 구하기
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(PRODUCT_ID) >= 2
ORDER BY USER_ID, PRODUCT_ID DESC;

#모든 레코드 조회하기
SELECT * FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;

#역순 정렬하기
SELECT NAME, DATETIME FROM ANIMAL_INS
ORDER BY ANIMAL_ID DESC;

#오프라인/온라인 판매 데이터 통합하기
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
FROM ONLINE_SALE
WHERE SUBSTR(SALES_DATE,1,7) = '2022-03'
UNION
SELECT DATE_FORMAT(SALES_DATE, '%Y-%m-%d') SALES_DATE, PRODUCT_ID, NULL USER_ID, SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SUBSTR(SALES_DATE,1,7) = '2022-03'
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID ASC;