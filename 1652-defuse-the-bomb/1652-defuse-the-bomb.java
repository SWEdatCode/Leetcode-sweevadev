class Solution {
    public int[] decrypt(int[] code, int k) {
        //k = 0; return 0.
        //k > 0; (i + j) % n
        //k < 0; (i - j) % n
        int n = code.length;
        int[] result = new int[n];
        
        if(k == 0){
            return result;
        }
        
        for(int i = 0; i < n; i++){
            int total = 0;
            
            if(k > 0){
                for(int j = 1; j <= k; j++){
                    total += code[(i + j) % n];
                }
            }
            else{
                for(int j = 1; j <= -k; j++){
                    total += code[(i - j + n) % n];
                }
            }
            result[i] = total;
        }
        return result;
    }
}