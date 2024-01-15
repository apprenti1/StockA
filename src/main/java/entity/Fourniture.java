package entity;

public class Fourniture {

    private int id;
    private String description;
    private String libelle;
    private int qte_stock;

    public Fourniture(int id, String description, String libelle, int qte_stock) {
        this.id = id;
        this.description = description;
        this.libelle = libelle;
        this.qte_stock = qte_stock;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQte_stock() {
        return qte_stock;
    }

    public void setQte_stock(int qte_stock) {
        this.qte_stock = qte_stock;
    }
}
