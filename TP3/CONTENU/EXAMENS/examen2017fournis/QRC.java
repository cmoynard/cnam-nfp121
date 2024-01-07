/**
  * QRC 
  *
  * @author	Xavier Crégut <Prenom.Nom@enseeiht.fr>
  */

public class QRC implements IQRC {

	private String id;
	private String texte;
	private String reponse;

	public QRC(String id, String texte, String reponse) {
		this.id = id;
		this.texte = texte;
		this.reponse = reponse;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getTexte() {
		return this.texte;
	}

	@Override
	public String getReponse() {
		return this.reponse;
	}

}
