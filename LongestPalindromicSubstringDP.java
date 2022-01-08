public String longestPalindrome(String s) {
        int len = s.length();
        
        int anslen = 0;
        int ansstartidx = 0;
        int ansendidx = 1;
        
        int [][] dp = new int[len][len];
        
        for(int i = 0; i < len; i++)
            dp[i][i] = 1;
        
        for(int i= 0; i < len-1; i++){
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1) ? 1 : 0);
            if(dp[i][i+1] == 1)
            {
                ansstartidx = i;
                ansendidx = i+2;
            }
        }
        
        int tlen =3;
        
        for(tlen = 3; tlen <= len; tlen++){
            
            for(int i = 0 ; i < len; i++){
                if(i + tlen <= len){
                    if((s.charAt(i) == s.charAt(i+tlen-1) ) && (dp[i+1][i+tlen-2] == 1 )){
                        dp[i][i+tlen-1] = 1;
                        if(tlen > anslen){
                            anslen = tlen;
                            ansstartidx = i;
                            ansendidx = i + tlen;
                        }
                    }
                }
            }
            
        }
        
        String ansstr = s.substring(ansstartidx,ansendidx);
        
        return ansstr;
        
        
    }