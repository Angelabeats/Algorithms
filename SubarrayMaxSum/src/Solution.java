import java.util.*;
public class Solution {
	public static int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int[] sum=new int[nums.size()];
        int[] sum2=new int[nums.size()];
        int record=sum[0]=nums.get(0);
        for(int i=1;i<nums.size();i++){
            if(record<=0)
            	record = nums.get(i);
            else record += nums.get(i);
            sum[i] = record;
            if(sum[i]<sum[i-1])
            	sum[i]=sum[i-1];
        }
        record=sum2[sum2.length -1]=nums.get(nums.size()-1);
        for(int i=nums.size()-2;i >= 0;i--){
            if(record <= 0)
            	record = nums.get(i);
            else record += nums.get(i);
            sum2[i]=record;
            if(sum2[i]<sum2[i+1])
            	sum2[i]=sum2[i+1];
        }
        int ans = sum[0]+sum2[1];
        for(int i=1;i<sum.length -1;i++){
            if(sum[i] + sum2[i+1] > ans)
                ans = sum[i] + sum2[i+1];
        }
        return ans;
    }
	public static void main(String[] args) {
		Solution s =new Solution();
		Integer[] a= {1,3,-1,2,-1,2};
		ArrayList<Integer> b=new ArrayList();
		b.addAll(Arrays.asList(a));
		System.out.println(maxTwoSubArrays(b));
	}
}
