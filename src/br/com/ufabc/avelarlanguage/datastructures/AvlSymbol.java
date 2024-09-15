package br.com.ufabc.avelarlanguage.datastructures;

public abstract class AvlSymbol {

    protected String name;

    public abstract String generateJavaCode();
    public AvlSymbol(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "AvlSymbol [name=" + name + "]";
    }

}
