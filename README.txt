** PROJECT TITLE: P18 - PAT
** GROUP: G6

NAME1: Tiago Rafael Ferreira da Silva, NR1: up201402841, GRADE1: 10, CONTRIBUTION1: 50%
NAME2: Claudia Margarida Rocha Marinho, NR2: up201404493, GRADE2: 10, CONTRIBUTION2: 50%
NAME3: Ricardo Lopes NR3: up201306009, GRADE3: 0, CONTRIBUTION3: 0%

** SUMMARY:

Leitura de padroes a partir de um ficheiro de texto e tenta encontra-los num ficheiro java.

** EXECUTE:

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

**DEALING WITH SYNTACTIC ERRORS:

Nao lidamos com isto.

**SEMANTIC ANALYSIS:

Simples CFG implementada em Parser.jjt para ler padroes.

**INTERMEDIATE REPRESENTATIONS (IRs):

**CODE GENERATION:

**OVERVIEW:

Utilizamos Spoon para converter um ficheiro java para a sua AST em formato json. De seguida, utilizamos GSON para ler esse ficheiro json e converter para um objecto java.
Por fim, percorremos a AST gerada pelo nosso proprio parser ao mesmo tempo que percorremos a AST do ficheiro java, e procuramos por nodos iguais (ie padroes)

**TESTSUITE AND TEST INFRASTRUCTURE:

Nao temos testes automaticos. Os exemplos que temos estao dentro da pasta examples.

**TASK DISTRIBUTION:

Claudia Marinho e Tiago Silva trabalharam em todo o projecto em conjunto. Ricardo Lopes nao fez nada, nao aparecendo aos encontros de grupo nem respondendo a mensagens.

**PROS:
Permite encontrar padroes em ficheiros java

**CONS:
Poucos padroes implementados. Padroes implementados sao pouco flexiveis (ie, ciclos while e if statements apenas podem ter um statement no seu body)
