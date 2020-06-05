
/* Drop Triggers */

DROP TRIGGER TRI_cs_tb_cs_uid;
DROP TRIGGER TRI_inventory_tb_inv_uid;
DROP TRIGGER TRI_member_tb_mem_uid;
DROP TRIGGER TRI_menu_tb_menu_uid;
DROP TRIGGER TRI_orderlist_orderlist_uid;
DROP TRIGGER TRI_order_tb_order_uid;
DROP TRIGGER TRI_sales_tb_sales_uid;
DROP TRIGGER TRI_storeinfo_tb_store_uid;
DROP TRIGGER TRI_subcribe_tb_sub_uid;



/* Drop Tables */

DROP TABLE cs_tb CASCADE CONSTRAINTS;
DROP TABLE order_detail CASCADE CONSTRAINTS;
DROP TABLE menu_tb CASCADE CONSTRAINTS;
DROP TABLE order_tb CASCADE CONSTRAINTS;
DROP TABLE storeinfo_tb CASCADE CONSTRAINTS;
DROP TABLE member_tb CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_cs_tb_cs_uid;
DROP SEQUENCE SEQ_inventory_tb_inv_uid;
DROP SEQUENCE SEQ_mem_uid;
DROP SEQUENCE SEQ_menu_tb_menu_uid;
DROP SEQUENCE SEQ_orderlist_orderlist_uid;
DROP SEQUENCE SEQ_order_tb_order_uid;
DROP SEQUENCE SEQ_sales_tb_sales_uid;
DROP SEQUENCE SEQ_store_uid;




/* Create Sequences */

CREATE SEQUENCE SEQ_cs_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_inv_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_mem_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_menu_tb_menu_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_orderlist_orderlist_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_order_tb_order_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_sales_tb_sales_uid INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_store_uid INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE cs_tb
(
	cs_uid number NOT NULL,
	cs_subject varchar2(50) NOT NULL,
	cs_content clob NOT NULL,
	cs_regdate date DEFAULT SYSDATE,
	mem_uid number NOT NULL,
	PRIMARY KEY (cs_uid)
);


CREATE TABLE member_tb
(
	mem_uid number NOT NULL,
	mem_id varchar2(50) NOT NULL,
	mem_pw varchar2(50) NOT NULL,
	mem_name varchar2(50),
	mem_phonenum varchar2(20) NOT NULL,
	mem_email varchar2(50) NOT NULL,
	mem_sub_regdate date,
	mem_sub_period number,
	mem_sub_payment number,
	mem_sub_method varchar2(50),
	PRIMARY KEY (mem_uid)
);

INSERT INTO member_tb VALUES(SEQ_MEM_UID.nextval , 'suyeong', 'gogogogo', 'mynameis', '01050102020','dududu@naver.com', '20-JAN-18', 30, 300, 'payname');
INSERT INTO STOREINFO_TB VALUES(SEQ_STORE_UID.nextval, 'SUUU', 'GUNGO', '010202030453', SEQ_STORE_UID.nextval);
SELECT * FROM MEMBER_TB;
DELETE * FROM MEMBER_TB WHERE mem_uid = 2;

CREATE TABLE storeinfo_tb
(
	store_uid number NOT NULL,
	store_name varchar2(50) NOT NULL,
	store_loca varchar2(300) NOT NULL,
	store_phonenum varchar2(50) NOT NULL,
	mem_uid number NOT NULL,
	PRIMARY KEY (store_uid)
);

SELECT * FROM storeinfo_tb;
DELETE mem_uid FROM MEMBER_TB;


CREATE TABLE menu_tb
(
	menu_uid number NOT NULL,
	menu_name varchar2(50) NOT NULL,
	menu_price number NOT NULL,
	store_uid number NOT NULL,
	PRIMARY KEY (menu_uid)
);


CREATE TABLE order_detail
(
	orderdetail_uid number NOT NULL,
	orderdetail_price number NOT NULL,
	orderdetail_menuname varchar2(40) NOT NULL,
	orderdetail_quantity number NOT NULL,
	order_uid number NOT NULL,
	menu_uid number NOT NULL,
	PRIMARY KEY (orderdetail_uid)
);


CREATE TABLE order_tb
(
	order_uid number NOT NULL,
	order_regdate date,
	order_totalprice number,
	store_uid number NOT NULL,
	PRIMARY KEY (order_uid)
);



/* Create Foreign Keys */

ALTER TABLE cs_tb
	ADD FOREIGN KEY (mem_uid)
	REFERENCES member_tb (mem_uid)
;


ALTER TABLE storeinfo_tb
	ADD FOREIGN KEY (mem_uid)
	REFERENCES member_tb (mem_uid)
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (menu_uid)
	REFERENCES menu_tb (menu_uid)
;


ALTER TABLE order_detail
	ADD FOREIGN KEY (order_uid)
	REFERENCES order_tb (order_uid)
;


ALTER TABLE menu_tb
	ADD FOREIGN KEY (store_uid)
	REFERENCES storeinfo_tb (store_uid)
;


ALTER TABLE order_tb
	ADD FOREIGN KEY (store_uid)
	REFERENCES storeinfo_tb (store_uid)
;









