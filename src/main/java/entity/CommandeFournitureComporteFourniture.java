package entity;

public class CommandeFournitureComporteFourniture {
    private int quantite;
    private int ref_commandefourniture;
    private int ref_fourniture;

    public CommandeFournitureComporteFourniture(int quantite, int ref_commandefourniture, int ref_fourniture) {
        this.quantite = quantite;
        this.ref_commandefourniture = ref_commandefourniture;
        this.ref_fourniture = ref_fourniture;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getRef_commandefourniture() {
        return ref_commandefourniture;
    }

    public void setRef_commandefourniture(int ref_commandefourniture) {
        this.ref_commandefourniture = ref_commandefourniture;
    }

    public int getRef_fourniture() {
        return ref_fourniture;
    }

    public void setRef_fourniture(int ref_fourniture) {
        this.ref_fourniture = ref_fourniture;
    }
}
