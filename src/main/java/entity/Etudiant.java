package entity;

public class Etudiant {
    private int id;
    private String dernierDiplome;
    private String  tel;
    private String adresse;
    private Utilisateur utilisateur;

    public Etudiant(int id, String dernierDiplome, String tel, String adresse, Utilisateur utilisateur) {
        this.id = id;
        this.dernierDiplome = dernierDiplome;
        this.tel = tel;
        this.adresse = adresse;
        this.utilisateur = utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDernierDiplome() {
        return dernierDiplome;
    }

    public void setDernierDiplome(String dernierDiplome) {
        this.dernierDiplome = dernierDiplome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                ", dernierDiplome='" + dernierDiplome + '\'' +
                ", telephone='" + tel + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
