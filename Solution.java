import java.util.*;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.text.PlainDocument;

class Solution {

    public Solution(int[][] rects)
    {
        findpoints(rects);
    }

    public void findpoints(int[][] rects) {
        int[] rec1 = rects[0];
        int[] rec2 = rects[1];
        
        int x1min = Math.min(rec1[0],rec1[2]);
        int x1max = Math.max(rec1[0],rec1[2]);
        int y1min = Math.min(rec1[1],rec1[3]);
        int y1max = Math.max(rec1[1],rec1[3]);
        
        int x2min = Math.min(rec2[0],rec2[2]);
        int x2max = Math.max(rec2[0],rec2[2]);
        int y2min = Math.min(rec2[1],rec2[3]);
        int y2max = Math.max(rec2[1],rec2[3]);
    }
    
    // public int[] pick() {
        
    // }

    public static void main(String[] args) {

        int[][] rects = new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}};
        Solution s = new Solution(rects);
        //s.pick();
    }
}
