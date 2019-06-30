package com.breahst.calc;


public class Achat {
    private String item;
    private int qte = 0;

    public Achat(String item, int qte) {
        this.item = item;
        this.qte = qte;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
    public void addQte(){
        this.qte++;
    }
    public void removeQte(){
        if(qte>0) qte--;
    }


}
