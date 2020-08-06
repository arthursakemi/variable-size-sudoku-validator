import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        ArrayList<String[]> input = new ArrayList<>();
        String inputLine;

        for (int i = 0; i < size * size; i++) {
            inputLine = sc.nextLine();
            input.add(inputLine.split(" "));
        }

        int[][] board = convertInput(input);

        for (int i = 0; i < board.length; i++) {
            if (!isRowValid(board, i) || !isColumnValid(board, i) || !isSquareValid(board, i, size)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

    public static boolean isRowValid(int[][] board, int row) {
        TreeSet<Integer> rowSet = new TreeSet<>();

        for (int i = 0; i < board.length; i++) {
            int cell = board[row][i];
            if (cell > board.length) {
                return false;
            }
            rowSet.add(board[row][i]);
        }
        return rowSet.size() == board.length;
    }

    public static boolean isColumnValid(int[][] board, int column) {
        TreeSet<Integer> columnSet = new TreeSet<>();

        for (int[] row : board) {
            int cell = row[column];
            if (cell > board.length) {
                return false;
            }
            columnSet.add(cell);
        }

        return columnSet.size() == board.length;
    }

    public static boolean isSquareValid(int[][] board, int square, int size) {
        TreeSet<Integer> squareSet = new TreeSet<>();
        int row = square / size;
        int column = square % size;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int cell = board[i + row * size][j + column * size];
                if (cell > board.length) {
                    return false;
                }
                squareSet.add(cell);
            }
        }
        return squareSet.size() == board.length;
    }

    private static int[][] convertInput(ArrayList<String[]> input) {
        int[][] intMatrix = new int[input.size()][input.get(0).length];

        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).length; j++) {
                intMatrix[i][j] = Integer.parseInt(input.get(i)[j]);
            }
        }
        return intMatrix;
    }
}
