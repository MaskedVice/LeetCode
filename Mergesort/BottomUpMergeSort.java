package Mergesort;

import java.util.LinkedList;
import java.util.Queue;

public class  BottomUpMergeSort {
    
    public static int[] ar;

    public static int[] BottomUpMergeSort(int[] arr)
    {
        int n = arr.length;
        // merge(arr, 0, 0, 1);
        // merge(arr, 2, 2, 3);
        // merge(arr, 4, 4, 5);
        // merge(arr, 6, 6, 7);
        // merge(arr, 8, 8, 9);
        // merge(arr, 10, 10, 11);
        // merge(arr, 12, 12, 13);
        // merge(arr, 14, 14, 15);

        // merge(arr, 0, 1 , 3);
        // merge(arr, 4, 5, 7);
        // merge(arr, 8, 9, 11);
        // merge(arr, 12, 13, 15);

        // merge(arr, 0, 3, 7);
        // merge(arr, 8, 11, 15);

        // merge(arr, 0, 7, 15);

        for(int size = 1 ; size < n ; size +=size )
        {
            for(int lo = 0 ; lo < n-size ; lo += size+size)
            {
                merge(arr,lo,lo+size-1,Math.min(n-1,lo+size+size-1));
            }
        }
        return arr;
    }

    private static  void merge(int[] ar2, int low, int mid, int high)
    {
        System.out.println(low + " " + mid + " " + high +  "");
        Queue<Integer> b1 = new LinkedList<>();
        Queue<Integer> b2 = new LinkedList<>();
        
        for (int i = low; i <= mid; i++)
        {
            b1.add(ar2[i]);    
        }

        for (int i = mid+1; i <= high; i++)
        {
            b2.add(ar2[i]);    
        }
        int k = low;

        while (!b1.isEmpty() & !b2.isEmpty()) 
        {
            if(b1.peek()>b2.peek())
            {
                ar2[k++] = b2.remove(); 
            }
            else
            {
                ar2[k++] = b1.remove();
            }
        }

        while(!b1.isEmpty())
        {
            ar2[k++] = b1.remove();
        }

        while (!b2.isEmpty())
        {
            ar2[k++] = b2.remove();    
        }    
    }


    public static void main(String[] args) {
        
        int[] a = new int[]{5,7,10,9,6,1,8,3,2,4,15,13,11,12,14,0};
        a = BottomUpMergeSort(a);
        for (int i : a) {
            System.out.print(i+ " ");
        }
    }
}
