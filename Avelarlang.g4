grammar Avelarlang;

@header{
    import br.com.ufabc.avelarlanguage.datastructures.AvlSymbol;
    import br.com.ufabc.avelarlanguage.datastructures.AvlSymbolTable;
    import br.com.ufabc.avelarlanguage.datastructures.AvlVariable;
    import br.com.ufabc.avelarlanguage.exceptions.AvlSemanticException;
    import java.util.ArrayList;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private AvlSymbolTable symbolTable = new AvlSymbolTable();
	private AvlSymbol symbol;
	private String _readID;
	private String _writeID;
    private String _exprID;
    private String _exprContent;

	public void verificaID(String id){
        if (!symbolTable.exists(id)){
    	    throw new AvlSemanticException("Symbol "+id+" not declared");
    	}
    }
}

prog    : 'programa'    decl    bloco   'fimprog;'
        ;

decl    :   (declaravar)+
        ;

declaravar :  tipo ID  {
	                     _varName = _input.LT(-1).getText();
	                     _varValue = null;
	                     symbol = new AvlVariable(_varName, _tipo, _varValue);
	                     if (!symbolTable.exists(_varName)){
	                        symbolTable.add(symbol);
	                     }
	                     else{
	                  	    throw new AvlSemanticException("Symbol "+_varName+" already declared");
	                     }
                       }
              (  VIR
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new AvlVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);
	                  }
	                  else{
	                  	 throw new AvlSemanticException("Symbol "+_varName+" already declared");
	                  }
                    }
              )*
               SC
           ;

tipo        :   'numero' { _tipo = AvlVariable.NUMBER;  }
            ;

bloco   : (cmd)+
        ;

cmd     : cmdleitura
        | cmdescrita
        | cmdattrib
        ;

cmdleitura  :   'leia' AP
                       ID { verificaID(_input.LT(-1).getText());
                            _readID = _input.LT(-1).getText();
                          }
                       FP
                       SC
            ;

cmdescrita  : 'escreva' AP
                        ID { verificaID(_input.LT(-1).getText());
                        	 _writeID = _input.LT(-1).getText();
                           }
                        FP
                        SC
            ;

cmdattrib   : ID { verificaID(_input.LT(-1).getText());
                   _exprID = _input.LT(-1).getText();
                 }
              ATTR
              expr
              SC
            ;

expr        : termo ( OP termo )*
            ;

termo       : ID { verificaID(_input.LT(-1).getText());
                   _exprContent += _input.LT(-1).getText();
                 }
            | NUMBER
            ;

AP  : '('
    ;

FP  : ')'
    ;

SC  : ';'
    ;

OP  : '+' | '-' | '*' | '/'
    ;

ATTR : '='
     ;

VIR : ','
    ;

ID  : [a-z] ([a-z] | [A-Z] | [0-9])*
    ;

NUMBER  : [0-9]+ ('.' [0-9]+)?
        ;

WS	: (' ' | '\t' | '\n' | '\r') -> skip;