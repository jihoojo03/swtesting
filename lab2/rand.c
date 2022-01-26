#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(){
	FILE* fs;
	char * file = "rand.txt";
	fs = fopen(file, "w");

	srand(time(NULL));
	for(int j = 0; j<100000; j++){
		for(int i = 1; i<=12; i++){
			if(i == 2 || i == 3)
				fprintf(fs, "%d ", rand() % 2);
			else if(i == 7)
				fprintf(fs, "%d ", rand() % 4);
			else if(i == 10 || i == 12)
				fprintf(fs, "%d ", rand() % 3);
			else if(i == 11)
				fprintf(fs, "%d ", rand() % 2 + 1);
			else
				fprintf(fs, "%d ", rand() % 9999 - 5000);
		}
		fprintf(fs, "\n");
	}
	pclose(fs);
	
	return 0;
}

