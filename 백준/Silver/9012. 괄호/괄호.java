import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] stack;
    static int size;

    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            String S = br.readLine();
            stack = new char[S.length()];
            size = 0; 

            boolean isValid = true;

            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '(') {
                    stack[size++] = '(';
                } else {
                    if (size == 0) {
                        isValid = false;
                        break;
                    }
                    size--;
                }
            }

            if (isValid && size == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}