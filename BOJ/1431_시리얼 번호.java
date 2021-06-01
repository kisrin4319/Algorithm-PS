import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<String> list = new ArrayList<String>();
		for(int loop = 0; loop < N; loop++) {	
			list.add(sc.next());
		}
		
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length()) {
					return o1.length()-o2.length();
				}
				
				int o1Sum = 0;
				int o2Sum = 0;
				for(int idx = 0; idx<o1.length();idx++) {
					if(o1.charAt(idx) >= '0' && o1.charAt(idx) <='9') {
						o1Sum+= Integer.parseInt(o1.charAt(idx)+"");
					}
				}
				for(int idx = 0; idx<o2.length();idx++) {
					if(o2.charAt(idx) >= '0' && o2.charAt(idx) <='9') {
						o2Sum+= Integer.parseInt(o2.charAt(idx)+"");
					}
				}
					
				if(o1Sum == o2Sum) {
					return o1.compareTo(o2);
				}
				else{
					return o1Sum - o2Sum;
				}
			}
		});
		
		for(int idx = 0; idx<list.size();idx++)
		{
			System.out.println(list.get(idx));
		}
		
	}
}  