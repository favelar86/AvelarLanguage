grammar Avelarlang;

@header{
    import br.com.ufabc.avelarlanguage.datastructures.AvlSymbol;
    import br.com.ufabc.avelarlanguage.datastructures.AvlSymbolTable;
    import br.com.ufabc.avelarlanguage.datastructures.AvlVariable;
    import br.com.ufabc.avelarlanguage.exceptions.AvlSemanticException;
    import br.com.ufabc.avelarlanguage.ast.AbstractCommand;
    import br.com.ufabc.avelarlanguage.ast.CommandLeitura;
    import br.com.ufabc.avelarlanguage.ast.CommandEscrita;
    import br.com.ufabc.avelarlanguage.ast.CommandAtribuicao;
    import br.com.ufabc.avelarlanguage.ast.CommandDecisao;
    import br.com.ufabc.avelarlanguage.ast.AvlProgram;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private AvlSymbolTable symbolTable = new AvlSymbolTable();
	private AvlSymbol symbol;
	private AvlProgram program = new AvlProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
    private String _exprID;
    private String _exprContent;
    private String _exprDecision;
    private ArrayList<AbstractCommand> listaTrue;
    private ArrayList<AbstractCommand> listaFalse;

	public void verificaID(String id){
        if (!symbolTable.exists(id)){
    	    throw new AvlSemanticException("Symbol "+id+" not declared");
    	}
    }

    public void exibeComandos(){
        for (AbstractCommand c: program.getComandos()){
    	    System.out.println(c);
    	}
    }

    public void generateCode(){
        program.generateTarget();
    }
}

prog	: 'programa' decl bloco  'fimprog;'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());

           }
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

tipo       : 'numero' { _tipo = AvlVariable.NUMBER;  }
           | 'texto'  { _tipo = AvlVariable.TEXT;  }
           ;

bloco	: { curThread = new ArrayList<AbstractCommand>();
	        stack.push(curThread);
          }
          (cmd)+
		;

cmd     : cmdleitura
        | cmdescrita
        | cmdattrib
        | cmdselecao
        ;

cmdleitura	: 'leia' AP
                     ID { verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        }
                     FP
                     SC

              {
              	AvlVariable var = (AvlVariable)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }
			;

cmdescrita	: 'escreva'
                 AP
                 ID { verificaID(_input.LT(-1).getText());
	                  _writeID = _input.LT(-1).getText();
                     }
                 FP
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;

cmdattrib	:  ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   }
               ATTR { _exprContent = ""; }
               expr
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;

cmdselecao  :  'se' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER) {_exprDecision += _input.LT(-1).getText(); }
                    FP
                    ACH
                    { curThread = new ArrayList<AbstractCommand>();
                      stack.push(curThread);
                    }
                    (cmd)+

                    FCH
                    {
                       listaTrue = stack.pop();
                    }
                   ('senao'
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 }
                   	(cmd+)
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;

expr		:  termo (
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
			;

termo		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 }
            |
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
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

ACH : '{'
    ;

FCH : '}'
    ;

OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;

ID  : [a-z] ([a-z] | [A-Z] | [0-9])*
    ;

NUMBER  : [0-9]+ ('.' [0-9]+)?
        ;

WS	: (' ' | '\t' | '\n' | '\r') -> skip;