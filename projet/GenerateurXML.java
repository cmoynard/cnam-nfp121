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
    private Element root; // Add this line

    public GenerateurXML(String nomFichier) {
        this.nomFichier = nomFichier;
        this.lots = new HashMap<>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            this.doc = dBuilder.newDocument();
            this.root = doc.createElement("Lots"); // Create the root element
            this.doc.appendChild(this.root); // Append the root element to the document
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void gererDebutLotLocal(String nomLot) {
        this.currentLot = doc.createElement("Lot");
        this.currentLot.setAttribute("name", nomLot);
        this.root.appendChild(this.currentLot); // Append the current lot to the root element
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