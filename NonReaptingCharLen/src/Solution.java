import java.util.*;
public class Solution {
	public static int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s==null||s.length()<1)return 0;
        int ans= 0;int start=0;char ch;
        Map<Character,Integer> map =new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,i);
            }
            else {
            	if(map.get(ch)>=start)
            		start = map.get(ch) +1;
            	map.put(ch,i);
            }
            ans=Math.max(i-start+1,ans);
        }
        return ans;
    }
	public static void main(String[] args) {
		String s="dqirnnnchguccmkluloyzunslxhgxjyazitnxgreplhrzreuessdofxacgicpgcpqyengvrvjamitscxk";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
