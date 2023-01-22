package coding.test.codeup;

import java.io.*;

public class Codeup1097 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] go = new int[19][19];
        for (int i = 0; i < go.length; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                go[i][j] = Integer.parseInt(arr[j]);
            }
        }
//        for(int i = 0; i < go.length; i++) {
//            for (int j = 0; j < go[i].length; j++) {
//                System.out.print(go[i][j] + " ");
//            }
//            System.out.println();
//        }
        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String[] arr = br.readLine().split(" ");
            int x = Integer.parseInt(arr[0]) - 1;
            int y = Integer.parseInt(arr[1]) - 1;
            crossUpDown(go, x, y);
        }

        for(int i = 0; i < go.length; i++) {
            for (int j = 0; j < go[i].length; j++) {
                bw.append(go[i][j] + " ");
            }
            bw.append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void crossUpDown(int[][] go, int x, int y) {
        for (int i = 0; i < go.length; i++) {
            for (int j = 0; j < go[i].length; j++) {
                if(i == x || j == y) {
                    if(go[i][j] == 0) {
                        go[i][j] = 1;
                    } else {
                        go[i][j] = 0;
                    }
                }
                if(i == x && j == y) {
                    if(go[i][j] == 0) {
                        go[i][j] = 1;
                    } else {
                        go[i][j] = 0;
                    }
                }
            }
        }
    }
}
