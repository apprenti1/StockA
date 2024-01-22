package entity;

public class Fournisseur {

    private int id;
    private String libelle;
    private int tel;
    private String email;

    public Fournisseur(int id, String libelle, int tel, String email) {
        this.id = id;
        this.libelle = libelle;
        this.tel = tel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", nom='" + libelle + '\'' +
                ", telephone='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
