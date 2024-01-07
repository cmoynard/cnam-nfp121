import org.jdom.*;
import org.jdom.output.*;

public class SerialiseurConcret implements Serialiseur {

	public void serialiser(Plateforme plateforme, java.io.Writer out)
			throws java.io.IOException
	{
		// Création du document XML
		Element racine = new Element("crowdlending");
		DocType docType = new DocType("crowdlending", "crowdlending.dtd");
		Document document = new Document(racine, docType);

		...

		// Production du fichier XML
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
		sortie.output(document, out);
	}
}
