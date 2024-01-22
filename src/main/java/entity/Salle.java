package entity;

public class Salle {
    private int id;
    private String nom;

    private boolean occupee;

    public Salle(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.occupee = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean estOccupee(){
        return occupee;
    }
    public void setOccupee(boolean occupee){
        this.occupee = occupee;
    }
    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", occupee=" + occupee +
                '}';
    }
}
