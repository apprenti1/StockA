package entity;

public class Etudiant {
    private int id;
    private String dernier_diplome;
    private int tel;
    private String adresse;
    private int ref_utilisateur;

    public Etudiant(int id, String dernier_diplome, int tel, String adresse, int ref_utilisateur) {
        this.id = id;
        this.dernier_diplome = dernier_diplome;
        this.tel = tel;
        this.adresse = adresse;
        this.ref_utilisateur = ref_utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDernier_diplome() {
        return dernier_diplome;
    }

    public void setDernier_diplome(String dernier_diplome) {
        this.dernier_diplome = dernier_diplome;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getRef_utilisateur() {
        return ref_utilisateur;
    }

    public void setRef_utilisateur(int ref_utilisateur) {
        this.ref_utilisateur = ref_utilisateur;
    }
}
