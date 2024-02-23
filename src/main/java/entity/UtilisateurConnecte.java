package entity;
import java.sql.SQLException;
public class UtilisateurConnecte extends Utilisateur {
    private static UtilisateurConnecte uniqueInstance;

    private UtilisateurConnecte(String email, String mdp){
        super(email,mdp);
    }
    public static UtilisateurConnecte getUniqueInstance(){

        return uniqueInstance;
    }
    public static void setUniqueInstance(){
        uniqueInstance = null;
    }
    public static synchronized UtilisateurConnecte connectUser(String email, String mdp) throws SQLException {
        if(uniqueInstance == null){
            synchronized (Utilisateur.class) {
                uniqueInstance = new UtilisateurConnecte(email,mdp);
                uniqueInstance.login();
            }
        }
        return uniqueInstance;
    }
}

