package eigenCode;

import java.awt.Color;
import java.util.*;
import java.math.*;


public class Runner {
	
int[][] A;
double previousDominantEigenValue;
double dominantEigenValue = 1;
double[] vector;
double[] newVector;
int n;
boolean changed = true;
Scanner sc;
	public static void main(String[] args) {
		new Runner().run();
	}
	
	public void run() {
		double x = getDominantEigenvalue();
		System.out.println("The dominant Eigenvalue is " + x);
	}	

	public double getDominantEigenvalue() {
		createVectorAndMatrix();
		while(Math.abs(previousDominantEigenValue - dominantEigenValue) > 0.0001) {
			previousDominantEigenValue = dominantEigenValue;
			dominantEigenValue = 0;
			//multiplies the vector by the matrix to get new vector
			for (int j = 0; j < n; j++) {
				newVector[j] = 0;
				for (int k = 0; k < n; k++) {
					newVector[j] = newVector[j] + A[j][k]*vector[k];
				}
				if (Math.abs(newVector[j]) > Math.abs(dominantEigenValue)) {
					dominantEigenValue = newVector[j];
				}
			}
			for (int j = 0; j < n; j++) {
				vector[j] = newVector[j]/dominantEigenValue;
				//System.out.println(""+newVector[j]);
			}
			//System.out.println();
			//System.out.println("d"+dominantEigenValue);
			//System.out.println("p"+previousDominantEigenValue);
			//System.out.println();
		}
		return dominantEigenValue;
	}

	public void createVectorAndMatrix() {
		sc = new Scanner(System.in);
		System.out.println("Please enter n for the nxn matrix");
		n = sc.nextInt();
		A = new int[n][n];	
		vector = new double[n];
		newVector = new double[n];
		vector[0] = 1; 	
		for (int i = 1; i<n; i++) {
			vector[i] = 0; 
		}	
		System.out.println("Enter matrix numbers");
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<n; j++) {
				A[i][j] = sc.nextInt();
			}
		}
	}
}

		