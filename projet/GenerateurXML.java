/**
 * GenerateurXML Ã©crit dans un fichier, Ã  charque fin de lot, toutes
 * les donnÃ©es lues en indiquant le lot dans le fichier XML.
 *
 * @author	Xavier CrÃ©gut <Prenom.Nom@enseeiht.fr>
 */
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import java.io.*;
import java.util.*;

public class GenerateurXML extends Traitement {
    private final String nomFichier;
    private Document doc;
    private Element currentLot;
    private final Map<String, List<AbstractMap.SimpleEntry<Position, Double>>> lots;

    public GenerateurXML(String nomFichier) {
        this.nomFichier = nomFichier;
        this.lots = new HashMap<>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void gererDebutLotLocal(String nomLot) {
        this.currentLot = doc.createElement("Lot");
        this.currentLot.setAttribute("name", nomLot);
        this.doc.appendChild(this.currentLot);
        this.lots.put(nomLot, new ArrayList<>());
    }

    @Override
    public void traiter(Position position, double valeur) {
        super.traiter(position, valeur);
        this.lots.get(currentLot.getAttribute("name")).add(new AbstractMap.SimpleEntry<>(position, valeur));

        Element data = doc.createElement("Data");
        data.setAttribute("position", position.toString());
        data.setAttribute("value", String.valueOf(valeur));
        this.currentLot.appendChild(data);
    }

    @Override
    protected void gererFinLotLocal(String nomLot) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(nomFichier));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}