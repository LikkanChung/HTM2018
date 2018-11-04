// Class to run a python file from Java. 

package python;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonToJava {
	
	private static Process p;
	private static BufferedReader br;
	private static StringBuilder s;
	
	public static String executePythonFile(String pythonFilePath) {
		try {
			s = new StringBuilder();
			p = Runtime.getRuntime().exec("python " + pythonFilePath);
			
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			
			while((line = br.readLine()) != null) {
				s.append(line);
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s.toString();
	}
}
