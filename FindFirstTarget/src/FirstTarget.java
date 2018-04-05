//find target in O(long(n))

import java.util.*;
public class FirstTarget {
	public static void main(String[] args) {
		Solution s1=new Solution();
		int[] a= {1,4,4,5,7,7,8,9,9,10};
		System.out.println(s1.binarySearch(a,1));
	}
}
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */

	
    public int binarySearch(int[] nums, int target) {
        // write your code here
        int k=search(nums,0,nums.length-1,target);
        for(int i = k -1;i>-1;i--){
            if(nums[i]==target)k=i;
            else break;
        }
        return k;
    }
    public int search(int[] nums,int low,int high,int k){
        if(low > high)return -1;
        if(nums[low] == k)return low;
        if(nums[high] == k)return high;
        
        int mid=(low+high)/2;
        if(nums[mid]==k)return mid;
        else if(nums[mid] > k)return search(nums, low, mid -1, k);
        else return search(nums, mid+1, high, k);
    }
}
