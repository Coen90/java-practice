package coding_test.test.real;

public class Solution {
    public int solution(int[] numbers, int k) {
        int count = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                int j = i + 1;
                while (j < numbers.length && numbers[j] - numbers[i] > k) {
                    j++;
                }
                if (j < numbers.length && numbers[j] - numbers[i] <= k) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    count++;
                    flag = true;
                }
            }
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] - numbers[i] > k) {
                return -1;
            }
        }
        return count;
    }
}