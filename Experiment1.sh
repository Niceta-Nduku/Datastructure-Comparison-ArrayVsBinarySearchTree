#!/bin/bash
#Part 5
# Create a set of N data from the CSV file 
# 
set -x

#open bin directory in order to run the app
cd bin

for N in {2..501}
do	
	#create subset
	head -n $N ../cleaned_data.csv | tail -n $((N-1))  > ../Subset1.csv

	while IFS=, read -ra array;do
		java PowerArrayApp "${array[0]}" >>  ../ArrayExperiment.xlsx

	done < ../Subset1.csv
	echo "" >> ../ArrayExperiment.xlsx
done 

cd ..

rm -f Subset1.cvs