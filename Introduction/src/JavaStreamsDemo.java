import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaStreamsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> as=new ArrayList<String>();
		as.add("abhijeet");
		as.add("don");
		as.add("alekhya");
		as.add("adam");
		as.add("ram");
		as.add("Azli");
		as.add("Alexa");
		
		ArrayList<String> as2=new ArrayList<String>();
		as2.add("syam");
		as2.add("sam");
		int count=0;
		for(int i=0;i<as.size();i++)
		{
			if(as.get(i).startsWith("a"))
			{
				count++;
			//	System.out.println(as.get(i));
			}
		}
		
		Stream<String> mergedStream=Stream.concat(as.stream(), as2.stream());
		boolean flag=mergedStream.anyMatch(s->s.equalsIgnoreCase("sam"));
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(flag);
		sa.assertAll();
		
		//Converting Stream back to list
		//List<String>cl= mergedStream.collect(Collectors.toList());
		
	//	System.out.println(count);
		
		//using javaStreams
		long ct=as.stream().filter(s->s.startsWith("a")).count();
	//	System.out.println(ct);
		
		//to create stream 
		Stream<String> strm=Stream.of("abhijeet","don","alekhya","adam","ram","aliyas","aliza");
	//	strm.filter(s->
	//	s.length()>4).forEach(k->System.out.println(k));
		
	//	as.stream().filter(s->s.contains("al")).limit(2).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		as.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Printing the unique numbers from the given numbers
		
		
		  int b[]= {2,4,7,2,5,4,7,8}; List<Integer>
		  libs=Arrays.stream(b).boxed().collect(Collectors.toList());
		  libs.stream().distinct().forEach(s->System.out.println(s));
		 
		
		
	
		
		practise();
		
		
		
	}
	
	public static void practise()
	{
		int[] b= {32,4,9,16,197,2,1,6,56};
		int max=b[0];
		for(int i=0;i<=b.length-1;i++)
		{
		if(b[i]>max)
		{
			max=b[i];
		}	
		}
		System.out.println(max);
	}

}
