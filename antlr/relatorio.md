# Compilador de Linguagem R 
## Lexer/Parser

R é uma linguagem de programação voltada a análise de dados estatísticos.
Inicialmente foi realizada a análise da gramática da linguagem R contida no repositório [CRAN](http://cran.r-project.org/doc/manuals/R-lang.html#Parser) e na implementação do lexer em C do [svn.r-project](http://svn.r-project.org/R/trunk/src/main/gram.y). Diante ao fato de que todas as informações já estavam disponíveis e implementadas no ANTLR, foi realizado um reaproveitamento dos arquivos definindo a gramática.

Como não existe almoço grátis, notou-se que estruturas aninhadas específicas sem marcadores de bloco `{ ... }` e comentários entre estas estruturas, como as exemplificadas a seguir, não estavam implementadas. Nós as implementamos. Também implementamos operadores de atribuição globais `<<-`

```{R}
if (x==0) {
    if (x==1) print(1)
    else print(2)
}

if (x==1)
    print(1)
# Some comments
else
    print(2)
```

Devido à estrutura demonstrada acima ser altamente utilizada, onde não são utilizados marcadores de bloco `{ ... }`, acabamos tendo que relevar um erro de sintaxe, de duas ou instruções situarem-se sem um ponto-e-vírgula entre elas. Ou seja, estruturas do tipo `a <- 1 b <- 2` serão aceitas pelo parser, mesmo sabendo que são incorretas. Mas note que esta escrita é altamente inusual em programas R.

### Testes realizados

Foram realizadas baterias de testes, que vão desde todas as combinações posicionais de condicionais `if ... else`, códigos voltados ao aprendizado da linguagem (*learnxinyminutes.com*), à programas reais implementados pelo grupo anteriormente. Ademais, erros léxicos como `"abc` e numerais `0x`; além de erros de sintaxe como parênteses que abrem mas não fecham; palavras-chave sendo usada numa posição inesperada; dois números um ao lado do outro sem nenhum operador entre eles; duas instruções sem um ponto-e-vírgula entre elas, também foram analisados. Conforme mencionado anteriormente, os dois últimos erros ainda estão sendo aceitos pelo pelo parser. Ao demais, não conseguimos encontrar outros casos que **não** foram cobertos pela nossa implementação.