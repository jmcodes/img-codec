package codecpkg;

import java.util.ArrayList;
import java.util.Random;

public class RleEncoderTest {
	public static void main(String[] args) {
		Random randomGenerator = new Random();
		ArrayList<Byte> myArray = new ArrayList<Byte>(); 
		RleEncoder myEncoder = new RleEncoder();
		int i;
		
		for(i = 0; i < 1020; i++) {
			myArray.add((byte)randomGenerator.nextInt(2));
			//myArray.add((byte)randomGenerator.nextInt(1));
			System.out.print(myArray.get(i));
		}
		
		System.out.println();
		
		myEncoder.encode(myArray);
		myEncoder.printArray(myEncoder.getOutputBytes());
	}
}