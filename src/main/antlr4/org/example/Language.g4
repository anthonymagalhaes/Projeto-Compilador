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

listCmd : cmdIf | cmdIf PVIG listCmd ;

cmdIf : cmdIfCasado | cmdIfNaoCasado ;

cmdIfCasado : IF expr THEN cmdIfCasado ELSE cmdIfCasado | WHILE expr DO cmdIfCasado | cmds  ;

cmdIfNaoCasado : IF expr THEN cmdIf | IF expr THEN cmdIfCasado ELSE cmdIfNaoCasado | WHILE expr DO cmdIfNaoCasado  ;

cmds : cmdRead | cmdWrite | cmdAtrib | cmdComp ;

cmdRead : READ ABPAR listId FPAR ;

cmdWrite : WRITE ABPAR listW FPAR ;

listW : elemW | listW VIG elemW ;

elemW : expr ;

cmdAtrib : IDENTIFIER ATRIB expr ;

expr: expr OPLOG exprRel | exprRel ;

exprRel : exprRel OPREL exprSimple | exprSimple ;

exprSimple: exprSimple OPAD exprMult | exprMult ;

exprMult: exprMult OPMULT termo | termo ;

termo : IDENTIFIER
      | CTE
      | CADEIA
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

COMENTARIO: '//' .*? '//' -> skip;

ERRO_LEXICO: . {exibirErroLexico();};