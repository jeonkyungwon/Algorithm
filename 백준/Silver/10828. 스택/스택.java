import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] stack = new int[10001];
	static int size;
    public static void main(String[] args) throws IOException {        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String S = st.nextToken();
    		
    		switch (S) {
    		case "push":
    			push(Integer.parseInt(st.nextToken()));
    			break;
    		case "pop":
    			sb.append(pop()).append("\n");
    			break;
    		case "size":
    			sb.append(size()).append("\n");
    			break;
    		case "empty":
    			sb.append(empty()).append("\n");
    			break;
    		case "top":
    			sb.append(top()).append("\n");
    			break;
    		}    		
    	}
		System.out.println(sb);
    }
    
    static void push(int num) {
    	stack[size++] = num;
    }
    
    static int pop() {
    	if (size == 0) {
    		return -1;
    	}
    	int P = stack[--size];
    	return P;
    }
    
    static int size() {
    	return size;
    }
    
    static int empty() {
    	if (size == 0) {
    		return 1;
    	}
    	return 0;
    }
    
    static int top() {
    	if (size == 0) {
    		return -1;
    	}
    	return stack[size - 1];
    }
}