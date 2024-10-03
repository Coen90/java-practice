package coding_test.test.baekjoon;

public class Bj14499 {

    public static void main(String[] args) {

    }

    public static class Dice {

        private final int[][] values;

        public Dice() {
            this.values = new int[][]{
                    {-1, 0, -1},
                    {0, 0, 0},
                    {-1, 0, 0},
                    {-1, 0, 0}
            };
        }

        //동서남북 이동
        public void move(int dir) {
            switch (dir) {
                case 1:
                    moveToEast();
                case 2:
                    moveToWest();
                case 3:
                    moveToNorth();
                case 4:
                    moveToSouth();
            }
        }

        //바닥칸 copy
        public int copy(int num) {
            if (num == 0) {
                return getBottomValue();
            }
            setBottomValue(num);
            return 0;
        }
        //상단값 출력

        private void setBottomValue(int value) {
            this.values[1][1] = value;
        }

        private int getBottomValue() {
            return this.values[1][1];
        }

        private void moveToEast() {
            int temp = this.values[1][0];
            this.values[1][0] = this.values[1][1];
            this.values[1][1] = this.values[1][2];
            this.values[1][2] = this.values[3][1];
            this.values[3][1] = temp;
        }

        private void moveToWest() {
            int temp = this.values[1][0];
            this.values[1][0] = this.values[3][1];
            this.values[3][1] = this.values[1][2];
            this.values[1][2] = this.values[1][1];
            this.values[1][1] = temp;
        }

        private void moveToNorth() {
            int temp = this.values[0][1];
            this.values[0][1] = this.values[3][1];
            this.values[3][1] = this.values[2][1];
            this.values[2][1] = this.values[1][1];
            this.values[1][1] = temp;
        }

        private void moveToSouth() {
            int temp = this.values[0][1];
            this.values[0][1] = this.values[1][1];
            this.values[1][1] = this.values[2][1];
            this.values[2][1] = this.values[3][1];
            this.values[3][1] = temp;
        }
    }

    public static class Board {

        private final int[][] board;

        public Board(int[][] board) {
            this.board = board;
        }

        public boolean isValid(int x, int y) {
            return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
        }

        public void setBoardNumber(int x, int y, int number) {
            this.board[x][y] = number;
        }

        public int getBoardNumber(int x, int y) {
            return this.board[x][y];
        }

        public void setValues(int x, int y, int value) {
            this.board[x][y] = value;
        }
    }
}
