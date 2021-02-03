import java.util.*;

public class evolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        scanner.nextLine(); // Move scanner to the next line

        char[][] G = new char[N][M];
        char[][] BUF = new char[N][M];


        for(int i=0; i<N; i++) {
            String line  =  scanner.nextLine();
            for(int j=0; j<M; j++) {
                G[i][j] = line.charAt(j);
                BUF[i][j] = line.charAt(j);
            }
        }

        int count = 0;

        for(int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for(int h = -1; h < 2; h++) {
                        int rx = i + h;
                        for(int s = -1; s < 2; s++) {
                            int ry = j + s;
                            if(rx >= 0 && rx < N && ry >= 0 && ry < M) {
                                if(!(h == 0 && s == 0)) {
                                    count += (G[rx][ry] == '.' ? 0 : 1);
                                }
                            }
                        }
                    }
                    if (G[i][j] == '+') {
                        BUF[i][j] = count != 4 ? (count > 4 ? '*' : '.') : '+';
                    } else {
                        BUF[i][j] = count != 4 ? (count > 4 ? '+' : '.') : G[i][j];
                    }
                    count = 0;
                }
            }
            for(int i=0; i<N; i++) {
                System.arraycopy(BUF[i], 0, G[i], 0, M);
            }

        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(G[i][j]);
            }
            System.out.println();
        }
    }

}


