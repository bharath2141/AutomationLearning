

public class CoreJavaBrushup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myNum=5;
		String sample="Hello world..!";
		char ch='c';
		double fl=2.4;
		float fl1=2.6f;
		System.out.println(myNum+" is stored in myNum variable");
		System.out.println(fl1+" is stored in fl1 variable");
		
		int arr[]=new int[5];
		arr[0]=1;
		arr[1]=2;
				arr[2]=4;
				arr[3]=66;
				arr[4]=34;
				
				//int[] arr={1,2,4,66,34};
			System.out.println(arr[3]);
			
			for(int i=0;i<arr.length;i++)
			{
				System.out.println(arr[i]);
				
			}
			
			String[] name={"bharath","nandan","reddy"};
			for(int i=0;i<name.length;i++)
			{
				System.out.println(name[i]);
			}
			//enhanced for loop
			for(String s:name)
			{
				System.out.println(s);
			}
	}

}
