
insert into ibaw.customers values('PavanSaiS',63000,385995354,12389,'pavanSai','sheshetti','Sai9@9','10-08-2021 00:41am');
insert into ibaw.customers values('ChandrikaS',2000,68224899,79123,'Chandrika','sheshetti','Chandu99#','10-08-2021 00:41am');
delete from ibaw.customers where accountnumber =-1234;

select * from ibaw.customers;
select * from ibaw.employees ;
insert into ibaw.employees values(953762,'Bharath Sai','Maddela','Bharath789','BharathSaiM');
create or replace procedure transferAmountProcedure(
			senderId bigint,
			recieverId bigint,
			amount bigint
			)
language plpgsql
as $$
begin
	update ibaw.customers set accountbalance = accountbalance-amount where accountnumber=senderId;
	update ibaw.customers set accountbalance = accountbalance +amount where accountnumber =recieverId;
end;
$$

call transferAmountProcedure(68224899,385995354,1500) ;