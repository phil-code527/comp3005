
/*view books by title*/

create view title as
select title,author,price, pages
from book
where book.title = "selected title";

/*select books by genre type*/

select * 
from book 
where book.genre= "selected genre";

/*track order status */

create view order_status as
select status
from track njoin Status
where tarck.order_no = Status.order_no;