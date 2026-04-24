package dsa76;

import java.util.*;

public class CountString2D {

    static int[] rowDir = {-1, 1, 0, 0};
    static int[] colDir = {0, 0, -1, 1};

    public static int dfs(char[][] mat, String word, int i, int j, int idx) {

        if(idx == word.length())
            return 1;

        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length
           || mat[i][j] != word.charAt(idx))
            return 0;

        char temp = mat[i][j];
        mat[i][j] = '#';

        int count = 0;

        for(int d = 0; d < 4; d++) {
            count += dfs(mat, word, i + rowDir[d], j + colDir[d], idx + 1);
        }

        mat[i][j] = temp;

        return count;
    }

    public static int countOccurrences(char[][] mat, String word) {
        int count = 0;

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == word.charAt(0)) {
                    count += dfs(mat, word, i, j, 0);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();
        sc.nextLine();

        char[][] mat = new char[r][c];

        // Input matrix
        System.out.println("Enter matrix row by row:");
        for(int i = 0; i < r; i++) {
            String row = sc.nextLine();
            for(int j = 0; j < c; j++) {
                mat[i][j] = row.charAt(j);
            }
        }

        // Input word
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        int result = countOccurrences(mat, word);

        System.out.println("Occurrences = " + result);

        sc.close();
    }
}
