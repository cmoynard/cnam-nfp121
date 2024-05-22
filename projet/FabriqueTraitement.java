/**
  * FabriqueTraitement permet de construire les traitments demandÃ©s.
  * Cette classe peut Ãªtre complÃ©tÃ©e si nÃ©cessaire.
  * Son seul intÃ©rÃªt est de pouvoir Ã©crire les classes fournies sans
  * qu'elles provoquent des erreurs.  Les erreurs seront pour l'essentiel
  * localisÃ©es dans FabriqueTraitementConcrete.
  *
  * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
  */

public interface FabriqueTraitement {

	SommeAbstrait somme();
	PositionsAbstrait positions();
	Donnees donnees();
	Multiplicateur multiplicateur(double facteur);
	/*
	SommeParPosition sommeParPosition();
	SupprimerPlusGrand supprimerPlusGrand(double seuil);
	SupprimerPlusPetit supprimerPlusPetit(double seuil);
	Max max();
	Normaliseur normaliseur(double debut, double fin);
	GenerateurXML generateurXML(String nomFichier);
	Maj maj();
	*/

}
