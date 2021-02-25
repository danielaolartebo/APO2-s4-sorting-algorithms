package sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
	private static final String SEP="";
	private static double [][] array;
	
	public static void main(String[] args) throws IOException{
		readSorting();
		bubbleSort();
	}
	
	public static void readSorting() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			int n =Integer.parseInt(line);
			array = new double [n][];
			line = br.readLine();
			for(int i=0;i<array.length && line != null;i++) {
				String[] comp = line.split(SEP);
				double[] sequence = new double [comp.length];
				for(int j=0; j<comp.length;j++) {
					sequence[j] = Double.parseDouble(comp[j]);
				}
				array[i]=sequence;
				line=br.readLine();
			}
			br.close();
		}catch (NumberFormatException exception){
			System.out.println("It is not an integer");
		}catch(IOException exception) {
			System.out.println("Cannot be read");
		}
	}
	
	public static void bubbleSort() throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < array.length; i++){
			int totalChanges=0;
			int aux=0;
			int changes = 1;
			for(int j = 1; j < array[i].length; j++) {
				changes=0; 
				for(int q = 0; q < array[i].length - j;q++) {
					if(array[i][q]>array[i][q+1]) {
						double temp=array[i][q];
						array[i][q]=array[i][q+1];
						array[i][q+1]=temp;
						changes++;
					}
				}
				aux++;
				totalChanges+=changes;
			}	
			DecimalFormat df=new DecimalFormat("0.0#");
			double average=(double)totalChanges/aux;
			double totalAverage=Math.floor(average*100)/100;
			bw.write(df.format(totalAverage)+ " - "+ Arrays.toString(array[i]).replace("[", "").replace("]", "").replace(",", " "));
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
