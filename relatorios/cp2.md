# Compilador de Linguagem R 

Leandro Furlam e Isauflânia Ribeiro

## Árvore de Sintaxe Abstrata (AST)

Após termos em mãos o Lexer e o Parser do CP1, construímos a AST seguindo como base os exemplos dos laboratórios anteriores e a ferramenta ANTLR. Foram realizadas algumas simplificações, entretanto todos os aspectos solicitados na descrição do CP2 foram cobertos. Também destaca-se que nenhuma mudança significativa foi realizada na gramática.

### Tipagem

R possui uma grande gama de tipos primitivos, conforme descrito na sua [documentação](https://cran.r-project.org/doc/manuals/r-release/R-lang.html). Simplificamos seguindo como base os tipos gerais presentes nas linguagens, além dos tipos que consideramos que mais caracterizam R. Os que foram mantidos estão destacados em **negrito** na lista a seguir:

* **NULL**: NULL
* **symbol**: a variable name
* pairlist: a pairlist object (mainly internal)
* **closure**: a function
* environment:	an environment
* promise: an object used to implement lazy evaluation
* language: an R language construct
* special: an internal function that does not evaluate its arguments
* builtin: an internal function that evaluates its arguments
* char: a ‘scalar’ string object (internal only) ***
* **logical**: a vector containing logical values
* **integer**: a vector containing integer values
* **double**: a vector containing real values
* complex: a vector containing complex values
* **character**: a vector containing character values
*  ...: the special variable length argument ***
* any: a special type that matches all types: there are no objects of this type
* expression: an expression object
* **list**:	a list
* bytecode: byte code (internal only) ***
* externalptr: an external pointer object
* weakref: a weak reference object
* raw: a vector containing bytes
* S4: an S4 object which is not a simple object

Destaca-se que um vetor possui o tipo primitivo de seus elementos, ou seja, em `vec <- (1,2,3)` a variável `vec` será do tipo integer. Também foi realizada unificação e criação de nós de conversão, quando necessários.

#### Conversão

Acerca da conversão, existem dois grandes grupos. Em conversões aritméticas, segue-se a prioridade: logical < integer < double. Já em conversões lógicas, tudo é convertido para o tipo logical. Um professor atento deve notar que não mencionamos o tipo complex. De fato, dado que o manejo com números complexos em Java é repugnante, decidimos omitir esta tipagem.

#### Simplificações

Mais uma vez, um professor astuto pode ligar os pontos e perceber então que R é uma linguagem vetorizada. Isso significa que expressões como `c(1,2,3) + c(1,2,3)` devem ser aceitas e resultar em `2 4 6`, visto que `c(1,2,3)` é do tipo integer e elementos do tipo integer podem ser somados. Entretanto contudo porém e todavia, foi-nos alertado que tal tipo de expressão é possível através de uma complexa gerência de memória. Por conta disso, tal característica foi omitida e dada como não aceita no nosso compilador em construção. Outros exemplos omitidos estão presentes no arquivo *not_considered.R*.

### Testes realizados

Neste CP2 alteramos os testes que havíamos previamente definido no CP1, buscando de fato observar apenas as estruturas intrínsecas da linguagem. Para isso, foram utilizados os códigos voltados ao aprendizado da linguagem, presentes em  [learnxinyminutes.com](learnxinyminutes.com).

Os testes com condicionais complexos continuam sendo aceitos

```{R}
if (x==0) {
    if (x==1) print(1)
    else print(2)
}
```

Bem como toda a tipagem

```{R}
TRUE
class(5L) # "integer"
class(c(5.8, 5L, 8L, 3L)) # "double"
```

Toda a extensão dos testes realizados está presente no diretório *tests*. Destaca-se apenas o caso relacionado à tipagem, `c(5.8, 5L, 8L, 3L)` no qual o nó na AST receberá o tipo double, e não de call relacionado à chamada do método de concatenação `c`.

Veja também que dada a tipagem dinâmica da linguagem, todas as variáveis declaradas possuirão o tipo correspondente ao elemento que as foi atribuído, como em

```{R}
myString <- "Hellor word"
myString <- 1
```

A tabela de variáveis será

```{bash}
Variables table:
Entry 0 -- name: myString, line: 1, type: integer
```
