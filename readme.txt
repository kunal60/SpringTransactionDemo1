1)Execute the script.sql in resources folder in Oracle Database.Notice the check constraints in the table.
2)create spring.xml in resources folder
3) create interface Bookshop
4)Create Class JdbcBookShop which implemets Bookshop
5)Create Class MainWithoutTransaction
Run it multiple times: After 10 time

When you run this application, you will encounter a SQLException, because the CHECK constraint of
the ACCOUNT table has been violated. This is an expected result because you were trying to debit more
than the account balance. However, if you check the stock for this book in the BOOK_STOCK table, you will
find that it was accidentally deducted by this unsuccessful operation! The reason is that you executed
the second SQL statement to deduct the stock before you got an exception in the third statement.
As you can see, the lack of transaction management causes your data to be left in an inconsistent
state. To avoid this inconsistency, your three SQL statements for the purchase() operation should be
executed within a single transaction. Once any of the actions in a transaction fail, the entire transaction
should be rolled back to undo all changes made by the executed actions.

6)Create springJdbcTxn.xml
7)create class JdbcBookShopWithJDBCTrnsaction and MainWithJDBCTxn
8)Run it