import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// string is an object //string literal
		// here s2 will point to same value "bharath reddy"
		String s = "bharath nandan reddy";
		String s1 = "bharath reddy";

		// new
		// 2 memory spaces will be created
		String s2 = "bharath";
		String s3 = "bharath";

		String[] splittedString = s.split("nandan");

		System.out.println(splittedString[0]);
		System.out.println(splittedString[1].trim());

		// to print all characters in a string
		for (int i = 0; i < s.length(); i++) {

			System.out.println(s.charAt(i));
		}

		// to print characters in reverse order in string
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}

	}

}
