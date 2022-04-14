// jdh CS224 Spring 2022

import java.util.function.BiFunction;

public class Main {
  public static void main(String argv[]) {
    testTwo();
  }


//  public static void testOne() {
//    String s1 = "mean";
//    String s2 = "name"; // change back to name!!!!!
//    float delta = 2.0f;
//
//    // define a BiFunction here that will return the following:
//    // if c1 == c2, then zero
//    // if c1 and c2 are both vowels, then 1.0 (vowels are a, e, i, o, u)
//    // if c1 and c2 are both consonants, then 1.0 (if both are not vowels)
//    // otherwise, 3.0
//    BiFunction <Character, Character, Float> alpha = (c1, c2) -> {
//    	boolean c1IsVowel = false;
//    	boolean c2IsVowel = false;
//    	switch(c1) {
//    		case 'a', 'e', 'i', 'o', 'u':
//    			// c1 is a vowel
//    			c1IsVowel = true;
//    		default:
//    			// check if c2 is a vowel
//    			switch(c2) {
//	    			case 'a', 'e', 'i', 'o', 'u':
//	    				c2IsVowel = true;
//	    				break;
//    			}
//    			break;	
//    	}
//    	
//    	if(c1 == c2) {
//    		return 0.0f;
//    	} else {
//    		if((c1IsVowel && c2IsVowel) || (!c1IsVowel && !c2IsVowel)) {
//    			return 1.0f;
//    		} else {
//    			return 3.0f;
//    		}
//    	}
//    };
//
//    Aligner aligner = new Aligner(alpha, delta);
//    float cost = aligner.align(s1, s2);
//    System.out.printf("Cost: %.0f\n", cost);
//    // this should produce the following alignment:
//    // n-ame
//    // mean-
//    // with cost = 6.0
//  }


  public static void testTwo() {
    String s1 = "nowisthedimeforallgoodmen";
    String s2 = "mowisthetimeallforgoodmen";
    float delta = 2.0f;

    BiFunction <Character, Character, Float> alpha = (c1, c2)  -> c1 == c2 ? 0.0f : 3.0f;

    Aligner aligner = new Aligner(alpha, delta);
    aligner.align(s1, s2);
    // this should give you the following alignment:
    // mowisthetime---allforgoodmen
    // nowisthedimeforall---goodmen
    // with cost = 18.0
  }

}
