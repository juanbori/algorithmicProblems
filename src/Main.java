import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 4, 4);
        System.out.println(Source.sumPossible(6, numbers));

    }
}

class Source {

    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, HashMap<Integer, Integer> memo) {

        if (n == 0 | n == 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    public static int trib(int n) {
        return trib(n, new HashMap<>());
    }

    public static int trib(int n, HashMap<Integer, Integer> memo) {
        if (n == 0 | n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = trib(n - 1) + trib(n - 2) + trib(n - 3);
        memo.put(n, result);

        return result;
    }

    public static boolean sumPossible(int amount, List<Integer> numbers) {
        return sumPossible(amount, numbers, new HashMap<>());
    }
    public static boolean sumPossible(int amount, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (amount == 0) {
            return true;
        } else if (amount < 0) {
            return false;
        }

        if(memo.containsKey(amount)) {
         return memo.get(amount);
        }

        for (int num : numbers) {
            int subAmount = amount - num;
            if (sumPossible(subAmount, numbers, memo)) {
                memo.put(amount, true);
                return true;
            }
        }
        memo.put(amount, false);
        return false;
    }

}