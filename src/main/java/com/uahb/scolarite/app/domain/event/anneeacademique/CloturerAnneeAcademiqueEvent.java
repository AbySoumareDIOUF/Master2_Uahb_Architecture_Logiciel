package com.uahb.scolarite.app.domain.event.anneeacademique;

import com.uahb.scolarite.app.domain.entity.annee.AnneeAcademique;

public class CreerAnneeAcademiqueEvent extends AnneeAcademiqueEvent{

    public CreerAnneeAcademiqueEvent(AnneeAcademique anneeAcademique) {
        super(anneeAcademique);
    }


}
