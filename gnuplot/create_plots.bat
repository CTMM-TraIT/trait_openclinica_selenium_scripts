@ECHO OFF

if "%1"=="" goto BLANK

SET OUTPUT_DIR=%~1
SET HOST=%~2
SET START_DATE=%3
REM ------------------------------------------------------------------------------------
REM
REM Batch file to create a plot/graph of the duration of the runs of the performance 
REM monitoring
REM 
REM ------------------------------------------------------------------------------------




type %OUTPUT_DIR%\results-runs.txt | findstr "EditExistingSubject" > EditExistingSubject-%HOST%.dat


REM Next lines are for the new extended measurements
type %OUTPUT_DIR%\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_Login" > Extended_Login-%HOST%.dat
REM type %OUTPUT_DIR%\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_ClickSubjectMatrix" > Extended_Click_Through_Subject_Matrix-%HOST%.dat
type %OUTPUT_DIR%\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_LoadSubjectMatrix_size_15" > Extended_Edit_Existing_Subject_-_LoadSubjectMatrix_size_15.dat
type %OUTPUT_DIR%\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_LoadSubjectMatrix_size_50" > Extended_Edit_Existing_Subject_-_LoadSubjectMatrix_size_50.dat
type %OUTPUT_DIR%\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_Section1_Save" > Extended_Section1_Save-%HOST%.dat
type %OUTPUT_DIR%\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_Section2_Save" > Extended_Section2_Save-%HOST%.dat
type %OUTPUT_DIR%\results-runs-extended.txt | findstr "Extended_Edit_Existing_Subject_-_Section3_Save" > Extended_Section3_Save-%HOST%.dat
gnuplot -c gnuplot.script %HOST% %START_DATE%


ECHO Finished
GOTO DONE

:BLANK
echo Output directory missing where the files results-runs.txt and results-runs-extended.txt can be found

:DONE
@ECHO ON