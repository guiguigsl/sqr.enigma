package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {
	
	
	
	Rotor rotor = Rotor.rotorFactory("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", "Q");
	Rotor rotor2 = Rotor.rotorFactory("B A C D E F G H I J K L M N O P Q R S T U V W X Y Z", "Q");
	
	@Test
	public void testAdvance() {
		int position = 1;
		int expected =position +1;
		rotor.setPosition(1);
		rotor.advance();
		assertEquals(expected,rotor.getPosition());
		
	}
	@Test
	public void testConvertBackward_whenA_then_B(){
		rotor2.setPosition(0);
		int expected =1;		
		assertEquals(expected,rotor2.convertBackward(0));
					
	}
	
	
		
	
	

}
