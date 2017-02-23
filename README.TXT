1. Data pre processing is done via perl scripts. It is located under preprocessing folder.
2. Place all the perl file where the data files are kept.
3. Perl files generate multiple csv or tsv files  which should be imported into the database.
	Importing can be done via command line as:
		LOAD DATA LOCAL INFILE 'filepath/filename'
		INTO TABLE library.<table_name>
		FIELDS TERMINATED BY <'\t' OR ','>
		LINES TERMINATED BY '\n';
4.Once the data is imported into the database , you can start the application.
5. Database used here is MySQL.
6. Application needs 2 external libraries to be added to run the application . Those libraries are: AbsoluteLayout.jar and mysql-connector.jar.Those are placed in lib folder.
7.Make sure the database is up and running before starting of application. 
8. Database root credentials are : root/root.'
9. The jar file (application file) is placed under 'Jar file folder'.
9. The application can be started from command line as :1. Go to jar file folder  2.java -jar "Library.jar" 
	OR if you have java platform binary installed , you can just double click on jar and the application will start.	
10. Design Doc and quick start guide is placed under documentation folder.