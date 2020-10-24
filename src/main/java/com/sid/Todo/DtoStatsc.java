package com.sid.Todo;

public class DtoStatsc {
    private int Ouvert;
    private int Cours;
    private int complete;
    private int Retard;
    private int TerminerRetard;



    public int getOuvert() {
        return Ouvert;
    }

    public void setOuvert(int ouvert) {
        Ouvert = ouvert;
    }

    public int getCours() {
        return Cours;
    }

    public void setCours(int cours) {
        Cours = cours;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getRetard() {
        return Retard;
    }

    public void setRetard(int retard) {
        Retard = retard;
    }

    public int getTerminerRetard() {
        return TerminerRetard;
    }

    public void setTerminerRetard(int terminerRetard) {
        TerminerRetard = terminerRetard;
    }
}
