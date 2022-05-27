public class MyDynamicArray
{
    public int [] arr;
     int i;
     int size;
    public MyDynamicArray(int s)
    {
        arr = new int[s];
        size = s;
        i = 0;
    }

    public void add(int a)
    {
        if(i < size)
        {
            arr[i++] = a;
        }
        else
        {
            doubleArray();
            arr[i++] = a;
            size*=2;
        }
        
    }

    public void delete()
    {
        arr[i--] = 0;
    }

    public void doubleArray()
    {
        int[] temp = new int[size*2];
        for(int i = 0 ; i < arr.length ; i++)
        {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void print() {
        for(int i : arr){
            System.out.print(i + " ");
        }
        
        System.out.println();
    }

}