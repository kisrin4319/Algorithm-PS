import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashSet<String> log = new HashSet<String>();
		ArrayList<String> list;
		for(int tc = 0 ; tc<n;tc++)
		{
			String[] line = br.readLine().split(" ");
			
			if(line[1].equals("enter")) {
				log.add(line[0]);
			}
			else if(line[1].equals("leave")) {
				log.remove(line[0]);
			}
		}
		
		
		list = new ArrayList<String>(log);
		
		Collections.sort(list);
		Collections.sort(list,Collections.reverseOrder());
		
		for(int idx = 0; idx<list.size();idx++)
		{
			System.out.println(list.get(idx));
		}
	}
}