import java.util.*;
import java.util.stream.Collectors;

public class password {
    public static void solve(Scanner scanner) {
        boolean correct = false;

        String P = scanner.nextLine();
        String H = scanner.nextLine();

        // contains counters for each letter found in pwd
        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, Integer> count_res = new HashMap<>();
        HashMap<Character, List<Integer>> pos_hash = new HashMap<>();

        char[] Pchar = P.toCharArray();
        char[] Hchar = H.toCharArray();
        List<Character> Xchar = new LinkedList<>();


        for(Character c : Pchar) {
            count.merge(c, 1, Integer::sum);
        }

        int pos = 0;

        for(Character c : Hchar) {
            Integer inPwd = count.get(c);
            if(inPwd != null){
                List<Integer> x = pos_hash.get(c);
                if(x == null) {
                    x = new LinkedList<>();
                    x.add(pos);
                    pos_hash.put(c, x);
                }
                Integer amount = count_res.get(c);
                if(amount == null) {
                    amount = 1;
                    count_res.put(c, amount);
                    Xchar.add(c);
                }
                else {
                    if(amount < inPwd) {
                        amount += 1;
                        count_res.put(c, amount);
                        Xchar.add(c);
                    }
                    else {
                        amount -= 1;
                        Xchar.subList(0, x.get(0) >= Xchar.size() ? (Xchar.size() - 1) : x.get(0)).clear();
                        count_res.put(c, amount);
                    }
                }
            }
            else {
                Xchar.clear();
                pos_hash.clear();
                count_res.clear();
            }
            if(Xchar.toArray().length == P.length()) break;
            pos++;
        }

        int count1 = 0;

        for(Character c : Pchar) {
            Integer cc = count_res.get(c);
            if(cc == null) break;
            if(count.get(c).equals(cc)) {
                count1 += 1;
            }
            else break;
        }

        System.out.println(count1 == P.length() ? "1" : "0");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        scanner.nextLine(); // Move scanner to the next line

        for(int i=0; i<T; i++) {
            solve(scanner);
        }
    }
}
