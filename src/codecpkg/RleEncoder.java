package codecpkg;

import java.util.ArrayList;

public class RleEncoder {
	private ArrayList<Byte> inputBytes;
	private ArrayList<Byte> outputBytes;
	private byte currentSymbol;
	private int counter;
	private int aux;
	
	public RleEncoder() {
		inputBytes = new ArrayList<Byte>();
		outputBytes = new ArrayList<Byte>();
		currentSymbol = 0;
		counter = 0;
	}
	
	public void encode(ArrayList<Byte> inputBytes) {
		this.inputBytes = inputBytes;
				
		counter = 0;
		
		this.inputBytes.forEach(item -> {
			if(item == currentSymbol) {
				counter++;
			} else {
				while(counter >= 255) {
					aux = 255;
					aux &= 0xff;
					outputBytes.add((byte)aux);
					counter -= 255;
				}												
				aux = counter;
				aux &= 0xff;
				outputBytes.add((byte)aux);
				currentSymbol = (byte)item;
				counter = 1;
			}
		});
		
		while(counter >= 255) {
			aux = 255;
			aux &= 0xff;
			outputBytes.add((byte)aux);
			counter -= 255;
		}												
		aux = counter;
		aux &= 0xff;
		outputBytes.add((byte)aux);
	}
	
	public void printArray(ArrayList<Byte> anArray) {
		anArray.forEach(item -> {
			aux = item;
			aux &= 0xff;
			//System.out.println(Integer.toBinaryString(aux));
			System.out.print(Integer.toString(aux));			
		});
	}
	
	public ArrayList<Byte> getInputBytes() {
		return inputBytes;
	}
	
	public ArrayList<Byte> getOutputBytes() {
		return outputBytes;
	}
}
