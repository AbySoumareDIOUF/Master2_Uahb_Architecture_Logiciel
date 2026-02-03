package domaine.annee;

import com.uahb.scolarite.app.domain.entity.annee.AnneeAcademique;
import com.uahb.scolarite.app.domain.entity.annee.AnneeAcademiqueId;
import com.uahb.scolarite.app.domain.entity.annee.CalendrierScolaire;
import com.uahb.scolarite.app.domain.exception.ScolariteException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class anneeAcademiqueTest {
    @Test
    void creation_annee_en_brouillon_Test(){
        AnneeAcademique anneeAcademique = new AnneeAcademique(new AnneeAcademiqueId("2025-2026"));
        assertDoesNotThrow(()->anneeAcademique.creer(datesAnneeScolarite()));
    }

    @Test
    void modification_annee_en_brouillon_Test(){
        AnneeAcademique anneeAcademique = new AnneeAcademique(new AnneeAcademiqueId("2025-2026"));
        anneeAcademique.creer(datesAnneeScolarite());
        assertDoesNotThrow(()->anneeAcademique.modifier(datesAnneeScolariteModifier()));
    }


    @Test
    void publication_annee_en_brouillon_Test(){
        AnneeAcademique anneeAcademique = new AnneeAcademique(new AnneeAcademiqueId("2025-2026"));
        anneeAcademique.creer(datesAnneeScolarite());
        assertDoesNotThrow(()->anneeAcademique.publier(LocalDate.of(2025,9,1)));
    }

    /*
        A faire
            1. Ouvrir inscription avec echec
            2. Ouvrir inscription avec succee (2 cas de succèe)
            3. Fermer inscription avec echec
            4. Fermer inscription avec succee (2 cas de succèe)
            5. Suspendre inscription avec echec
            6. Suspendre inscription avec succee (2 cas de succèe)
            7. Cloturer inscription avec echec
            8. Cloturer inscription avec succee (2 cas de succèe)
          Recherche
            Gestion des évenement du domaine
     */

    private CalendrierScolaire datesAnneeScolarite(){
        return new CalendrierScolaire(
                LocalDate.of(2025,10,1),
                LocalDate.of(2026,6,30),
                LocalDate.of(2025,9,1),
                LocalDate.of(2025,10,15)
        );
    }

    private CalendrierScolaire datesAnneeScolariteModifier(){
        return new CalendrierScolaire(
                LocalDate.of(2025,10,1),
                LocalDate.of(2026,6,20),
                LocalDate.of(2025,9,1),
                LocalDate.of(2025,10,15)
        );
    }

}
