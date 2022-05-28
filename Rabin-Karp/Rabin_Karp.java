import java.util.*;
class Rabin_Karp
{
    private static HashMap<Character,Integer> al = new HashMap<Character,Integer>();  
    public Rabin_Karp()
    {
        InitializeHash();
    }

    public List<Integer> findMatch(char[] s, char [] p)
    {
        double p_hash = find_hash(p, 0, p.length-1);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i <=s.length-p.length ; i++)
        {
            double s_hash = find_hash(s, i, i+p.length-1);
            if(s_hash == p_hash)
            {
                ans.add(i);
            }
        }
        return ans;
    }


    private double find_hash(char[] c, int start , int end)
    {
        double s = 0;
        double h = Math.pow(10, end-start);
        for (int i = start; i <= end; i++)
        {
            s+= al.get(c[i]) * h;
            h/=10;   
        }
        return s;
    }

    private void InitializeHash()
    {
        int i = 1;
        al.put('a',i++);
        al.put('b',i++);
        al.put('c',i++);
        al.put('d',i++);
        al.put('e',i++);
        al.put('f',i++);
        al.put('g',i++);
        al.put('h',i++);
        al.put('i',i++);
        al.put('j',i++);
        al.put('k',i++);
        al.put('l',i++);
        al.put('m',i++);
        al.put('n',i++);
        al.put('o',i++);
        al.put('p',i++);
        al.put('q',i++);
        al.put('r',i++);
        al.put('s',i++);
        al.put('t',i++);
        al.put('u',i++);
        al.put('v',i++);
        al.put('w',i++);
        al.put('x',i++);
        al.put('y',i++);
        al.put('z',i++);
    }

    public static void main(String[] args) {
        String s = "abbbbbaabbaabaabbbaaaaabbabbbabbbbbaababaabbaabbbbbababaababbbbaaabbbbabaabaaaabbbbabbbaabbbaabbaaabaabaaaaaaaa";
        String p = "abbbaababbbabbbabbbbbabaaaaaaabaabaabbbbaabab";
        Rabin_Karp m = new Rabin_Karp();
        List<Integer> answer = m.findMatch(s.toCharArray(), p.toCharArray());
        if(answer.size() == 0)
        {
            System.out.println(-1);
        }
        
        
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

}