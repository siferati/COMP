# COMP

## How to run

* Open terminal inside ``src/``
* Type ``jjtree Parser.jjt``
* Type ``javacc Parser.jj``
* Type ``javac -d ../bin Parser.java``


* Open terminal inside project root
* Type ``javac -d bin -cp lib/gson-2.8.0.jar:src src/Main.java``
* Type ``java -cp .:lib/gson-2.8.0.jar:bin Main <FILENAME>``

**Note:** On Windows, replace ``:`` with ``;``
