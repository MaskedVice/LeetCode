/**
 * QuickSort
 */
public class QuickSort {

    public int ans[];

    public  QuickSort(int[] arr)
    {
        ans = arr;
        sort(ans,0,arr.length-1);
    }

    private void sort(int[] arr, int start, int end)
    {
        int p; 
        if(start < end)
        {        
            p = partition(arr,start,end);
            sort(arr, start, p-1);
            sort(arr, p+1, end);
        }
        else
        {
            return;
        }

    }

    private int partition(int[] arr, int start, int end)
    {
        int lp = start;
        int rp = end-1;
        int p = arr[end];
        while (rp>lp) {
            while(arr[lp]<p  && lp < rp )
            {
                lp++;
            } 

            while(arr[rp]>p && lp < rp)
            {
                 rp--;
            }

            swap(arr,lp,rp);
        }
        if(arr[lp]>arr[end])
        {
            swap(arr,lp,end);
        }
        printall();
        return lp;
    }

    private void swap(int[] arr,int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    private void printall()
    {
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int arr[] = new int[]{9 ,8, 6, 7, 3, 5, 4, 1, 2};
        QuickSort s = new QuickSort(arr);
    }
}