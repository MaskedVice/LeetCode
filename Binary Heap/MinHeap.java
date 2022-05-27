class MinHeap
{
    private int [] pq = null;
    private int n = 0;
    private int maxSize = 0;
    
    public MinHeap(int size)
    {
        pq = new int[size+1];
        maxSize = size+1;
    }

    public boolean isEmpty()
    {
        return n==0;
    }

    int size()
    {
        return n;
    }
    void insert(int k)
    {
        insertKey(pq,k);
    }

    private void insertKey(int[] pq2, int k)
    {
        if(n>maxSize) throw new IndexOutOfBoundsException("Heap full");
        pq[++n] = k;
        bubbleUp(n);
    }

    private int getMin()
    [
        int max = pq[1];
        pq[n--] = pq[1];
        bubbleDown(1);
    ]

    private int parent(int k)
    {
        if(k==1)
        {
            return(-1);
        }

        return (k/2);
    }

    void bubbleUp(int k)
    {
        while(k>0)
        {
            if(pq[k]<pq[k/2])
            {
                swap(pq[k/2], pq[k]); 
            }
            k/=2;
        }

    }

    void bubbleDown(int k)
    {
        while(2*k >= maxSize)
        {
            int j = 2*k;
            if(j<maxSize && pq[j] > pq[j+1]){
                j++;
            }
            if(pq[j]<pq[k])
            {
                swap(pq[j], pq[k]);
            }
            k = j;
        }
    }



    void swap(int a, int b)
    {
        int temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }


}