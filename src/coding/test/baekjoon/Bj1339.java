package coding.test.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bj1339 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String tmp = "";
        if(a.length() < b.length()) {
            tmp = b;
            b = a;
            a = tmp;
        }

        String[] arrA = a.split(""); // 7
        String[] arrB = b.split(""); // 5
        int diff = arrA.length - arrB.length; // 2

        int result = 0;
        int maxNum = 9;

        Map<String, Integer> alpha = new HashMap<>();
        for(int i = 0; i < arrA.length; i++) {
            // A 시작
            if(alpha.get(arrA[i]) == null) {
                alpha.put(arrA[i], maxNum);
                maxNum--;
            }
            result += alpha.get(arrA[i]) * (int) Math.pow(10, arrA.length - i - 1);

            if(i >= diff) { // A와 B의 차이, B배열에도 숫자 부여
                // B 시작
                if(alpha.get(arrB[i - diff]) == null) {
                    alpha.put(arrB[i - diff], maxNum);
                    maxNum--;
                }
                result += alpha.get(arrB[i - diff]) *
                        (int) Math.pow(10, arrB.length - i + diff - 1);
            }
        }

        System.out.print(result);
    }

}
