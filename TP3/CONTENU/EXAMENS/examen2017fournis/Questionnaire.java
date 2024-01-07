import java.util.*;

public class Questionnaire implements Iterable<IQRC> {

	private List<IQRC> questions;

	public Questionnaire() {
		this.questions = new ArrayList<>();
	}

	public void ajouter(IQRC question) {
		this.questions.add(question);
	}

	public Iterator<IQRC> iterator() {
		return this.questions.iterator();
	}

}
