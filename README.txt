** PROJECT TITLE: P18 - PAT
** GROUP: G6
(Names, numbers, self assessment, and contribution of
the members of the group to the project according to:)
NAME1: Tiago Rafael Ferreira da Silva, NR1: up201402841, GRADE1: 10, CONTRIBUTION1: 50%
NAME2: Claudia Margarida Rocha Marinho, NR2: up201404493, GRADE2: 10, CONTRIBUTION2: 50%
NAME3: Ricardo Lopes NR3: up201306009, GRADE3: 0, CONTRIBUTION3: 0%
(Note that the sum of the CONTRIBUTION? values must be
100 %)

** SUMMARY: (Describe what your tool does and its main features.)

Le padroes a partir de um ficheiro de texto e tenta encontra-los num ficheiro java.

** EXECUTE: (indicate how to run your tool)

Open terminal inside project root
Type java -jar lib/spoon2ast.jar examples/exampleX/ExampleX.java
(onde X e o numero do exemplo que quer testar)
Open terminal inside src/main
Type jjtree Parser.jjt
Type javacc Parser.jj
Open terminal inside project root
Type javac -d bin -cp lib/gson-2.8.0.jar:src src/main/Main.java
Type java -cp .:lib/gson-2.8.0.jar:bin main.Main examples/exampleX/ExampleX.txt
(onde X e o numero do exemplo que quer testar)
Note: On Windows, replace : with ;

**DEALING WITH SYNTACTIC ERRORS: (Describe how the syntactic error recovery of your tool does work. Does it exit after the first error?)

Nao lidamos com isto.

**SEMANTIC ANALYSIS: (Refer the possible semantic rules implemented by your tool.)

Simples CFG implementada em Parser.jjt para ler padroes.

**INTERMEDIATE REPRESENTATIONS (IRs): (for example, when applicable, briefly describe the HLIR (high-level IR) and the LLIR (low-level IR) used, if your tool includes an LLIR with structure different from the HLIR)

**CODE GENERATION: (when applicable, describe how the code generation of your tool works and identify the possible problems your tool has regarding code generation.)

**OVERVIEW: (refer the approach used in your tool, the main algorithms, the third-party tools and/or packages, etc.)

Utilizamos Spoon para converter um ficheiro java para a sua AST em formato json. De seguida, utilizamos GSON para ler esse ficheiro json e converter para um objecto java.
Por fim, percorremos a AST gerada pelo nosso proprio parser ao mesmo tempo que percorremos a AST do ficheiro java, e procuramos por nodos iguais (ie padroes)

**TESTSUITE AND TEST INFRASTRUCTURE: (Describe the content of your testsuite regarding the number of examples, the approach to automate the test, etc.)

Nao temos testes automaticos. Os exemplos que temos estao dentro da pasta examples.

**TASK DISTRIBUTION: (Identify the set of tasks done by each member of the project.)

Claudia Marinho e Tiago Silva trabalharam em todo o projecto em conjunto. Ricardo Lopes nao fez nada, nao aparecendo aos encontros de grupo nem respondendo a mensagens.

**PROS: (Identify the most positive aspects of your tool)
Permite encontrar padroes em ficheiros java

**CONS: (Identify the most negative aspects of your tool)
Poucos padroes implementados. Padroes implementados sao pouco flexiveis (ie, ciclos while e if statements apenas podem ter um statement no seu body)
