// Class to run a python file from Java. 

package python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import userinterface.Window;
public class PythonToJava {
	
	private static Process p;
	private static BufferedReader br;
	private static StringBuilder s;
	
	public static String executePythonFile(String pythonFilePath, Window view) {
		try {
			s = new StringBuilder();
			p = Runtime.getRuntime().exec("python " + pythonFilePath);

			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while(view.getTimeRemaining() != 0)
			{
				
				if((line=br.readLine()) != null)
				s.append(line);
				System.out.println(line);
			}
		
			
				
		
			
			/*while((line = br.readLine()) != null) {
				s.append(line);
				System.out.println(line);
			}*/
			Runtime.getRuntime().exec("killall python");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("test");

		return s.toString();
		
	}
}
