package Jd;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = scanner.nextInt();
            }

            System.out.println(solve(data));
        }
    }


    public static int solve(int[] data) {
        int currNumber = data[0];
        int result = 0;
        int temp = 0;

        int[] newArray = new int[data.length - 1];
        for (int i = 1; i < data.length; i++) {
            newArray[i - 1] = data[i];
        }
        BubbleSort(newArray);

        while (currNumber <= newArray[newArray.length - 1]) {
            currNumber++;
            newArray[newArray.length - 1]--;
            result++;
            BubbleSort(newArray);

        }
        return result;
    }


    public static void BubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}
