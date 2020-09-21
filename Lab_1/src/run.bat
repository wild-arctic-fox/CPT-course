echo off
set path=C:\Program Files\Java\jdk1.8.0_172\bin
set include=C:\Program Files\Java\jdk1.8.0_172\include
set lib=C:\Program Files\Java\jdk1.8.0_172\lib
set link=C:\Program Files\Java\jdk1.8.0_172\bin
javac -version Initials.java
java Initials
javap -c Initials >1.txt
javadoc Initials.java -d 1
pause