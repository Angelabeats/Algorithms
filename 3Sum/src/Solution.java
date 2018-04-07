import java.util.*;
public class Solution {
	public static void main(String[] args) {
		int[] n= {-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5};
		System.out.println(threeSum(n));
	}
	public static List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(numbers==null||numbers.length<3)return ret;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length;i++){
            if(i>0 && numbers[i]==numbers[i-1])continue;
            twoSum(numbers,i+1,-numbers[i],ret);
        }
        return ret;
    }
    public static void twoSum(int[] num,int start,int target,List<List<Integer>> ret){
        int j=num.length-1,i=start;
        List<Integer> tmpList;
        while(i<j){
            if(num[i]+num[j]==target){
               tmpList =new ArrayList<Integer>();
               tmpList.add(num[start-1]);
               tmpList.add(num[i]);
               tmpList.add(num[j]);
               ret.add(tmpList);
               i++;
               j--;
               while(i<j&&num[i]==num[i-1])i++;
               while(i<j&&num[j+1]==num[j])j--;
            }
            else{
                if(num[i]+num[j]<target)i++;
                else j--;
            }
        }
    }
}
