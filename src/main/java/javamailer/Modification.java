package javamailer;

import application.Main;
import repo.UtilisateurRepository;
import controller.Connexion;
import entity.Utilisateur;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Modification {
    private String email;
    public Modification(String email){
        this.email=email;
        this.mailerLost =  new MailerLost(this.email);
        System.out.println(this.email);
    }
    MailerLost mailerLost;
    @FXML
    private MFXPasswordField mdp;

    @FXML
    private Label Error;

    @FXML
    private MFXPasswordField Mdpconfirmer;

    @FXML
    void switchAccueil(MouseEvent event) {


    }

        @FXML
    void modifier(MouseEvent event) throws NoSuchAlgorithmException, SQLException {
        if(this.mdp.getText().equals(this.Mdpconfirmer.getText())){
            String mdp = this.mdp.getText();
            boolean aSpe = false,aMin=false,aMaj=false;
            String min ="azertyuiopqsdfghjklmwxcvbn";
            String max ="AZERTYUIOPQSDFGHJKLMWXCVBN";
            String spe ="?!%&$*.";
            if (mdp.length()>10){
                for (char c : mdp.toCharArray()) {
                    if (max.contains(c+""))
                        aMaj = true;
                    if (min.contains(c+""))
                        aMin = true;
                    if (spe.contains(c+""))
                        aSpe = true;
                }
            }
            if(aSpe && aMaj && aMin){
                MessageDigest md = MessageDigest.getInstance("SHA1");
                md.update(this.mdp.getText().getBytes());
                byte byteData[] = md.digest();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                }
                UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
                Utilisateur utilisateur = utilisateurRepository.findByEmail(this.email);

                // Mettez à jour le mot de passe de l'utilisateur
                utilisateur.setMdp(sb.toString());
                utilisateurRepository.updateMdp(utilisateur);

                Main.changeScene("/application/Connexion", new Connexion(),"connexion");
            }else {
                this.Error.setVisible(true);
            }
        }else{
            this.Error.setVisible(true);
        }
    }

}


