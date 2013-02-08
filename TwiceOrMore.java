import java.util.ArrayList;
import java.util.Hashtable;

public class TwiceOrMore {

  static int[] a = {6,6,6,6,6,7,7,7,7,2,2,2,5,5,3,3,9,1};
	
	public static ArrayList<Integer> methodA (int[] a)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0,j=1;i<a.length;)
		{
			if(j==a.length)
				break;
			if(a[i]==a[j])
			{
				if(!al.contains(a[j]))
					al.add(a[j]);
				j++;
			}
			else {
				i=j;
				j++;
			}
		}
		return al;
	}
	
	public static ArrayList<Integer> methodB (int[] a)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		Hashtable<Integer,Integer> l = new Hashtable<Integer,Integer>();
		for(int i=0;i<a.length;i++)
		{
			if(l.isEmpty()||!l.containsValue(a[i]))
			{
				l.put(a[i], a[i]);
			}
			else if(l.containsValue(a[i])) 
			{
				if(!al.contains(a[i]))
					al.add(a[i]);
			}
		}
		return al;
	}
	
	
	
	public static void main(String[] args) 
	{
		ArrayList<Integer> l = methodA(a);
		System.out.print("Method A:\t");
		for(int i=0;i<l.size();i++)
			System.out.print(l.get(i)+"\t");
		
		System.out.println();
		
		l = methodB(a);
		System.out.print("Method B:\t");
		for(int i=0;i<l.size();i++)
			System.out.print(l.get(i)+"\t");
	}

}
