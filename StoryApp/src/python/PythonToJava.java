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
			p = Runtime.getRuntime().exec(pythonFilePath);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			while(br.readLine() != null) {
				s.append(br.readLine());
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s.toString();
	}
}
