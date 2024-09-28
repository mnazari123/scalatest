# scalatest
Scala Project - COMP371/471 b2


[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=16147442)
# scalatest

Small project to get started with Scala and ScalaTest.


## Running the main program

```
$ sbt "run -c 3 -l 2 -w 5 -s 2 -f 1"
```
Result 

```
a b c
aa bb cc 
aa bb aa bb
aa: 2 bb: 2 cc: 1
a b c
aa aa aa
aa: 3 bb: 2
aa: 4 bb: 1
```

## Running the tests

```
$ sbt test
```

or

```
$ sbt coverage test coverageReport
[info] Statement coverage.: 25.30%
[info] Branch coverage....: 63.64%
```

to see the code coverage percentages of your test suite.


## Running successive tasks with sbt

To speed up the edit-compile-test/run cycle, you can start sbt without arguments

```
$ sbt
```

and repeatedly run individual tasks

```
sbt> run -c 3 -l 2 -w 5 -s 2 -f 1
```

```
sbt> test
```

To exit sbt, enter

```
sbt> exit
```


## Running outside of sbt

This lets you use your application on the command-line.

First, create the startup script:

```
sbt stage
```

Then run outside of sbt like this:

```
./target/universal/stage/bin/scalatest
```

On Windows, you might need backslashes. WSL (Windows Subsystem for Linux) recommended instead.
 
or you can run it by passing the a .txt file to read from it. This command will use the default parameters. 
```
./target/universal/stage/bin/scalatest < lesmisrables01unkngoog_djvu.txt
```

Add the ignore file to it. 
```
./target/universal/stage/bin/scalatest -i ignore.txt < lesmisrables01unkngoog_djvu.txt
```

