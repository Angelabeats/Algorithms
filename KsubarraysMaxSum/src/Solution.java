import java.util.*;
public class Solution {
	/*分析：与Best Time to Buy and Sell Stock IV类似，两个数组分别记录包含当前值的本地最优解和全局最优解。local[i][j]代表从0到nums中第i个数字处，
	 * 分成j个数组后，和的最大值,且必须包括第i个数字，这样可以排除第i个数组包含在前一个数组中的情况。global[i][j]代表从0到nums第i个数字处，分成j个数组后和的最大值。 
	 * 二维数组动态规划的状态转移方程为：*/
    //local[i][j] = Math.max(local[i - 1][j], global[i - 1][j - 1]) + nums[i - 1];
    //global[i][j] = Math.max(global[i - 1][j], local[i][j]);
    public static int maxSubArray(int[] nums, int k) {
        // write your code here
        if(k>nums.length){
            return 0;
        }
        int[][] local=new int[nums.length+1][k+1];
        int[][] global=new int[nums.length+1][k+1];
        for(int i=1;i<=nums.length;i++){
            //local[i][0]=Integer.MIN_VALUE;
            for(int j=1;j<=k;j++){
                if(j>i){
                    local[i][j]=Integer.MIN_VALUE;
                    global[i][j]=Integer.MIN_VALUE;
                    continue;
                }
                local[i][j]=Math.max(local[i-1][j],global[i-1][j-1])+nums[i-1];
                if(i==j){//处理i=j=1时 第一个元素的特殊情况
                    global[i][j]=local[i][j];
                }else{
                    global[i][j]=Math.max(global[i-1][j],local[i][j]);
                }
            }
        }
        return global[nums.length][k];
    }
    public static void main(String[] args) {
    	int[] a= {1,2,3};
    	System.out.println(maxSubArray(a,1));
    }
}