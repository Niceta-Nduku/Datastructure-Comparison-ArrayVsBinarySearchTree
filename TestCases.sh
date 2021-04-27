#!/usr/bin/bash
# Test cases for the Applications 
# Part 1 to 4
# Program is run and the output is redirected to a file 

declare -a KNOWNCASES=("16/12/2006/19:51:00" "16/12/2006/21:39:00" "16/12/2006/17:43:00")

FAILCASE="16/12/2007/17:43:00"

cd bin

echo Type app name PowerArrayApp or PowerBSTApp

read app

#go through the 3 known times (KNOWNCASES)
echo $app Test Cases >> ../KnownCase.txt

for test in "${KNOWNCASES[@]}"; do
	echo Date/Time:  $test 
	echo Output: 
	java $app $test 
done > ../KnownCase.txt

#This will run the App with a false date time
echo $app Test Cases >> ../UnknownCase.txt
echo Unknown Case:  >> ../UnknownCase.txt
echo Output: >> ../UnknownCase.txt
java $app $FAILCASE >> ../UnknownCase.txt

#This will run the App to print all datetimes
#No parameters
echo No parameters  >> ../all.txt
echo Output: >>  ../all.txt
java $app >>  ../all.txt

echo $app No parameters Test Cases >> ../NoParam.txt
head -n 12 ../all.txt >> ../NoParam.txt
tail -n 10 ../all.txt >> ../NoParam.txt

echo end of testing
