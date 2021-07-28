# Compilador de Linguagem R 
## Lexer/Parser

R é uma linguagem de programação voltada a análise de dados estatísticos.
Inicialmente foi realizada a análise da gramática da linguagem R contida no repositório [CRAN](http://cran.r-project.org/doc/manuals/R-lang.html#Parser) e na implementação do lexer em C do [svn.r-project](http://svn.r-project.org/R/trunk/src/main/gram.y). Diante ao fato de que todas as informações já estavam disponíveis e implementadas no ANTLR, foi realizado um reaproveitamento dos arquivos definindo a gramática.

Como não existe almoço grátis, notou-se que estruturas aninhadas específicas sem marcadores de bloco `{ ... }`, expressões na mesma linha sem ponto-e-vírgula entre elas e operadores de atribuição globais `<<-` não estavam implementadas. Nós as implementamos. Estas expressões estão exemplificadas a seguir.

Destaca-se que devido à esses ajustes, a gramática foi considerada de forma a sempre considerar uma expressão sempre seguida de um *new line* ou de um ponto-e-vírgula, finalizando com `EOF`. Em outras palavras, um programa deve sempre ser finalizado com uma linha vazia. Curiosamente, a interface de programação [RStudio](https://www.rstudio.com/) já adiciona essa última linha automaticamente.

```{R}
if (x==0) {
    if (x==1) print(1)
    else print(2)
}

a <- 1; b <- 2

a <<- 2 # globalmente
```

Destaca-se que um caso específico e sintaticamente válido, contendo um comentário em uma nova linha entre condicionais, não é aceito pela gramática implementada.

```{R}
if (x==1)
    print(1)
# Some comments
else
    print(2)
```

### Testes realizados

Foram realizadas baterias de testes, que vão desde todas as combinações posicionais de condicionais `if ... else`, códigos voltados ao aprendizado da linguagem (*learnxinyminutes.com*), à programas reais implementados pelo grupo em vidas passadas. Ademais, erros léxicos como `"abc` e numerais `0x`; além de erros de sintaxe como parênteses que abrem mas não fecham; palavras-chave sendo usada numa posição inesperada; dois números um ao lado do outro sem nenhum operador entre eles; duas instruções sem um ponto-e-vírgula entre elas, também foram analisados. Conforme mencionado anteriormente, todos estes casos estão cobrtos pela gramática considerada, a não ser a exceção mencionada. Aos demais, não conseguimos encontrar outros casos que **não** foram cobertos pela nossa implementação.
