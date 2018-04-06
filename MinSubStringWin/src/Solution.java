import java.util.*;
public class Solution {
	public static String minWindow(String source , String target) {
        // write your code here
		if(target.length()>source.length())return "";
        String ans="";
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        int count=0;
        char[] tmp=target.toCharArray();
        for(int i=0;i<tmp.length;i++) {
        	if(!map.containsKey(tmp[i])) {
        		map.put(tmp[i], 1);
        	}
        	else map.put(tmp[i], map.get(tmp[i])+1);
        }
        int low = -1;
        tmp=source.toCharArray();
        int val=0; 
        for(int i=0;i < tmp.length;i++) {
        	if(map.containsKey(tmp[i])){
    			if(low==-1)low=i;
				val = map.get(tmp[i]);
				if(val > 0)count++;
				map.put(tmp[i], val-1);
        	}
        	while(count==target.length()) {
        		if(map.containsKey(tmp[low])){
        			val = map.get(tmp[low]);
        			map.put(tmp[low], val + 1);
        			if(val >= 0)break;
        		}
        		low++;
        	}
        	if(count==target.length()){
    			ans=source.substring(low, i+1);
    			break;
    		}
        }
        return ans;
    }
	public static void main(String[] args) {
		String s="aaaaaaaaaaaabbbbbcdd";
		String t ="abc";
		//String s="abcd";
		//		String t ="ac";
		System.out.println(minWindow(s,t));
	}
}
