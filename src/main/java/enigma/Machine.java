package enigma;

public class Machine {

	private Rotor leftRotor;
	private Rotor middleRotor;
	private Rotor rightRotor;
	private Reflector reflector;

	public void initRotors(Reflector reflector, Rotor left, Rotor middle, Rotor right) { //Cr�ation de la machine avec les 3 rotors et le reflector
		this.reflector = reflector;
		leftRotor = left;
		middleRotor = middle;
		rightRotor = right;
	}

	public void setPositions(String setting) { //Positionner nos caract�res sur les rotors
		char[] charSettings = setting.toCharArray();
		reflector.setPosition(Rotor.toIndex(charSettings[0]));
		leftRotor.setPosition(Rotor.toIndex(charSettings[1]));
		middleRotor.setPosition(Rotor.toIndex(charSettings[2]));
		rightRotor.setPosition(Rotor.toIndex(charSettings[3]));
	}
	
	public void configure(Reflector reflector, Rotor left, Rotor middle, Rotor right, String setting) {//Initialise la position des rotors dans notre machine
		this.initRotors(reflector, left, middle, right);
		this.setPositions(setting);

	}

	public String convert(String msg) {
		msg = msg.toUpperCase();
		char[] msgChars = msg.toCharArray();
		String result = "";
		for (char c : msgChars) {
			result += convertChar(c);
		}
		return result;
	}

	char convertChar(char c) { //conversion d'un caract�re avec la machine
		advanceRotors();
		int charIndex = Rotor.toIndex(c);
		int output;
		output = rightRotor.convertForward(charIndex);
		output = middleRotor.convertForward(output);
		output = leftRotor.convertForward(output);
		output = reflector.convertForward(output);
		output = leftRotor.convertBackward(output);
		output = middleRotor.convertBackward(output);
		output = rightRotor.convertBackward(output);
		return Rotor.toLetter(output);

	}

	void advanceRotors() { //bouger les rotors si on est sur l'index d'un notch
		boolean advanceLeft = false;
		boolean advanceMiddle = false;
		boolean advanceRight = true;
		if (leftRotor.atNotch()) {
		}
		if (middleRotor.atNotch()) {
			advanceMiddle = true;
			advanceLeft = true;
		}
		if (rightRotor.atNotch()) {
			advanceMiddle = true;
			advanceRight = true;
		}
		if (advanceLeft) {
			leftRotor.advance();
		}
		if (advanceRight) {
			rightRotor.advance();
		}
		if (advanceMiddle) {
			middleRotor.advance();
		}
	}
}
