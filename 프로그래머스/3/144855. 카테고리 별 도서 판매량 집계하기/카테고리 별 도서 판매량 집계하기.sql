select b.CATEGORY, sum(s.SALES) as TOTAL_SALES
from BOOK b join BOOK_SALES s using(BOOK_ID)
where s.SALES_DATE like "2022-01%"
group by (b.CATEGORY)
order by 1

