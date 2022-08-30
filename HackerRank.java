import java.util.*;
class HackerRank
{


    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
            List <Integer> res = new ArrayList<>();
            int n = arr.size();
            int k = d;
            while(k<=n-1)
            {
                res.add(arr.get(k++));
            }
            k = 0;
            while(k<d)
            {
                res.add(arr.get(k++));
            }
            return res;
        }

        public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
            // Write your code here
            List<Integer> res = new ArrayList<>();
                for(String q : queries)
                {
                    int i = 0;
                    for(String s : strings)
                    {
                        if(q.charAt(0) == s.charAt(0))
                        {
                            i = checkMatch(q,s) == true ? i+1 : i; 
                        }
                    }
                    res.add(i);
                }
                return res;
            }
        


    private static boolean checkMatch(String q, String s)
    {   
        if(q.length() != s.length())
        {
            return false;
        }
        
        for(int i = 1 ; i < s.length() ; i++ )
        {
            if(Character.compare(q.charAt(i), s.charAt(i)) != 0)
            {
                return false;
            }
        }

            return true;
    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("aba","baba","aba","xzxb");
        List<String> b = Arrays.asList("aba","xzxb","ab");
        List<Integer> res = matchingStrings(a,b);
        System.out.println(res.toString());
    }
}
