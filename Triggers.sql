/*trigger to update owner totalSales when order is made by user */

create trigger money_gained after insert on orders
referencing new row as nrow
referencing old row as orow
for each row
when nrow.totalSales <> 0 and nrow.totalSales is not null
begin atomic
	update owner
	set totalSales = totalSales +
		(select price
		from book
		where book.ISBN = nrow.ISBN);
end;



