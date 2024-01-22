package entity;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private Role role;

    public Utilisateur(int id, String nom, String prenom, String email, String mdp, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public enum Role {
        GESTIONNAIRE_STOCK,
        PROFESSEUR,
        SECRETAIRE
    }

    public class GestionnaireStock extends Utilisateur {
        public GestionnaireStock(int id, String nom, String prenom, String email, String mdp) {
            super(id, nom, prenom, email, mdp, Role.GESTIONNAIRE_STOCK);
        }

        // Ajoutez des méthodes spécifiques à un gestionnaire de stock si nécessaire
        // ...

        @Override
        public String toString() {
            return "GestionnaireStock{" +
                    "id=" + getId() +
                    ", nom='" + getNom() + '\'' +
                    ", prenom='" + getPrenom() + '\'' +
                    ", email='" + getEmail() + '\'' +
                    ", role='" + Role.GESTIONNAIRE_STOCK + '\'' +
                    '}';
        }
    }

    public class Professeur extends Utilisateur {
        public Professeur(int id, String nom, String prenom, String email, String mdp) {
            super(id, nom, prenom, email, mdp, Role.PROFESSEUR);
        }

        // Ajoutez des méthodes spécifiques à un professeur si nécessaire
        // ...

        @Override
        public String toString() {
            return "Professeur{" +
                    "id=" + getId() +
                    ", nom='" + getNom() + '\'' +
                    ", prenom='" + getPrenom() + '\'' +
                    ", email='" + getEmail() + '\'' +
                    ", role='" + Role.PROFESSEUR + '\'' +
                    '}';
        }
    }
}
