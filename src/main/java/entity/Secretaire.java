package entity;

    public class Secretaire extends Utilisateur {
        private int id_secretaire;

        public Secretaire(int id_secretaire, String nom, String prenom, String email, String mdp, int role) {
            super(id_secretaire, nom, prenom, email, mdp, role);
            this.id_secretaire = id_secretaire;
        }
    }