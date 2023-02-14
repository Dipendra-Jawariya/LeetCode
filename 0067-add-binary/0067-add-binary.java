class Solution {
    public String addBinary(String a, String b) {
//         //converting binary string into integer(decimal number)
//         int num1 = Integer.parseInt(a,2);
//         int num2 = Integer.parseInt(b,2);
        
//         // Adding those two decimal numbers and storing in sum
//         int sum = num1 + num2;
        
//         //converting that resultant decimal to binary string
//         String result = Integer.toBinaryString(sum);
//         return result;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j >= 0) {
            //sum = carry + i + j
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if(carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}