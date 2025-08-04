import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String S = br.readLine();
    	LinkedList<Character> list = new LinkedList<>();
    	
    	for (char ch : S.toCharArray()) {
    		list.add(ch);
    	}
    	
    	ListIterator<Character> cursor = list.listIterator(list.size());
    	
        int M = Integer.parseInt(br.readLine());
        
        for (int m = 0; m < M; m++) {
        	String cmd = br.readLine();
        	char order = cmd.charAt(0);
        	
        	switch (order) {
        	case 'L':
        		if (cursor.hasPrevious()) cursor.previous();
        		break;
        	case 'D':
        		if (cursor.hasNext()) cursor.next();
        		break;
        	case 'B':
        		if (cursor.hasPrevious()) {
        			cursor.previous();
        			cursor.remove();
        		}
        		break;
        	case 'P':
        		char ch = cmd.charAt(2);
        		cursor.add(ch);
        		break;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
        	sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}