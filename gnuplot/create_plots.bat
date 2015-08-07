@echo off
REM ------------------------------------------------------------------------------------
REM
REM Batch file to create a plot/graph of the duration of the runs of the performance 
REM monitoring
REM 
REM ------------------------------------------------------------------------------------

type ..\..\VUmc-ONC-PC306\results-runs.txt | findstr "EditExistingSubject" > EditExistingSubject-VUmc-ONC-PC306.dat
type ..\..\VUmc-ONC-PC306\results-runs.txt | findstr "ClickingThrough" >ClickingThrough-VUmc-ONC-PC306.dat

REM Next lines are for the new extended measurements
type ..\..\VUmc-ONC-PC306\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_Login" > Extended_Login-VUmc-ONC-PC306.dat
type ..\..\VUmc-ONC-PC306\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_ClickSubjectMatrix" > Extended_Click_Through_Subject_Matrix-VUmc-ONC-PC306.dat
type ..\..\VUmc-ONC-PC306\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_LoadSubjectMatrix_size_15" > Extended_Edit_Existing_Subject_-_LoadSubjectMatrix_size_15.dat
type ..\..\VUmc-ONC-PC306\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_LoadSubjectMatrix_size_50" > Extended_Edit_Existing_Subject_-_LoadSubjectMatrix_size_50.dat
type ..\..\VUmc-ONC-PC306\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_Section1_Save" > Extended_Section1_Save-VUmc-ONC-PC306.dat
type ..\..\VUmc-ONC-PC306\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_Section2_Save" > Extended_Section2_Save-VUmc-ONC-PC306.dat
type ..\..\VUmc-ONC-PC306\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_Section3_Save" > Extended_Section3_Save-VUmc-ONC-PC306.dat
gnuplot gnuplot.script