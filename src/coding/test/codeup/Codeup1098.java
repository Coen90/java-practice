package coding.test.codeup;

import java.io.*;

public class Codeup1098 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arrXy = br.readLine().split(" ");
        int arrX = Integer.parseInt(arrXy[0]);
        int arrY = Integer.parseInt(arrXy[1]);
        int[][] go = new int[arrX][arrY];
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] arr = br.readLine().split(" ");
            int len = Integer.parseInt(arr[0]);
            int dir = Integer.parseInt(arr[1]);
            int x = Integer.parseInt(arr[2]) - 1;
            int y = Integer.parseInt(arr[3]) - 1;
            crossUpDown(go, len, dir, x, y);
        }
        for (int i = 0; i < go.length; i++) {
            for (int j = 0; j < go[i].length; j++) {
                bw.append(go[i][j] + " ");
            }
            bw.append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void crossUpDown(int[][] go, int len, int dir, int x, int y) {
        for (int i = 0; i < go.length; i++) {
            for (int j = 0; j < go[i].length; j++) {
                if (i == x && j == y) {
                    go[i][j] = 1;
                    for (int k = 0; k < len; k++) {
                        if (dir == 0) {
                            go[i][j + k] = 1;
                        } else {
                            go[i + k][j] = 1;
                        }
                    }
                }
            }
        }
    }
}
