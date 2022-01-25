#/bin/bash

rm ./*.gcda
for filename in ./test/HTML/*.html;
do
  echo $filename
  ./testHTML $filename > /dev/null 2>&1
done

  lineall=`gcov -b -c ./*.c 2> /dev/null | grep "Lines" | tail -1 | awk '{print $4}'`
  linecover=`cat *.c.gcov 2> /dev/null | grep -c "   #####:"`

  branchall=`gcov -b -c ./*.c 2> /dev/null | grep "Branches" | awk '{print $4}' | awk 'BEGIN{sum=0}{sum=sum+($0);}END{print(sum)}'`
  branchcover=`cat *.c.gcov 2> | grep "^branch" | grep -c "never executed"`

  line=$((lineall-linecover))
  branch=$((branchall-branchcover))

  echo "Executed Lines"
  echo $line
  echo "Executed Brances"
  echo $branch
  echo " "
