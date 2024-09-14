package br.com.ufabc.avelarlanguage.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class AvlSymbolTable {

    private HashMap<String, AvlSymbol> map;

    public AvlSymbolTable() {
        map = new HashMap<String, AvlSymbol>();
    }

    public void add(AvlSymbol symbol) {
        map.put(symbol.getName(), symbol);
    }

    public boolean exists(String symbolName) {
        return map.get(symbolName) != null;
    }

    public AvlSymbol get(String symbolName) {
        return map.get(symbolName);
    }

    public ArrayList<AvlSymbol> getAll(){
        ArrayList<AvlSymbol> lista = new ArrayList<AvlSymbol>();
        for (AvlSymbol symbol : map.values()) {
            lista.add(symbol);
        }
        return lista;
    }

}
