#!/bin/bash
gcc -o tcas tcas.c

while read p
do
	./tcas $p
done < rand.txt > log.txt
