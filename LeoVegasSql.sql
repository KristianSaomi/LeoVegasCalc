DROP DATABASE LeoVegas;
/*1. Start database before running application*/
CREATE DATABASE LeoVegas;
/*2. Use LeoVegas Database*/
USE LeoVegas; 

/*3. Run Application, open on http://localhost:9090/registerUser */

/*4. Insert "spring security" authentication Role values - Only one time (Insert before actually creating account)*/
INSERT into roles(name)
VALUES ('USER'),
       ('EMPLOYEE');

/*5. Check that Account is empty, users is empty, and Roles = USER / EMPOYEE*/
SELECT * FROM Account;
SELECT * FROM User;
SELECT * FROM Roles;

/*6. Play with the application*/
/*
-Edit account info
-Add credit
-Withdraw debit
-See total balance
-See history log of the account
*/



/*-----------------------------------------*/

/*Testing statement*/
SELECT sum(debit) from account where user_id = 1;
SELECT sum(credit) from account where user_id = 1;
delete from Account order by id desc limit 1;
SELECT * FROM ACCOUNT WHERE USER_ID = 6;

/* Dont use this insert - Just for test*/
insert into account(balance, user_id)
VALUES(3000,1);

/* Dont use this insert - Just for test*/
insert into User(first_name, last_name)
VALUES("Kristian","Saomi");

/*Just for test*/
DROP TABLE Account;
DROP Table User;
Drop Table Roles;


