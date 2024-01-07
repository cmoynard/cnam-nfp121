import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

/** Abstraire les saisies clavier.
  * @author	Xavier Crégut
  * @version	$Revision$
  */
// XXX public
class Console {

	static private Clavier clavier = new Clavier(System.in);

	static public char readChar() {
		return clavier.readChar();
	}

	static public String readString() {
		return clavier.readString();
	}

	static public int readInt() {
		return clavier.readInt();
	}

	static public double readDouble() {
		return clavier.readDouble();
	}

	static public void skipWhite() {
		clavier.skipWhite();
	}

	static public void skipLine() {
		clavier.skipLine();
	}


}

class Clavier {

// TODO: Mettre des log pour tracer l'exécution.  Sans nécessiter de .jar
// supplémentaire ==> en utilisant la journalisation de Java !

	final static Pattern intPattern = Pattern.compile("[+-]?\\d+");
	final static Pattern doublePattern =
			Pattern.compile("[+-]?\\d+(\\.\\d+)?([eE][+-]?\\d+)?");
	final static Pattern charPattern = Pattern.compile(".");
	
	private Scanner scanner;
	private String lastText = null;

	public Clavier() {
		this(System.in);
	}

	public Clavier(InputStream input) {
		this.scanner = new Scanner(input);
	}

	private String next() {
		if (lastText != null) {
			String resultat = lastText;
			lastText = null;
			return resultat;
		} else {
			return this.scanner.next();
		}
	}

	public char readChar() {
		char resultat;
		if (this.lastText != null) {
// System.out.println("readChar: this.lastText = >" + this.lastText + "<");
			resultat = this.lastText.charAt(0);
			if (this.lastText.length() == 1) {
				this.lastText = null;
			} else {
				this.lastText = this.lastText.substring(1);
			}
		} else {
// System.out.println("readChar: using findInLine");
			String found = this.scanner.findInLine(charPattern);
// System.out.println("readChar: found = >" + found + "<");
			if (found == null) {
				this.scanner.nextLine();
				resultat = '\n';
			} else {
				resultat = found.charAt(0);
			}
		}
// System.out.println("readChar: return >" + resultat + "<");
		return resultat;
	}

	private String readPattern(Pattern p) {
		do {
			String texte = null;
			try {
				texte = this.next();	// XXX .trim() ?
// System.out.println("texte = >" + texte + "<");
				Matcher m = p.matcher(texte);
// System.out.println("Matcher m = " + m);
				if (m.lookingAt()) {
// System.out.println("readPattern("+p+") --> " + texte);
// System.out.println("trop lu : >" + texte.substring(m.end(), texte.length()) + "<");
					// unread(texte.substring(m.end(), texte.length()));
					String remainingText = texte.substring(m.end());
					if (remainingText.length() > 0) {
						this.lastText = remainingText;
					}
					return texte.substring(m.start(), m.end());
				} else {
					System.out.print("Je n'ai pas compris : \"" + texte + "\".  ");
					System.out.print("Merci de recommencer : ");
				}
			} catch (java.util.NoSuchElementException e) {
				throw new RuntimeException("Le flot d'entrée semble fermé !", e);
			}
		} while (true);
	}

	/** Lire un mot (délimité par un blanc).
	* @return le mot lu
	*/
	public String readString() {
		return this.next();
	}

	/** Lire un entier.
	* @return l'entier lu
	*/
	public int readInt() {
		while(true) {
			try {
				// Supprimer le '+' initial (Integer.parseInt ne l'accepte pas)
				String texte = this.readPattern(intPattern);
					// XXX est-ce que le trim() est nécessaire ?
				if (texte.length() > 0 && texte.charAt(0) == '+') {
					texte = texte.substring(1);
				}
				return Integer.parseInt(texte);
			} catch (NumberFormatException e) {
				System.out.println("Vous devez saisir un entier !");
			}
		}
	}

	/** Lire un réel.
	* @return le réel lu
	*/
	public double readDouble() {
		while(true) {
			try {
				String texte = this.readPattern(doublePattern);
				return Double.parseDouble(texte);
			} catch (NumberFormatException e) {
				System.out.println("Vous devez saisir un réel !");
			}
		}
	}

	private void unread(char c) {
		this.lastText = c + (this.lastText == null ? "" : this.lastText);
	}

	private void unread(String c) {
		for (int i = 0; i < c.length(); i++) {
			this.unread(c.charAt(i));
		}
	}

	/** Skip all white characters. */
	public void skipWhite() {
		char c;
		while (Character.isWhitespace(c = this.readChar())) {
// System.out.println("skipped: >" + c + "<");
			// Rien à faire
		}
		this.unread(c);
	}

	/** Supprimer tous les caractères du flot d'entrée jusqu'au prochain retour
	* à la ligne inclu.
	*/
	public void skipLine() {
		String skippedText = this.scanner.nextLine();
// System.out.println("skipped text : >"
//				+ (this.lastText == null ? "" : this.lastText)
//				+ skippedText + "<");
		this.lastText = null;
	}

	public void close() {
		this.scanner.close();
	}


}
// vi: sw=4 ts=4
