select distinct CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY H join CAR_RENTAL_COMPANY_CAR C using (CAR_ID)
where C.CAR_TYPE like "세단" and H.START_DATE like "2022-10%"
order by 1 DESC