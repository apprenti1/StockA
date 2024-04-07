package entity;

public class Fourniture {

    // attribute déclaration
    private int id;
    private String description;
    private String libelle;
    private int qteStock;


    public Fourniture(int id, String description, String libelle, int qteStock) {
        this.id = id;
        this.description = description;
        this.libelle = libelle;
        this.qteStock = qteStock;
    }


    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLibelle() {
        return libelle;
    }

    public int getQteStock() {
        return qteStock;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }
}
