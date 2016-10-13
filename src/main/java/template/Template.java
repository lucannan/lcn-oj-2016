package template;

import org.junit.Test;

import java.util.*;

public class Template {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }


    @Test
    public void test01() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = Arrays.copyOf(a, a.length);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
    
    
    public static class HeapSort{
        public static void swap(int[]data,int a,int b){
//            if(a ==b){
//                return;
//            }
            int tmp = data[a];
            data[a] = data[b];
            data[b] = tmp;
        }
        
        
        public static void createHeap(int[] data,int lastIndex){
            for (int i = (lastIndex - 1 )/2; i>=0;i--) {
                int k = i;
                while(2 * k + 1 <= lastIndex){
                    int bigIndex = 2 *k +1;
                    if(bigIndex < lastIndex){
                        if(data[bigIndex] < data[bigIndex + 1]){
                            bigIndex++;
                        }
                    }

                    if(data[k] < data[bigIndex]){
                        swap(data,k,bigIndex);
                        k = bigIndex;
                    }else{
                        break;
                    }
                }
            }
        }


        public static void heapSort(int[] data){
            for (int i = 0; i < data.length; i++) {
                createHeap(data,data.length - 1 -i);
                swap(data,0,data.length -1 - i);
            }
        }


        public static void main(String[] args) {
            int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
            HeapSort.heapSort(data5);
            System.out.println(Arrays.toString(data5));
        }
        
        
        

    }
}
