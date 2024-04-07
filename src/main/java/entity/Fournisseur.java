package entity;

public class Fournisseur {

    // attribute déclaration
    private int id;
    private String libelle;
    private String tel;
    private String email;


    public Fournisseur(int id, String libelle, String tel, String email) {
        this.id = id;
        this.libelle = libelle;
        this.tel = tel;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
