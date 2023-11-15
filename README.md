# downloadClob

Downloads Clobs from a database.

downloadClob-1.0-SNAPSHOT.jar
- jar file for downloading Clobs to a csv file.

downloadClob-1.0-SNAPSHOT-jar-with-dependencies.jar
- jar file including dependencies

HELP
====
$ java -Dfile.encoding=UTF-8 -classpath downloadClob-1.0-SNAPSHOT-jar-with-dependencies.jar org.downloadclob.DownloadClob
downloadClob [url] [username] [pwd] [filename]

$ java -Dfile.encoding=UTF-8 -classpath downloadClob-1.0-SNAPSHOT-jar-with-dependencies.jar org.downloadclob.DownloadClob jdbc:oracle:thin:@localhost:1521/database user password clobs.csv

[enter query via keyboard and end query with the word "exit" on a single line]

References
==========

Uses opencsv to generate csv files.
