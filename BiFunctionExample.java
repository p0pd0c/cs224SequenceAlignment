// jdh CS224 Spring 2022

import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BiFunctionExample {
  
  public static void main(String argv[]) {
    BiFunction <Character, Character, Float> alpha = (c1, c2) -> {
    	boolean c1IsVowel = false;
    	boolean c2IsVowel = false;
    	switch(c1) {
    		case 'a', 'e', 'i', 'o', 'u':
    			// c1 is a vowel
    			c1IsVowel = true;
    		default:
    			// check if c2 is a vowel
    			switch(c2) {
	    			case 'a', 'e', 'i', 'o', 'u':
	    				c2IsVowel = true;
	    				break;
    			}
    			break;	
    	}
    	
    	if(c1 == c2) {
    		return 0.0f;
    	} else {
    		if((c1IsVowel && c2IsVowel) || (!c1IsVowel && !c2IsVowel)) {
    			return 1.0f;
    		} else {
    			return 3.0f;
    		}
    	}
    };

    float res = test(alpha, "heart", "pearl");
    System.out.println("result is " + res);
  }

  public static float test(BiFunction<Character, Character, Float> comparator, String s1, String s2) {
	int i1, i2, len1, len2;
    float sum = 0.0f;
    len1 = s1.length();
    len2 = s2.length();
    i1 = 0;
	
    i2 = 0;
    while (i1 < len1 && i2 < len2) {
      System.out.println("compare " + s1.charAt(i1) + " to " + s2.charAt(i2));
      sum = sum + comparator.apply(s1.charAt(i1), s2.charAt(i2));
      i1 = i1 + 1;
      i2 = i2 + 1;
    }

    return sum;
  }
}
