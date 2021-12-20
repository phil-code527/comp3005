create table owner
	(owner_id varchar(5),
	owner_name varchar(20),
	store_address varchar(30),
	totalSales numeric(5,2),
	primary key (owner_id)
	);
	
create table royaltyPay
	(owner_id varchar(20),
	author_name varchar(20),
	author_address varchar(30),
	banking_card varchar(20),
	amount numeric(5,2),
	primary key (owner_id)
	);
	
create table user
	(user_id varchar(5),
	user_name varchar(20),
	user_address varchar(30),
	banking_card varchar(20),
	shipping_address varchar(30),
	primary key (user_id)
	);
	
create table register
	(owner_id varchar(5),
	user_id varchar(5),
	primary key (user_id),
	foreign key (owner_id) references owner(owner_id),
	foreign key (user_id) references user(user_id)
	);
	
create table book
	(ISBN varchar(5),
	title varchar(30),
	author varchar(20),
	price numeric(4,2),
	pages numeric(4,0),
	genre varchar(20),
	primary key (ISBN)
	);
	
create table orders
	(order_no numeric(4,0),
	user_id varchar(20),
	ISBN varchar(5),
	title varchar(30),
	shipping_address varchar(30),
	banking_card varchar(20),
	primary key (order_no),
	foreign key (ISBN) references book(ISBN)
	);
	
create table getMore
	(owner_id varchar(5),
	ISBN varchar(5),
	title varchar(30),
	quantity numeric(4,0),
	primary key (owner_id),
	foreign key (ISBN) references book(ISBN)
	);
	
create table track
	(owner_id varchar(5),
	order_no numeric(4,0),
	primary key (owner_id),
	foreign key (order_no) references status(order_no)
	);
	
create table status
	(order_no numeric(4,0),
	status varchar(5),
	primary key (order_no)
	);

	
	
	
	