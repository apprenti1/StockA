package entity;


    public class GestionnaireStock extends Utilisateur {
        private int id_gestionnaireStock;
        public GestionnaireStock(int id_gestionnaireStock, String nom, String prenom, String email, String mdp, int role){
            super(id_gestionnaireStock, nom, prenom, email, mdp, role);
            this.id_gestionnaireStock = id_gestionnaireStock;
        }
    }
