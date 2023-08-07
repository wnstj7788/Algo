-- 코드를 입력하세요
-- REST_INFO와 REST_REVIEW 테이블에서 서울에 위치한 식당들의 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회하는 SQL문을 작성해주세요. 이때 리뷰 평균점수는 소수점 세 번째 자리에서 반올림 해주시고 결과는 평균점수를 기준으로 내림차순 정렬해주시고, 평균점수가 같다면 즐겨찾기수를 기준으로 내림차순 정렬해주세요.

SELECT 
    RV.REST_ID, R.REST_NAME, R.FOOD_TYPE, R.FAVORITES, R.ADDRESS,  ROUND(AVG(RV.REVIEW_SCORE),2) AS SCORE
FROM
 REST_INFO as R, REST_REVIEW as RV
WHERE
    R.REST_ID = RV.REST_ID
GROUP BY 
    RV.REST_ID
HAVING 
    R.ADDRESS LIKE '서울%'
ORDER BY 
    SCORE DESC, R.FAVORITES DESC
    
    
    
# SELECT 
#     A.REST_ID, B.REST_NAME, B.FOOD_TYPE, B.FAVORITES, B.ADDRESS, ROUND(AVG(A.REVIEW_SCORE),2) AS SCORE
# FROM 
#     REST_REVIEW A
# JOIN 
#     REST_INFO B ON A.REST_ID = B.REST_ID
# GROUP BY 
#     A.REST_ID
# HAVING 
#     B.ADDRESS LIKE '서울%'
# ORDER BY SCORE DESC, B.FAVORITES DESC
    
