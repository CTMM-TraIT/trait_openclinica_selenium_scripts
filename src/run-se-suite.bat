@ECHO OFF

REM
REM Batch file to automatically start a Selenium Suite to test the performance
REM of OpenClinica on the production site www.openclinica.nl
REM 
REM -userExtensions C:\_home\jacob\selenium-contin\user-extensions.js
REM -firefoxProfileTemplate C:\_home\jacob\selenium-contin\firefox-profile


REM set JAVA_EXECUTABLE=..\java1.6.0.45\bin\java

set JAVA_EXECUTABLE="C:\java\jdk1.7.0_51\bin\java"
REM ---------------------------------------------------
REM This is the Firefox variant:
REM ---------------------------------------------------
REM %JAVA_EXECUTABLE% -jar selenium-server-standalone-2.44.0.jar -Dwebdriver.firefox.profile=Firefox-profile-selenium-testing -trustAllSSLCertificates -userExtensions %BASE_DIR%user-extensions.js -htmlSuite "*firefox"  https://www.openclinica.nl/ %BASE_DIR%Suite-test-performance-prod.html %BASE_DIR%Results.html 


java -jar selenium-server-standalone-2.44.0.jar -trustAllSSLCertificates -avoidProxy -userExtensions user-extensions.js -htmlSuite "*firefox  C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe" https://www-acc.openclinica.nl/ test-performance-suite.html Results.html 




REM ---------------------------------------------------
REM This is the Selenium Webdriver variant: 
REM ---------------------------------------------------
REM %JAVA_EXECUTABLE% -jar selenium-server-standalone-2.44.0.jar -Dwebdriver.firefox.profile=Firefox-profile-selenium-testing -trustAllSSLCertificates -userExtensions %BASE_DIR%user-extensions.js -htmlSuite "*webdriver"  https://www.openclinica.nl/ %BASE_DIR%Suite-test-performance-prod.html %BASE_DIR%Results.html 

findstr  /R "Duration.*[0-9].*" Results.html | findstr successfully | gawk "{print \"%DATE%\t%TIME%\t\"$6,$21}" >> results-runs.txt
findstr  /R "_Duration.*[0-9].*" Results.html | gawk "{print $5, $(NF-9), $(NF-8), $(NF-7), $(NF-6), $(NF-5), $(NF-4), $(NF-3), $(NF-2), $(NF-1)}" >> results-runs-extended.txt


copy results-runs.txt O:\Pub\dm-algemeen\CTMS\TraIT\WP1\performance-monitoring\VUmc-ONC-PC306
copy results-runs-extended.txt O:\Pub\dm-algemeen\CTMS\TraIT\WP1\performance-monitoring\VUmc-ONC-PC306
ECHO Finished
@ECHO ON