package entity;
import entity.Utilisateur.GestionnaireStock;

public class DemandeFournitureProfesseur {
    private int id;
    private String raison;

    private  String fournituresDemandees;

    private int quantiteDemandee;

    private boolean validee;
    private GestionnaireStock gestionnaireStock;

    public DemandeFournitureProfesseur(int id, String raison, String fournituresDemandees, int quantiteDemandee, Utilisateur.GestionnaireStock gestionnaireStock) {
        this.id = id;
        this.raison = raison;
        this.fournituresDemandees = fournituresDemandees;
        this.quantiteDemandee = quantiteDemandee;
        this.validee = false;
        this.gestionnaireStock = gestionnaireStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean estValidee() {
        return validee;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getFournituresDemandees() {
        return fournituresDemandees;
    }

    public void setFournituresDemandees(String fournituresDemandees) {
        this.fournituresDemandees = fournituresDemandees;
    }

    public int getQuantiteDemandee() {
        return quantiteDemandee;
    }

    public void setQuantiteDemandee(int quantiteDemandee) {
        this.quantiteDemandee = quantiteDemandee;
    }
    public GestionnaireStock getGestionnaireStock() {
        return gestionnaireStock;
    }

    public void setGestionnaireStock(GestionnaireStock gestionnaireStock) {
        this.gestionnaireStock = gestionnaireStock;
    }

    @Override
    public String toString() {
        return "DemandeFourniture{" +
                "id=" + id +
                ", raison='" + raison + '\'' +
                ", fournituresDemandees='" + fournituresDemandees + '\'' +
                ", quantiteDemandee=" + quantiteDemandee +
                ", validee=" + validee +
                ", gestionnaireStock=" + gestionnaireStock +
                '}';
    }

}
