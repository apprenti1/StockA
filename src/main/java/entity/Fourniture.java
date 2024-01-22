package entity;

public class Fourniture {

    private int id;
    private String description;
    private String libelle;
    private int quantiteEnStock;

    public Fourniture(int id, String description, String libelle, int quantiteEnStock) {
        this.id = id;
        this.description = description;
        this.libelle = libelle;
        this.quantiteEnStock = quantiteEnStock;
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

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    @Override
    public String toString() {
        return "Fourniture{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", quantiteEnStock=" + quantiteEnStock +
                '}';
    }
}
