grammar Language;
@header { package org.example.gen;}
@lexer::members{
    private void exibirErroLexico(){
        throw new RuntimeException(
            "Falha na análise léxica: O símbolo '" + getText() + "' na linha " + getLine() + ", coluna " + getCharPositionInLine() + " não pertence à linguagem."
        );
    }

    private void exibirErroMemoria(){
        throw new RuntimeException(
            "Falha na análise léxica: O valor '" + getText() + "' na linha " + getLine() + ", coluna " + getCharPositionInLine() + " excede o limite de 2 bytes."
        );
    }
}
options{
    caseInsensitive = true;
}

prog : PROGRAM IDENTIFIER PVIG decls cmdComp PONTO ;

decls : VAR listDecl | ;

listDecl : declTip | declTip listDecl ;

declTip : listId DPONTOS tip PVIG ;

listId : IDENTIFIER | IDENTIFIER VIG listId ;

tip : INTEGER | BOOLEAN | STRING ;

cmdComp : BEGIN listCmd END ;

listCmd : cmd | cmd PVIG listCmd ;

cmd : cmdIf | cmdWhile | cmdRead | cmdWrite | cmdAtrib | cmdComp ;

cmdIf : IF expr THEN cmd | IF expr THEN cmd ELSE cmd ;

cmdWhile : WHILE expr DO cmd ;

cmdRead : READ ABPAR listId FPAR ;

cmdWrite : WRITE ABPAR listW FPAR ;

listW : elemW | elemW VIG listW ;

elemW : expr | CADEIA ;

cmdAtrib : IDENTIFIER ATRIB expr ;

expr: expr OPLOG exprRel | exprRel ;

exprRel : exprRel OPREL exprSimple | exprSimple ;

exprSimple: exprSimple OPAD exprMult | exprMult ;

exprMult: exprMult OPMULT termo | termo ;

termo : IDENTIFIER
      | CTE
      | ABPAR expr FPAR
      | TRUE
      | FALSE
      | OPNEG termo
      | OPAD termo ;

PROGRAM : 'program';
INTEGER : 'integer';
BOOLEAN : 'boolean';
BEGIN : 'begin';
END : 'end';
WHILE : 'while';
DO : 'do';
READ : 'read';
VAR : 'var';
FALSE: 'false';
TRUE: 'true';
WRITE: 'write';
OPAD : '+' | '-';
OPMULT: '*' | '/';
OPLOG: 'or' | 'and';
OPNEG: '~';
OPREL: '<' | '<=' | '>' | '>=' | '==' | '<>';
PVIG: ';';
ATRIB: ':=';
PONTO: '.';
DPONTOS: ':';
VIG: ',';
ABPAR: '(';
FPAR: ')';
STRING: 'string';
CADEIA: '"' .*? '"';
IF: 'if';
ELSE: 'else';
THEN: 'then';
CTE : [0-9]+ {
    try{
        Short.parseShort(getText());
    } catch (NumberFormatException e) {
        exibirErroMemoria();
    }
};

IDENTIFIER : [a-z][a-z0-9]* {
        if (getText().length() > 16) {
            setText(getText().substring(0, 16));
        }
    }
;

WS: [ \t\r\n]+ -> skip;

COMENTARIO: '/' ~[/]* '/' -> skip;

ERRO_LEXICO: . {exibirErroLexico();};
