package entity;
import java.util.List;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalTime;

import java.util.List;
import java.util.Map;
import controller.Default;

public class Salle {

    // attribute déclaration
    private int id;
    private String libelle;
    private boolean disponible;
    private List<RDV> rendezVousPlanifies;

    private Map<DayOfWeek, List<Creneau>> creneauxDisponibles;

    public Salle( String libelle) {

        this.libelle = libelle;
    }

    public Salle(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
        this.disponible = true;
        this.creneauxDisponibles = new HashMap<>();
    }

    public void ajouterCreneauDisponible(DayOfWeek jour, Creneau creneau) {
        creneauxDisponibles.computeIfAbsent(jour, k -> new ArrayList<>()).add(creneau);
    }

    public boolean estCreneauDisponible(DayOfWeek jour, Creneau creneau) {
        List<Creneau> creneauxJour = creneauxDisponibles.get(jour);
        if (creneauxJour != null) {
            for (Creneau c : creneauxJour) {
                if (c.getDebut().equals(creneau.getDebut()) && c.getFin().equals(creneau.getFin())) {
                    return true;
                }
            }
        }
        return false;
    }
    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public List<RDV> getRendezVousPlanifies() {
        return rendezVousPlanifies;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setRendezVousPlanifies(List<RDV> rendezVousPlanifies) {
        this.rendezVousPlanifies = rendezVousPlanifies;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public class Creneau {
        private LocalTime debut;
        private LocalTime fin;

        public Creneau(LocalTime debut, LocalTime fin) {
            this.debut = debut;
            this.fin = fin;
        }

        public LocalTime getDebut() {
            return debut;
        }

        public LocalTime getFin() {
            return fin;
        }

        public void setDebut(LocalTime debut) {
            this.debut = debut;
        }

        public void setFin(LocalTime fin) {
            this.fin = fin;
        }
        public boolean planifierRendezVous(DayOfWeek jour, Creneau creneau) {
            List<Creneau> creneauxJour = creneauxDisponibles.get(jour);
            if (creneauxJour != null && creneauxJour.contains(creneau)) {
                // Le créneau est disponible, marquer le créneau comme occupé
                creneauxJour.remove(creneau);

                // Ajouter le rendez-vous planifié
                RDV rendezVous = new RDV(jour, creneau); // Créez votre classe RDV avec les informations nécessaires
                rendezVousPlanifies.add(rendezVous);

                return true;
            } else {
                // Le créneau n'est pas disponible
                return false;
            }
        }
    }
}
