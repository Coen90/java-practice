package coding_test.test.codeup;

import java.io.*;

public class Codeup1099 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] house = new int[10][10];
        for (int i = 0; i < house.length; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < house[i].length; j++) {
                house[i][j] = Integer.parseInt(arr[j]);
            }
        }

        findWay(house);
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < house[i].length; j++) {
                bw.append(house[i][j] + " ");
            }
            bw.append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void findWay(int[][] house) {
        int x = 1;
        int y = 1;
        while(true) {
            if(house[y][x] == 2) {
                house[y][x] = 9;
                break;
            }
            house[y][x] = 9;
            if(house[y][x + 1] != 1) {
                x++;
            } else if(house[y + 1][x] != 1) {
                y++;
            } else {
                break;
            }
        }
    }
}
