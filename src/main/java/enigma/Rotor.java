package enigma;

public class Rotor {

    private int position;
    private int[] cipher = new int[26]; //carat�re que l'on crypte - chemin avant le reflecteur
    private int[] bcipher = new int[26];//caract�re qui a fait le chemin inverse cad apr�s le reflecteur (caract�re crypter)
    private int notch1 = -1; 
    private int notch2 = -1; 

    public int getPosition() { //getter
        return position;
    }

    public void setPosition(int posn) { //setter
        position = posn;
    }
    
	public static Rotor rotorFactory(String str, String notches){ //fabrique un rotor � partir des lettres de l'alphabet dans un ordre donn� dans un tableau, avec en 2eme param�tre le notch
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		s = notches.trim().replace(" and ", "").toCharArray();
		if (s.length == 2){
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}
	
	Rotor(int[] c, int notch1, int notch2) { //Constructeur d'un objet Rotor
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}
	
	Rotor(int[] c, int notch1) { //Constructeur d'un objet Rotor
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}

    public int convertForward(int p) { //Cryptage de la lettre saisie � travers le rotor en allant vers le reflector
        return ((cipher[((p+position)%26+26)%26]-position)%26+26)%26;
    }

    public int convertBackward(int e) {//Cryptage de la lettre saisie � travers le rotor en allant vers l'exterieur
        return ((bcipher[((e+position)%26+26)%26]-position)%26+26)%26;
    }
    
    public void advance() { //Augmenter la valeur de notre position de 1
        position = (position+1) % 26;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {
        return c - 'A';
    }
    
	private void createBCipher() {
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}
