@ECHO OFF

REM
REM Batch file to automatically start a Selenium Suite to test the performance
REM of OpenClinica on the production site www.openclinica.nl
REM 
REM -userExtensions C:\_home\jacob\selenium-contin\user-extensions.js
REM -firefoxProfileTemplate C:\_home\jacob\selenium-contin\firefox-profile


REM ---------------------------------------------------
REM This is the Firefox variant:
REM ---------------------------------------------------

if "%1"=="" goto BLANK

java -jar selenium-server-standalone-2.47.1.jar -trustAllSSLCertificates -avoidProxy -userExtensions user-extensions.js -htmlSuite "*firefox %1" https://www.openclinica.nl/ test-performance-suite.html Results.html 

REM ---------------------------------------------------
REM This is the Selenium Webdriver variant: 
REM ---------------------------------------------------
REM %JAVA_EXECUTABLE% -jar selenium-server-standalone-2.44.0.jar -Dwebdriver.firefox.profile=Firefox-profile-selenium-testing -trustAllSSLCertificates -userExtensions %BASE_DIR%user-extensions.js -htmlSuite "*webdriver"  https://www.openclinica.nl/ %BASE_DIR%Suite-test-performance-prod.html %BASE_DIR%Results.html 

findstr  /R "Duration.*[0-9].*" Results.html | findstr successfully | gawk "{print \"%DATE%\t%TIME%\t\"$6,$17}" >> results-runs.txt
findstr  /R "_Duration.*[0-9].*" Results.html | gawk "{print $5, $(NF-9), $(NF-8), $(NF-7), $(NF-6), $(NF-5), $(NF-4), $(NF-3), $(NF-2), $(NF-1)}" >> results-runs-extended.txt


REM copy /Y results-runs.txt O:\Pub\dm-algemeen\CTMS\TraIT\WP1\performance-monitoring\VUmc-ONC-PC306
REM copy /Y results-runs-extended.txt O:\Pub\dm-algemeen\CTMS\TraIT\WP1\performance-monitoring\VUmc-ONC-PC306
ECHO Finished
GOTO DONE

:BLANK
echo Firefox profile directory missing.

:DONE
@ECHO ON