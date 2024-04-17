package MainPackage;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class BookLoader {
	public static void DownloadBook(String Url, String filepath, String filename) 
	{
		try 
		{
			File file = new File(filepath + "\\" + filename + ".txt");
			FileWriter writer = new FileWriter(file);
		
			URL url = new URL(Url);
			BufferedReader reader = new BufferedReader(new 
					InputStreamReader(url.openStream()));
			
			while(reader.ready()) 
			{
				String buffer = reader.readLine() + "\n";
				writer.write(buffer);
			}
			writer.flush();
			writer.close();
			reader.close();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		
	} 
}
