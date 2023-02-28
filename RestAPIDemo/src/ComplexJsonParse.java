import org.testng.Assert;

import Files.PayLoad;
import Files.ReusableMethods;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js=ReusableMethods.rawToJson(PayLoad.coursePrice());
		
		//1. Print No of courses returned by API
		int count=js.getInt("courses.size()");
		System.out.println(count);
	
		//2.Print Purchase Amount
	int totalAmountDisplayed=	js.getInt("dashboard.purchaseAmount");
System.out.println(totalAmountDisplayed);

//3. Print Title of the first course
String firstCourseTitle=js.get("courses[0].title");
System.out.println(firstCourseTitle);

//4. Print All course titles and their respective Prices

for(int i=0;i<count;i++)
{
	
	String courseName=js.get("courses["+i+"].title");
	System.out.println(courseName);
	int coursePrice=js.getInt("courses["+i+"].price");
	System.out.println(coursePrice);
	
}

//5. Print no of copies sold by RPA Course
for(int i=0;i<count;i++)
{
	String courseName=js.get("courses["+i+"].title");
	if(courseName.equalsIgnoreCase("RPA"))
	{
	int RPACopies=js.getInt("courses["+i+"].copies");
	System.out.println("No of copies sold by "+courseName+" "+RPACopies);
	break;
	}
	
}
	
	//6. Verify if Sum of all Course prices matches with Purchase Amount
	int totalAmount=0;
	for(int i=0;i<count;i++)
	{
		
		
		int coursePrice=js.getInt("courses["+i+"].price");
		int copies=js.getInt("courses["+i+"].copies");
		int eachCourseTotalPrice=coursePrice*copies;
		//System.out.println(coursePrice);
		totalAmount=totalAmount+eachCourseTotalPrice;
		
		
	}
	System.out.println("Sum of all Course prices is "+totalAmount);
	
	Assert.assertEquals(totalAmountDisplayed, totalAmount);
}

}
