package utils;
import java.io.*;

public class Utils{
	static public BufferedReader teclado = 
		new BufferedReader(new InputStreamReader(System.in));

	static public String readLine(String x)throws IOException{
		print(x); return teclado.readLine();
	}
	static public int readInt(String x)throws IOException{
		return Integer.parseInt(readLine(x));
	}
	static public int readInt()throws IOException{
		return readInt("");
	}
	static public double readDouble(String x)throws IOException{
		return Double.parseDouble(readLine(x));
	}
	static public double readDouble()throws IOException{
		return readDouble("");
	}
	static public void print(String x){
		System.out.print(x);
	}
	static public void print(int x){
		System.out.print(x);
	}
	static public void print(double x){
		System.out.print(x);
	}
	static public void println(String x){
		System.out.println(x);
	}
	static public void println(int x){
		System.out.println(x);
	}
	static public void println(double x){
		System.out.println(x);
	}
	static public void clearScreen(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	static public int random (int x, int y){
		return x + (int)(Math.random() * (y-x+1));
	}
}
