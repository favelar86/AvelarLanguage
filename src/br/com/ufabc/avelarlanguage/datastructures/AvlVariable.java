package br.com.ufabc.avelarlanguage.datastructures;

public class AvlVariable extends AvlSymbol {

    public static final int NUMBER=0;
    public static final int TEXT  =1;
    private int type;
    private String value;

    public AvlVariable(String name, int type, String value) {
        super(name);
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String generateJavaCode() {
        String str;
        if (type == NUMBER) {
            str = "double ";
        }
        else {
            str = "String ";
        }
        return str + " "+super.name+";";
    }

    @Override
    public String toString() {
        return "AvlVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
    }
}
