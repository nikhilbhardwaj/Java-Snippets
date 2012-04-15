#Here's how you would execute after compiling
java -cp ".;sqlitejdbc-v056.jar" ConnectSQLite
Alternatively you could add the sqlitejdbc-v056.jar to your default classath

#here's basic sqlite console usage
$ sqlite3 test_db.db
SQLite version 3.7.11 2012-03-20 11:35:50
Enter ".help" for instructions
Enter SQL statements terminated with a ";"
sqlite> .schema
CREATE TABLE users(id smallint, name varchar(20));
sqlite> insert into users values(4, "hippo");
sqlite> ^Z
