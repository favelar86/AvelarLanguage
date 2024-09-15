package br.com.ufabc.avelarlanguage.ast;

import br.com.ufabc.avelarlanguage.datastructures.AvlVariable;

public class CommandLeitura extends AbstractCommand {
    private String id;
    private AvlVariable var;

    public CommandLeitura (String id, AvlVariable var) {
        this.id = id;
        this.var = var;
    }
    @Override
    public String generateJavaCode() {
        // TODO Auto-generated method stub
        return id +"= _key." + (var.getType()==AvlVariable.NUMBER? "nextDouble();": "nextLine();");
    }
    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + "]";
    }
}
