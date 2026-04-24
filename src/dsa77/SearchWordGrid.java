package dsa77;

import java.util.*;

public class SearchWordGrid {

    static int[] x = {-1,-1,-1,0,0,1,1,1};
    static int[] y = {-1,0,1,-1,1,-1,0,1};

    public static boolean search2D(char[][] grid, int row, int col, String word) {

        if(grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        for(int dir = 0; dir < 8; dir++) {

            int k, rd = row + x[dir], cd = col + y[dir];

            for(k = 1; k < len; k++) {
                if(rd < 0 || cd < 0 || rd >= grid.length || cd >= grid[0].length)
                    break;

                if(grid[rd][cd] != word.charAt(k))
                    break;

                rd += x[dir];
                cd += y[dir];
            }

            if(k == len)
                return true;
        }

        return false;
    }

    public static void patternSearch(char[][] grid, String word) {

        System.out.println("Word found at positions:");

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(search2D(grid, row, col, word))
                    System.out.println(row + " " + col);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input rows and columns
        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[r][c];

        // Input grid
        System.out.println("Enter grid row by row:");
        for(int i = 0; i < r; i++) {
            String row = sc.nextLine();
            for(int j = 0; j < c; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        // Input word
        System.out.print("Enter word to search: ");
        String word = sc.nextLine();

        patternSearch(grid, word);

        sc.close();
    }
}
