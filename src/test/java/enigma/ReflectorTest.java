package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {
	
	Rotor rotor2 = Rotor.rotorFactory("B A C D E F G H I J K L M N O P Q R S T U V W X Y Z", "Q");

	@Test
	public void testConvertForward_whenA_then_B(){
		rotor2.setPosition(0);
		int expected =1;		
		assertEquals(expected,rotor2.convertBackward(0));
					
	}
}
