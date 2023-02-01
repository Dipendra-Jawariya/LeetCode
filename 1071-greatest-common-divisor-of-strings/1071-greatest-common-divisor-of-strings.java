class Solution {
   int gcd(int a, int b) {
	if (b == 0) {
		return a;
	}
	return gcd(b, a % b);
}
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if((str1+str2).equals((str2+str1))){
            return str1.substring(0,gcd(n,m));
        }
        return "";
    }
}