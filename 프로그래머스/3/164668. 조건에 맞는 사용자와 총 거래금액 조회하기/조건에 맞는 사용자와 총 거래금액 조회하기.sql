select u.USER_ID, u.NICKNAME, sum(b.PRICE) TOTAL_SALES
from USED_GOODS_BOARD b join USED_GOODS_USER u on(b.WRITER_ID = u.USER_ID)
where b.STATUS = "DONE"
group by (u.USER_ID)
HAVING sum(b.PRICE)  >= 700000
order by sum(b.PRICE)