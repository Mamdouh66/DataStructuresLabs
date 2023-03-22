import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int arr[] = new int[6];
        int arr2[][] = new int[3][4];
        Scanner scan = new Scanner(System.in);

        // filling 1d array with elements
        for (int i = 0; i < arr.length; i++){
            System.out.print("Enter " +  (i+1) + " element >> ");
            arr[i] = scan.nextInt();
        }

        // filling 2d array
        for (int i = 0; i < arr2.length; i++){
            for (int j = 0; j < arr2[i].length; j++){
                System.out.print("Enter [" +  (i+1) + "] [" + (j+1) +"] element >> ");
                arr2[i][j] = scan.nextInt();
            }
        }

        // finding maximum in the arrays
        // 1d array
        int MAX = arr[0];
        for (int i = 0; i < 6; i++){
            if(arr[i] >= MAX)
                MAX = arr[i];
        }
        // 2d array
        int MAX2 = arr2[0][0];
        for (int i = 0 ; i < arr2.length; i++){
            for (int j = 0; j < arr2[i].length; j++){
                if (arr2[i][j] >= MAX2){
                    MAX2 = arr2[i][j];
                }
            }
        }

        System.out.println("Maximum value in 1d array is >> " + MAX);
        System.out.println("Maximum value in 2d array is >> " + MAX2);

        // finding minimum
        int MIN = arr[0];
        for (int i = 0; i < 6; i++){
            if(arr[i] <= MIN)
                MIN = arr[i];
        }
        // 2d array
        int MIN2 = arr2[0][0];
        for (int i = 0 ; i < arr2.length; i++){
            for (int j = 0; j < arr2[i].length; j++){
                if (arr2[i][j] <= MIN2){
                    MIN2 = arr2[i][j];
                }
            }
        }

        System.out.println("Minimum value in 1d array is >> " + MIN);
        System.out.println("Minimum value in 2d array is >> " + MIN2);

        // finding sum of each

        int sum = 0;
        for (int i = 0; i < 6; i++){
            sum += arr[i];
        }
        // 2d array
        int sum2 = 0;
        for (int i = 0 ; i < arr2.length; i++){
            for (int j = 0; j < arr2[i].length; j++){
                sum2 += arr2[i][j];
            }
        }

        System.out.println("Sum of values in 1d array is >> " + sum);
        System.out.println("Sum of values in 2d array is >> " + sum2);

        // Print even numbers
        System.out.println("Even elements in 1d array");
        for (int i = 0; i < 6; i++){
            if (arr[i] % 2 == 0){
                System.out.println(arr[i]);
            }
        }
        // 2d array
        System.out.println("Even elements in 2d array");
        for (int i = 0 ; i < arr2.length; i++){
            for (int j = 0; j < arr2[i].length; j++){
                if (arr2[i][j] % 2 == 0){
                    System.out.print(arr2[i][j] + " ");
                }
            }
            System.out.println();
        }

        // finding odd
        System.out.println("Odd elements in 1d array");
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0){
                System.out.println(arr[i]);
            }
        }
        // 2d array
        System.out.println("Odd elements in 2d array");
        for (int i = 0 ; i < arr2.length; i++){
            for (int j = 0; j < arr2[i].length; j++){
                if (arr2[i][j] % 2 != 0){
                    System.out.print(arr2[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}