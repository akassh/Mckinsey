import java.net.*;
import java.io.*;
import java.util.*;
public class HashTag {
  	public static void main(String[] args)
		{
			Set<String> webs = new TreeSet<String>();
			if(args.length < 1)
			{
				System.out.println("Required Parameter Missing - Hashtag\n Required Parameter e.g. #test ");
				System.exit(0);
			}
			String top = args[0];
			if(top.charAt(0)=='#')
				top = top.replaceFirst("#", "");
			else 
			{
				System.out.println("Required Parameter Hashtag - Format Missing\nRequired Format e.g. #test ");
				System.exit(0);
			}
			String urlName = "http://search.twitter.com/search.atom?rpp=150&resulttype=recent&q=%23"+top;
			URL url;
			try 
			{
				url = new URL(urlName);
				BufferedReader in = new BufferedReader(new	InputStreamReader(url.openStream()));
				String line;
				String a="";
				while ((line = in.readLine()) != null)
				   a += line;
				in.close();
				String [] link = a.split("<link type=\"text/html\" href=\"");
				for(int i=1;i<link.length;i++)
				{
					if(!link[i].split("\" rel=\"")[0].contains("/search?")&&link[i].split("\" rel=\"")[0].contains("twitter"))
						webs.add(link[i].split("\" rel=\"")[0]);
				}
				Iterator<String> h = webs.iterator();
				int cnt = 0;
				while(h.hasNext())
				{
					cnt++;
					System.out.println(h.next());
				}
				if(cnt < 100)
					System.out.println("Total Tweets on twitter with hashtag: "+args[0]+" are "+cnt);
			} 
			catch (MalformedURLException e) 
			{
				System.out.println("Malformed URL Exception !!!");
				e.printStackTrace();
			}
			catch (IOException e)
      {
				System.out.println("URL Stream read Exception or connection error !!!");
				e.printStackTrace();
			}
		}
	}
