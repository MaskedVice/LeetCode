import java.util.LinkedList;
import java.util.Queue;

/**
 * Mergesort
 */
public class Mergesort 
{

    public static int [] ar;
    public static int [] Mergesort(int[] arr){
        ar = arr;

        sort(ar,0,ar.length-1);

        return ar;
    }
    private static void sort(int[] ar, int low, int high)
    {
        if(low<high)
        {
             int mid = (low+high)/2;
             sort(ar, low, mid);
             sort(ar, mid+1, high);
             merge(ar,low,mid,high);
             for (int i : ar)
            {
                System.out.print(i + " ");    
            }
        System.out.println();
        }
    }

    private static  void merge(int[] ar2, int low, int mid, int high)
    {
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

    public static void main(String[] args)
    {
        int[] a = new int[]{5,7,10,9,6,1,8,3,2,4};
        a = Mergesort(a);


    }

}