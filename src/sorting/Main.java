package sorting;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
	
		for(int i=0; i<=n;i++) {
			String[] array = br.readLine().split(" ");
			double[] ages = new double[array.length];
			
			for(int j=0;j<=array.length;j++) {
				ages[j]=Double.parseDouble(array[j]);
			}
			bubbleSort(ages);
		}  
		
	}
	
	public static void calculateAverage(int changes) throws IOException{
		int sum=0; 
		sum+=changes;
		int average=changes/sum;
		System.out.print(average);
	}
	
	public static void bubbleSort(double[] array) throws IOException{
		int changes = 1;
		for(int i=1; i<array.length && changes>0; i++){
			changes=0; 
			for(int j=0; j< array.length-i; j++) {
				if(array[j]>array[j+1]) {
				double temp = array[j];
				array[j]=array[j+1];
				array[j+1] = temp;
				changes++;
				}
			}	
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(changes+" ");
		calculateAverage(changes);bw.write(Arrays.toString(array));
	}
}
