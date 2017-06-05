Este exemplo mostra o programa a falhar ao procurar padroes do tipo if statement:

if (@x == value) {
  @x = value;
}

Este exemplo e bastante parecido com o exemplo 1, no entanto, este falha.
A razao para isso, e porque neste caso, o padrao @x foi encontrado na variavel a, mas tambem na variavel b. Obviamente, um padrao apenas pode ter um match, logo o programa falha.

O ficheiro Example3.java contem o ficheiro a analisar.
O ficheiro Example3.txt contem o padrao a procurar.
