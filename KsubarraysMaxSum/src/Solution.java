import java.util.*;
public class Solution {
	/*��������Best Time to Buy and Sell Stock IV���ƣ���������ֱ��¼������ǰֵ�ı������Ž��ȫ�����Ž⡣local[i][j]�����0��nums�е�i�����ִ���
	 * �ֳ�j������󣬺͵����ֵ,�ұ��������i�����֣����������ų���i�����������ǰһ�������е������global[i][j]�����0��nums��i�����ִ����ֳ�j�������͵����ֵ�� 
	 * ��ά���鶯̬�滮��״̬ת�Ʒ���Ϊ��*/
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
                if(i==j){//����i=j=1ʱ ��һ��Ԫ�ص��������
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