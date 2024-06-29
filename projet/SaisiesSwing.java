import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaisiesSwing extends JFrame {
    private static final Logger LOGGER = Logger.getLogger(SaisiesSwing.class.getName());
    private final JTextField absInput;
    private final JTextField ordInput;
    private final JTextField valInput;
    private int id = 1;
    private final String fichier;
    private final List<Data> données;

    public SaisiesSwing(String fichier) {
        this.fichier = fichier;
        this.données = new ArrayList<>();

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Abscisse:"));
        absInput = new JTextField(10);
        inputPanel.add(absInput);

        inputPanel.add(new JLabel("Ordonnee:"));
        ordInput = new JTextField(10);
        inputPanel.add(ordInput);

        inputPanel.add(new JLabel("Valeur:"));
        valInput = new JTextField(10);
        inputPanel.add(valInput);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton effacerButton = new JButton("Effacer");
        buttonPanel.add(effacerButton);

        JButton validerButton = new JButton("Valider");
        buttonPanel.add(validerButton);

        JButton terminerButton = new JButton("Terminer");
        buttonPanel.add(terminerButton);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(Box.createVerticalGlue());
        add(inputPanel);
        add(Box.createRigidArea(new Dimension(0, 10))); // Add some space
        add(buttonPanel);
        add(Box.createVerticalGlue());

        effacerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                absInput.setText("");
                ordInput.setText("");
                valInput.setText("");
            }
        });

        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValidInput = true;
                int abscisse = 0;
                int ordonnee = 0;
                double valeur = 0;

                try {
                    abscisse = Integer.parseInt(absInput.getText());
                } catch (NumberFormatException ex) {
                    absInput.setBackground(Color.RED);
                    isValidInput = false;
                }

                try {
                    ordonnee = Integer.parseInt(ordInput.getText());
                } catch (NumberFormatException ex) {
                    ordInput.setBackground(Color.RED);
                    isValidInput = false;
                }

                try {
                    valeur = Double.parseDouble(valInput.getText());
                } catch (NumberFormatException ex) {
                    valInput.setBackground(Color.RED);
                    isValidInput = false;
                }

                if (isValidInput) {
                    Data data = new Data(id, abscisse, ordonnee, valeur);
                    valInput.setBackground(Color.WHITE);
                    ordInput.setBackground(Color.WHITE);
                    absInput.setBackground(Color.WHITE);
                    données.add(data);
                    System.out.println("Data " + id + ": " + data);
                    id++;
                }
            }
        });

        terminerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new file
                String fileWithExtension;
                if (!fichier.endsWith(".txt")) {
                    fileWithExtension = fichier + ".txt";
                } else {
                    fileWithExtension = fichier;
                }
                File file = new File(fileWithExtension);
                try {
                    if (file.createNewFile()) {
                        System.out.println("File created: " + file.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Une erreur est survenue lors de la création du fichier", ex);
                }

                // Save the data to a file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier, true))) {
                    for (Data data : données) {
                        writer.write(data + "\n");
                    }
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Une erreur est survenue lors de l'écriture des données", ex);
                }

                System.exit(0);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setTitle("Saisie Swing");
        setVisible(true);
    }

    public static void main(String[] args) {
        new SaisiesSwing(args[0]);
    }
}