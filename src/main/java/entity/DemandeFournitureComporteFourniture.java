package entity;

public class DemandeFournitureComporteFourniture {
    private int quantite;
    private int ref_fourniture;
    private int ref_demandefourniture;

    public DemandeFournitureComporteFourniture(int quantite, int ref_fourniture, int ref_demandefourniture) {
        this.quantite = quantite;
        this.ref_fourniture = ref_fourniture;
        this.ref_demandefourniture = ref_demandefourniture;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getRef_fourniture() {
        return ref_fourniture;
    }

    public void setRef_fourniture(int ref_fourniture) {
        this.ref_fourniture = ref_fourniture;
    }

    public int getRef_demandefourniture() {
        return ref_demandefourniture;
    }

    public void setRef_demandefourniture(int ref_demandefourniture) {
        this.ref_demandefourniture = ref_demandefourniture;
    }
}
