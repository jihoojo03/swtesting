#/bin/bash

gcov -bc ./*.c 2> /dev/null | grep "Lines" | awk '{print $4}' | tail -1 |awk 'BEGIN{sum=0}{sum=sum+($0);}END{print(sum)}'