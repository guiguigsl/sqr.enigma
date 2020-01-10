package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends Rotor {
	
	int[] reflection;
	
	public static Reflector reflectorFactory(String str){ //Création d'un reflector avec la meme logique que le rotor
		char[] s = str.trim().replace(" ", "").toCharArray(); 
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	Reflector(int[] r){
		super(r,0);
		reflection = r;
	}
        
    public int convertForward(int p) {//Cryptage de la lettre saisie à travers le reflector en allant vers le reflector
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

    @Override
    public int convertBackward(int unused) {//Pas de backward donc surcharge
        throw new UnsupportedOperationException();
    }

    @Override
    public void advance() {
    }

}
