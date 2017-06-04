# COMP

## How to run

### Parser

* Open terminal inside ``src/``
* Type ``jjtree Parser.jjt``
* Type ``javacc Parser.jj``
* Type ``javac -d ../bin *.java``
* Type ``java -cp ../bin Parser <FILENAME>``


### SPOON (java to json)

* Open terminal inside ``GSON/``
* Type ``java -jar spoon2ast.jar HelloWorld.java``

### GSON (json to map)

* Open terminal inside ``COMP/``
* Type ``javac -d bin -cp "root\gson-2.8.0.jar;root\GSON" GSON/GsonTest.java``
* Type ``java -cp .;gson-2.8.0.jar;bin GsonTest``


**Note:** On Linux, replace ``;`` with ``:``
