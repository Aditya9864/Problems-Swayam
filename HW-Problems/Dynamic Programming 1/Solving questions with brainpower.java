
//RECURSION
class Solution {
    public long mostPoints(int[][] questions) {
        return find(questions,0);
    }
    long find(int q[][], int i) 
    {
        if(i>= q.length)
            return 0;

        long skip=find(q, i+1);
        long solve=q[i][0] + find(q, i+q[i][1]+1);
        return Math.max(skip, solve);
    }
}


//MEMOIZATION
class Solution {
    public long mostPoints(int[][] questions) {
        long cache[]=new long[questions.length];
        Arrays.fill(cache,-1);
        return find(questions, 0, cache);
    }
    long find(int q[][], int i, long cache[]) 
    {
        if(i>= q.length)
            return 0;
        if(cache[i] != -1)
            return cache[i];

        long skip= find(q, i+1, cache);
        long solve= q[i][0] + find(q, i+q[i][1]+1, cache);
        cache[i] = Math.max(skip, solve);
        return cache[i];
    }
}



//DP
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long dp[]=new long[n+1];
        for(int i=n-1; i>=0; i--)
        {
            if(i+questions[i][1]+1 < n)
                dp[i]=Math.max(questions[i][0] + dp[i+questions[i][1]+1], dp[i+1]);
            else
                dp[i] = Math.max(questions[i][0], dp[i+1]);  
        }
        return dp[0];
    }
}