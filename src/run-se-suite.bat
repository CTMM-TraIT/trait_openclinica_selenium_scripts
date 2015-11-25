echo Command-line %~1
SET FIREFOX_PROFILE_NAME=%~1
echo Firefox executable %FIREFOX_PROFILE_NAME%
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

java -jar selenium-server-standalone-2.44.0.jar -Dwebdriver.firefox.profile=%FIREFOX_PROFILE_NAME% -trustAllSSLCertificates -avoidProxy -userExtensions user-extensions.js -htmlSuite "*firefox" https://www.openclinica.nl/ test-performance-suite.html Results.html 

REM ---------------------------------------------------
REM The date format of selenium is not uniform over different Windows versions.
REM If the last entry in a row in the results-runs.txt does not contain a number the you have to change the value of the 
REM second parameter below from $%17 to the appropriate value.
REM You can check it by running the command: >> findstr  /R "Duration.*[0-9].*" Results.html | findstr successfully << 
REM For example the output could be:
REM "<td>Result of test run: test ClickingThrough completed successfully at Wed Nov 25 2015 13:25:16 GMT+0100 (W. Europe Standard Time). Duration 63854 ms</td>"
REM In this case the $17 should be $21; just count the number of tokens separated by a space.
REM ---------------------------------------------------

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