# scalatest
Scala Project - COMP371/471 b2


[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=16147442)
# hello-scalatest-scala

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

## Report 
Test Coverage Section:

```
mujtaba@aisec101:~/Pictures/scalatest$ sbt coverageAggregate
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.jline.terminal.impl.exec.ExecTerminalProvider$ReflectionRedirectPipeCreator (file:/home/mujtaba/.sbt/boot/scala-2.12.19/org.scala-sbt/sbt/1.10.0/jline-terminal-3.24.1.jar) to constructor java.lang.ProcessBuilder$RedirectPipeImpl()
WARNING: Please consider reporting this to the maintainers of org.jline.terminal.impl.exec.ExecTerminalProvider$ReflectionRedirectPipeCreator
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
[info] welcome to sbt 1.10.0 (Ubuntu Java 11.0.23)
[info] loading settings for project scalatest-build-build-build from metals.sbt ...
[info] loading project definition from /home/mujtaba/Pictures/scalatest/project/project/project
[info] loading settings for project scalatest-build-build from metals.sbt ...
[info] loading project definition from /home/mujtaba/Pictures/scalatest/project/project
[success] Generated .bloop/scalatest-build-build.json
[success] Total time: 2 s, completed Sep 28, 2024, 12:36:49 PM
[info] loading settings for project scalatest-build from metals.sbt,plugins.sbt ...
[info] loading project definition from /home/mujtaba/Pictures/scalatest/project
[success] Generated .bloop/scalatest-build.json
[success] Total time: 1 s, completed Sep 28, 2024, 12:36:50 PM
[info] loading settings for project scalatest from build.sbt ...
[info] set current project to scalatest (in build file:/home/mujtaba/Pictures/scalatest/)
[info] Aggregating coverage from subprojects...
[info] Found 1 subproject scoverage data directories [/home/mujtaba/Pictures/scalatest/target/scala-3.3.3/scoverage-data]
[info] Generating scoverage reports...
[info] Written Cobertura report [/home/mujtaba/Pictures/scalatest/target/scala-3.3.3/coverage-report/cobertura.xml]
[info] Written XML coverage report [/home/mujtaba/Pictures/scalatest/target/scala-3.3.3/scoverage-report/scoverage.xml]
[info] Written HTML coverage report [/home/mujtaba/Pictures/scalatest/target/scala-3.3.3/scoverage-report/index.html]
[info] Statement coverage.: 25.30%
[info] Branch coverage....: 63.64%
[info] Coverage reports completed
[info] Aggregation complete. Coverage was [25.30]
[info] All done. Coverage was stmt=[25.30%] branch=[63.64%]
[success] Total time: 0 s, completed Sep 28, 2024, 12:36:52 PM
```
The coverage result

