# COMP

## How to run

* Open terminal inside ``src/main``
* Type ``jjtree Parser.jjt``
* Type ``javacc Parser.jj``


* Open terminal inside project root
* Type ``javac -d bin -cp lib/gson-2.8.0.jar:src src/main/Main.java``
* Type ``java -cp .:lib/gson-2.8.0.jar:bin main.Main examples/input.txt``

**Note:** On Windows, replace ``:`` with ``;``
