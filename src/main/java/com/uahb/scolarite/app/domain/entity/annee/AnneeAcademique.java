package com.uahb.scolarite.app.domain.entity.annee;

import com.uahb.scolarite.app.domain.exception.ScolariteException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AnneeAcademique {

    private final AnneeAcademiqueId anneeAcademiqueId;
    private  LocalDate dateOuverture;
    private  LocalDate dateFermeture;
    private  LocalDate dateOuvertureInscription;
    private  LocalDate dateFermetureInscription;
    private  LocalDate datePublication;
    private  Statut statut;

    public AnneeAcademique(AnneeAcademiqueId anneeAcademiqueId, Statut statut) {
        this.anneeAcademiqueId = anneeAcademiqueId;
        this.statut=Statut.BROUILLON;
    }

    public void creer(CalendrierScolaire calendrierScolaire){
        initialiserDate(calendrierScolaire);
    }

    private void initialiserDate(CalendrierScolaire calendrierScolaire){
        if (!calendrierScolaire.getDateOuverture().isBefore(calendrierScolaire.getDateFermeture())){
            throw new ScolariteException("La date de debut de l'année doit etre antérieure à la date de fermeture de l'année");
        }

        if (!calendrierScolaire.getDateOuvertureInscription().isBefore(calendrierScolaire.getDateFermetureInscription())){
            throw new ScolariteException("La date de debut des inscriptions doit etre antérieure à la date de fermeture des inscriptions");
        }

        if (calendrierScolaire.getDateOuvertureInscription().isAfter(calendrierScolaire.getDateOuverture())){
            throw new ScolariteException("L'ouverture des inscription doit etre avant la date d'ouverture de l'année scolaire");
        }

        if (!calendrierScolaire.getDateFermetureInscription().isAfter(calendrierScolaire.getDateOuverture())){
            throw new ScolariteException("La date d'arret des inscriptions doit etre postérieure au debut de l'année ");
        }

        if (!calendrierScolaire.getDateOuvertureInscription().isAfter(calendrierScolaire.getDateFermeture())){
            throw new ScolariteException("La date de d'arret des inscriptions doit etre antérieure ou égale à la fin de l'année");
        }

    }

    private void verifierMoisAnneeScolaire(){
        long mois = ChronoUnit.MONTHS.between(
                dateOuverture.withDayOfMonth(1),
                dateFermeture.withDayOfMonth(1)
        );

        if (dateOuverture.plusMonths(mois).isBefore(dateFermeture)) {
            mois++;
        }

        if (mois != 9) {
            throw new ScolariteException(
                    "Une année scolaire doit couvrir exactement "
                            + 9 + " mois"
            );
        }
    }

}
