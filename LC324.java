import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class LC324 
{
    public static void wiggleSort(int[] nums)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int[] ans = new int[nums.length];
        Arrays.fill(ans, 0);
        
        for(int i : nums)
        {
            minHeap.add(i);
            maxHeap.add(i);
        }

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(i==0)
            {
                ans[i] = minHeap.poll();
                continue;
            }

            if(i%2 != 0)
            {
                ans[i] = maxHeap.poll();
            }
            else if(i%2 == 0)
            {
                ans[i] = minHeap.poll();
            }
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        wiggleSort(new int[]{1,5,1,1,6,4});
    }
}