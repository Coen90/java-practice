package coding_test.test.real;

public class Swit2 {

    public static void main(String[] args) {
        int[] numbers1 = {10, 40, 30, 20};
        int k1 = 20;
        System.out.println(solution(numbers1, k1)); // 1

        int[] numbers2 = {3, 7, 2, 8, 6, 4, 5, 1};
        int k2 = 3;
        System.out.println(solution(numbers2, k2)); // 2

        int[] numbers3 = {1, 100, 2, 8, 6, 4, 5, 1};
        int k3 = 3;
        System.out.println(solution(numbers3, k3)); // 2
    }

    private static int minSwaps;

    public static int solution(int[] numbers, int k) {
        minSwaps = Integer.MAX_VALUE;
        boolean[] visited = new boolean[numbers.length];
        dfs(numbers, visited, k, 0);
        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }

    public static void dfs(int[] numbers, boolean[] visited, int k, int swaps) {
        if (swaps >= minSwaps) {
            return;
        }
        if (isSorted(numbers, k)) {
            minSwaps = Math.min(minSwaps, swaps);
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                for (int j = i + 1; j < numbers.length; j++) {
                    if (!visited[j] && Math.abs(numbers[i] - numbers[j]) <= k) {
                        visited[j] = true;
                        swap(numbers, i, j);
                        dfs(numbers, visited, k, swaps + 1);
                        swap(numbers, i, j);
                        visited[j] = false;
                    }
                }
                visited[i] = false;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSorted(int[] numbers, int k) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (Math.abs(numbers[i] - numbers[i + 1]) > k) {
                return false;
            }
        }
        return true;
    }
}
