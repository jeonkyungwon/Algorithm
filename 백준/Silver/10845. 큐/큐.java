import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	Queue<Integer> q = new LinkedList<>();
    	StringBuilder sb = new StringBuilder();
    	int last = -1;
    	for (int n = 0; n < N; n++) {
    		String[] cmd = br.readLine().split(" ");
    		
    		switch (cmd[0]) {
    		case "push":
                int num = Integer.parseInt(cmd[1]);
    			q.offer(num);
                last = num;
    			break;
    		case "pop":
                sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
                break;
            case "size":
                sb.append(q.size()).append('\n');
                break;
            case "empty":
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
                break;
            case "front":
                sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
                break;
            case "back":
                sb.append(q.isEmpty() ? -1 : last).append('\n');
                break;
    		}
    	}
        
    	System.out.println(sb);	
    }
}