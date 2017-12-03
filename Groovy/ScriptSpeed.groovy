@Grab('mysql:mysql-connector-java:6.0.6')
@GrabConfig(systemClassLoader = true)

import groovy.sql.Sql

def sql = Sql.newInstance("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root", "com.mysql.cj.jdbc.Driver")

def maxID = 230266;

for(int idx= 1; idx <100001;idx++){

		sql.execute("INSERT INTO researchResults(`id`, `language`, `iteration`, `startTime`) VALUES ( " + maxID + ", 'Groovy', " + idx + ", Now(6))")
		sql.execute("SELECT * FROM sakila.seniorresearch LIMIT " + idx)
		sql.execute("UPDATE researchResults SET `endTime` = Now(6) WHERE id = " + maxID)
		maxID++;
}