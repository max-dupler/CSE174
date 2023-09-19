/**
 * Max Dupler
 * Lab 12
 * 2D arrays
 * November 13th, 2021
 */
import java.util.Scanner;
 
public class Lab12 {
 
    static Scanner in = new Scanner(System.in);
    
    /**.
     * gets the number of rows in a given array
     * @param arr an int 2D array
     * @return the number of rows an int
     */
    public static int getNumRows(int[][] arr) {
        return arr.length;
    }
    
    /**.
     * gets the length of a given row
     * @param arr a 2D int array
     * @param row an int
     * @return the row length and int
     */
    public static int getRowLength(int[][] arr, int row) {
        if (row < 0 || row >= arr.length) {
            return 0;
        }
        
        return arr[row].length;
    }
    
    /**.
     * changes the value of a given value of the array
     * @param arr a 2D int array
     * @param row an int 
     * @param col an int
     * @param newVal an int
     */
    public static void changeElem(int[][] arr, int row, int col, int newNum) {
        if (row >= 0 && row < arr.length 
            && col >= 0 && col < arr[row].length) {
            arr[row][col] = newNum;
        }
    }
    
    /**.
     * displays a 2D array
     * @param arr a 2D int array
     */
    public static void display(int[][] arr) {
        for (int[] rows: arr) {
            for (int character: rows) {
                System.out.printf("%d ", character);
            }
            System.out.println();
        }
    }
    
    /**.
     * tells you if the sum of all rows in a 2D array are equal
     * @param arr a 2D int array
     * @return whether the sum of all rows are equal a boolean
     */
    public static boolean isMagicRows(int[][] arr) {
        int[] total = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int num : arr[i]) {
                total[i] += num;
            }
        }
        
        int last = total[0];
        for (int num : total) {
            if (last != num) {
                return false;
            }
        }
        return true;
    }
    
    /**.
     * tells you if the sum of all columns in a 2D array are equal
     * @param arr a 2D int array
     * @return whether the sum of all columns are equal a boolean
     */
    public static boolean isMagicColumns(int[][] arr) {
        int[] total = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                total[i] += arr[i][j];
            }
        }
        
        int last = total[0];
        for (int num : total) {
            if (last != num) {
                return false;
            }
        }
        return true;
    }
    
    //main method
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {2, 3, 1, 4}, {3, 1, 5, 1}, {4, 4, 1, 1}};
        System.out.println(getNumRows(arr));  
        System.out.println(getRowLength(arr, 3));   
        display(arr); 
    }
}

 