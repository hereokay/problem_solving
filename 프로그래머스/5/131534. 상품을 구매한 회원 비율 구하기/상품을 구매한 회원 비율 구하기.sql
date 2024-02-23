SELECT YEAR(sales_date) as YEAR, MONTH(sales_date) as MONTH, count(DISTINCT user_id) as PUCHASED_USERS
,

ROUND(count(DISTINCT user_id)/
(SELECT count(DISTINCT USER_ID)
FROM USER_INFO
WHERE DATE_FORMAT(joined, "%y") ='21'),1) as PUCHASED_RATIO


FROM ONLINE_SALE
WHERE user_id in (
    SELECT user_id
    FROM USER_INFO
    WHERE DATE_FORMAT(joined, "%y") ='21'
)
GROUP BY YEAR(sales_date), MONTH(sales_date)


ORDER BY YEAR ASC, MONTH ASC