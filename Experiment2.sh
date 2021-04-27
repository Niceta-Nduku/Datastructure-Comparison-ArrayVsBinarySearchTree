#!/bin/bash
#Part 5
# Create a set of N data from the CSV file 
# 
set -x

cd bin

for N in {2..501}
do	
	head -n $N ../cleaned_data.csv | tail -n $((N-1))  > ../Subset2.csv

	while IFS=, read -ra array;do
			java PowerBSTApp "${array[0]}" >> ../BSTExperiment.xlsx
		
	done < ../Subset2.csv
	echo "" >> ../BSTExperiment.xlsx
done 

cd ..

rm -f Subset2.cvs