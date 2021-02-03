import java.util.*;

public class unbalancer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer N = scanner.nextInt();
        Integer K = scanner.nextInt();

        scanner.nextLine(); // Move scanner to the next line

        Integer V[] = new Integer[N];

        for(Integer i=0; i<N; i++) {
            V[i] = scanner.nextInt();
        }

    
        Arrays.sort(V, Collections.reverseOrder());

        int solution = V[0];

        for (int i = 1; i <= K && i < N; i++) {

            solution = solution + V[i];

        }

        System.out.println(solution);
    }
}
