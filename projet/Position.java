/** DÃ©finir une position.  */
public class Position {
	public int x;
	public int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		// System.out.println("...appel Ã  Position(" + x + "," + y + ")" + " --> " + this);
	}

	@Override public String toString() {
		return super.toString() + "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != this.getClass()) return false;
		Position pos = (Position) obj;
		return this.x == pos.x && this.y == pos.y;
	}

	@Override
	public int hashCode() {
		return this.x * 31 + this.y;
	}
}
