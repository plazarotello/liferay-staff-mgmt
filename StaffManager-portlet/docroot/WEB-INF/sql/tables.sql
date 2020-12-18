create table staffMgmt_Department (
	dpt_name VARCHAR(75) not null primary key
);

create table staffMgmt_Employee (
	emp_id LONG not null primary key,
	name VARCHAR(75) null,
	dpt_name VARCHAR(75) null,
	phone_no INTEGER,
	photo TEXT null
);

create table staffMgmt_Phone (
	phone_no INTEGER not null primary key
);

create table staff_mgmt_Department (
	dpt_id LONG not null primary key,
	name VARCHAR(75) null
);

create table staff_mgmt_Employee (
	emp_id LONG not null primary key,
	name VARCHAR(75) null,
	dpt_id LONG,
	phone_id LONG
);

create table staff_mgmt_Phone (
	phone_id LONG not null primary key,
	phone INTEGER
);