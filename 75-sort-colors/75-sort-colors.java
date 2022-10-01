class Solution {
    public void sortColors(int[] nums) {
        int count[]={0,0,0};
        for(int i =0;i<nums.length;i++){
            count[nums[i]] +=1;
        }
        for(int i =0;i<count.length;i++){
            System.out.print("Theee count array "+i+ " count will be ");
            System.out.print(count[i]+" ");
            System.out.println();
        }
        int j=0;
        for(int i =0;i<nums.length;i++){
            if(count[j]==0){
                ++j;
                --i;
            }
            else{
                nums[i] = j;
                System.out.println("The curr index "+ i + " value is " + nums[i]);
                --count[j];
                System.out.println("The j is "+ j);
            }
        }
    }
}