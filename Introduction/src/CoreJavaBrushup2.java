import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushup2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int[] arr= {2,4,5,7,8,86};
	for(int i=0;i<arr.length;i++)
	{
		if(arr[i]%2==0)
		{
			System.out.println(arr[i]);
			
		}
		else
		{
			System.out.println(arr[i]+" not multiples of 2");
	
		}
	}
	
	//Array List
	
	ArrayList<String> al=new ArrayList<String>();
	al.add("bharath");
	al.add("nandan");
	al.add("reddy");
	System.out.println(al);
	al.remove(0);
	System.out.println(al);
	for(int i=0;i<al.size();i++)
	{
		System.out.println(al.get(i));
		
	}
	System.out.println(al.contains("reddy"));
	
	//to convert from array to list
	
	List<int[]> li=Arrays.asList(arr);
	
	}
	
	
}
