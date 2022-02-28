<!--Heading-->
# SW Testing

This repository based on 2021-2 **Special Topic (SW Testing)** class.

<!-- Quote-->
> The 5 labs conducted in this class are presented below.

## Lab 1

- Task 1 : Run the existing test cases of libxml2, and use *gcov* to
measure the line/branch coverage of each test case execution
    1. The number of the executable lines in libxml2
    2. Count the number of the lines and the branches covered by each test input file
    3. Count the number of the lines and the branches covered by the test set 
- Task 2 : Use *LLVM Sanitizer* to implement the trace-pc plugin that extracts the edge-pair test requirements covered from a test case execution
    1. Run multiple test case executions on triangle and identify all edge-pair requirements covered by at least one test case execution in the testing

```
./lab1/task1_1.sh
```

## Lab 2

- Task 1 : Test *tcas.c* to achieve as much MC/DC coverage possible
    - Identify all basic-conditions and decisions in a target program
    - Manually instrument the target program to extract the evaluation of each basic condition and each decision when it is executed
    - Count the number of the lines and the branches covered by the test set 
    - Write a report to show the MC/DC coverage of your test set

```
./lab2/run.sh
```

## Lab 3
- Task 1 : Suppose that you are asked to derive input space partitioning test inputs for the **Bounded Queue** class with the following methods
    - public **BoundedQueue** (int capacity)
    - public void **enqueue** (Object obj)
    - public Object **dequeue** ( )
    - public boolean **isEmpty** ( )
    - public boolean **isFull** ( )


```
    a) Identify all of the input variables including the state variables 
    b) Define interface-based and functionality-based characteristics
    c) Partition the characteristics into blocks, and define the base cases
    d) Find values for each block
    e) Define a test set that satisfies Base Choice Coverage (BCC)
```

## Lab 4
- Task 1 : Modify **heapsort.c** for CREST to generate test inputs
    - Run CREST to generate test inputs and find errors
    - Find a bug and fix it
    - Run CREST for the fixed version to check the correctness

```
- CRESTIVE, a revised version of CREST can be found at
    https://github.com/ARISE-Handong/crestive
- Construct an instrumented target program
$ crestc <target file>
- Execute concolic test generation
$ run_crest <instrumented object> <# test cases> - [dfs|cfg|random]
```
