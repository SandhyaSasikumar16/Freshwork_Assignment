import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Freshworks 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		Map<String,Integer> obj=new HashMap<String,Integer>();
		int ch=0;
		do{
		System.out.println("Operations to perform in a data store of Student and Marks: \n1.Create\n2.Read\n3.Delete\n");
		int n=s.nextInt();
		String key;
		int value;
		switch(n) {
		case 1:
			System.out.println("Enter Student Roll Number: ");
			key=s.next();
			System.out.println("Enter the corresponding Student marks: ");
			value=s.nextInt();
			create(key,value,obj);
			break;
		case 2: 
			System.out.println(Arrays.asList(obj));
			break;
		case 3: 
			key=s.next();
			delete(key,obj);
			break;
		}
		System.out.println("Obj :"+obj);
		System.out.println("To continue enter 1");
		ch = s.nextInt();
		}while(ch==1);
		String outputFilePath = "D:/freshworks.txt";
		 File file = new File(outputFilePath);
	        
	        BufferedWriter bf = null;;
	        
	        try
	        {
	            bf = new BufferedWriter( new FileWriter(file) );
	            for(Map.Entry<String, Integer> entry : obj.entrySet())
	            {
	                bf.write( entry.getKey() + ":" + entry.getValue() );
	                
	                bf.newLine();
	            }
	            
	            bf.flush();
	 
	        }catch(IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                bf.close();
	            }catch(Exception e){}
	        }
		System.out.println("The operation are now updated in freshworks.txt file");
		
	}
	public static void create(String key,int value, Map<String, Integer> obj) 
	{
		if(obj.containsKey(key)==true) 
		{
			System.out.println("This roll number already exists");
		}
		else
		{
			{
				if(obj.size()<(1024*1020*1024) && value<=(16*1024*1024))
				{
					if(key.length()<=32)
					{	
						obj.put(key,value);	
					}
				}
				else
				{ 
					System.out.println("Memory limit exceeded");
				}
			}
		}
	}
	public static void delete(String key,Map<String, Integer> obj) 
	{
		if(obj.containsKey(key)==true)
		{
			obj.remove(key);
			System.out.println("Roll number is successfully deleted");
		}
		else 
		{
			System.out.println("The roll number does not exist");
		}
	}
}
