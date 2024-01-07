import org.jdom.*;
import org.jdom.output.*;

public class QuestionnaireUtil {

	public static void sauverXML(Questionnaire questionnaire, java.io.Writer out)
			throws java.io.IOException
	{

		DocType docType = new DocType("questionnaire", "questionnaire.dtd");
		Document document = new Document(........., docType);

		// Production du fichier XML
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		sortie.output(document, out);
}	}
