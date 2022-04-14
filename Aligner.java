import java.util.ArrayList;
import java.util.function.BiFunction;

public class Aligner {
	float[][] A;
	BiFunction<Character, Character, Float> comparator;
	float delta;
	String s1;
	String s2;
	ArrayList<String> steps;
	
	public Aligner(BiFunction<Character, Character, Float> comparator, float delta) {
		this.delta = delta;
		this.comparator = comparator;
		steps = new ArrayList<String>();
	}
	
	public float align(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		this.s1 = s1;
		this.s2 = s2;
		A = new float[m + 1][n + 1];
		
		for(int row = 0; row <= m; row++) {
			A[row][0] = delta * row;
		}
		for(int col = 0; col <= n; col++) {
			A[0][col] = delta * col;
		}
		
		
		// Recursively compute opt of a[i][j]
		for(int j = 1; j <= n; j++) {
			for(int i = 1; i <= m; i++) {
				A[i][j] = opt(i, j);
			}
		}
		
		// DEBUG PRINTING
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				System.out.printf("%.0f  ", A[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n\n\n");
		
		
		return A[m][n];
	}
	
	private float opt(int i, int j) {
		if(i == 0 || j == 0) {
			return A[i][j];
		}
		
		if((int) A[i][j] != 0) {
			return A[i][j];
		}
		// Xi is the ith char of s1, Yj is the jth char of s2
		float match_score = comparator.apply(s1.charAt(i - 1), s2.charAt(j - 1)) + opt(i - 1, j - 1);
		float gap_y_score = delta + opt(i - 1, j);
		float gap_x_score = delta + opt(i, j - 1);
		
		// Find the min of the 3 options in the recurrence relations
		if(match_score <= gap_y_score && match_score <= gap_x_score) {
			//steps.add("diagonal");
			return match_score;
		}
		
		if(gap_y_score <= match_score && gap_y_score <= gap_x_score) {
			//steps.add("left");
			return gap_y_score;
		}
		
		if(gap_x_score <= match_score && gap_x_score <= gap_y_score) {
			//steps.add("right");
			return gap_x_score;
		}
		
		// Should never get here, means we did not find the minimum of the match, gap_y, and gap_x scores
		return -500.0f;
	}
	
	private String traceback(int i, int j) {
//		for each step
//			if step is up:
//				match 
//			if step is left:
//				-, letter from second
//			if step is right:
//				letter from first, -
		return "";
	}
}
