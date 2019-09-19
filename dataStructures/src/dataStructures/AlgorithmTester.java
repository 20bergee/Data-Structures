package dataStructures;
import java.util.Scanner;
import java.util.Random;
/**
   This program tests time complexity of three algorithms.
*/
public class AlgorithmTester
{
	public static final long N = 1000;
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Amount of integers:");
		int x=input.nextInt();
		double[] num=new double[x];
		for(int i=0; i<x; i++) {
		double r=(Math.random()*((100-0)+1))+0;
			num[i]=r;
		}
		long startTime, finishTime, elapsedTime;
		
		startTime = System.currentTimeMillis();
		prefixAverage1(num);
		finishTime = System.currentTimeMillis();
		
		System.out.println("elapsed time for algorithm A"+(finishTime-startTime));

		startTime = System.currentTimeMillis();
		prefixAverage2(num);
		finishTime = System.currentTimeMillis();
		
		System.out.println("elapsed time for algorithm B"+(finishTime-startTime));
		
   }
	  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
	  public static double[] prefixAverage1(double[] x) {
		    int n = x.length;
		    double[] a = new double[n];    // filled with zeros by default
		    for (int j=0; j < n; j++) {
		      double total = 0;            // begin computing x[0] + ... + x[j]
		      for (int i=0; i <= j; i++)
		        total += x[i];
		      a[j] = total / (j+1);        // record the average
		    }
		    return a;
		  }
	  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
	  public static double[] prefixAverage2(double[] x) {
	    int n = x.length;
	    double[] a = new double[n];    // filled with zeros by default
	    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
	    for (int j=0; j < n; j++) {
	      total += x[j];               // update prefix sum to include x[j]
	      a[j] = total / (j+1);        // compute average based on current sum
	    }
	    return a;
	  }
}
