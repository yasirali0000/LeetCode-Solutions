class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String lcs = LCS(str1, str2);
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        for (int k = 0; k < lcs.length(); k++) {
            char ch = lcs.charAt(k);
            // str1 ke extra characters add karo
            while (str1.charAt(i) != ch) {
                ans.append(str1.charAt(i));
                i++;
            }
            // str2 ke extra characters add karo
            while (str2.charAt(j) != ch) {
                ans.append(str2.charAt(j));
                j++;
            }
            // Common character ek baar add karo
            ans.append(ch);
            i++;
            j++;
        }
        // str1 ke remaining characters
        while (i < str1.length()) {
            ans.append(str1.charAt(i));
            i++;
        }
        // str2 ke remaining characters
        while (j < str2.length()) {
            ans.append(str2.charAt(j));
            j++;
        }
        return ans.toString();
    }
    public String LCS(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = m,j=n;
        while(i>0 && j>0) {
            if(a.charAt(i-1)==b.charAt(j-1)) {
                ans.append(a.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i-1][j]>dp[i][j-1]) i--;
                else j--;
            }
        }
        return ans.reverse().toString(); 
    }
}