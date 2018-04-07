import java.util.*;
class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
// Failed on case: [[0,0],[94911151,94911150],[94911152,94911151]]
public class Solution {
    public static int maxPoints(Point[] points) {
        if(points==null||points.length<1)return 0;
        double tmp = 0.0;
        int ans=0; int pCnt = 1;int maxNum=0;
        Map<Double,Integer> map;
        for(int i=0;i<points.length;i++){
            map =new HashMap<Double,Integer>();
            maxNum = 0;
            pCnt=1;
            for(int j=i+1;j<points.length;j++){
                if(points[i].x==points[j].x&&points[i].y==points[j].y){
                    pCnt++;
                    //ans = Math.max(ans,pCnt);
                }
                else if(points[i].x==points[j].x){
                    map.put(Double.MAX_VALUE,map.getOrDefault(Double.MAX_VALUE,0)+1);
                    maxNum=Math.max(maxNum,map.get(Double.MAX_VALUE));
                }
                else {
                    tmp=(double)(points[i].y-points[j].y)/(points[i].x-points[j].x);
                    map.put(tmp,map.getOrDefault(tmp,0) + 1);
                    maxNum=Math.max(maxNum,map.get(tmp));
                }
            }
            ans = Math.max(ans,maxNum+pCnt);
        }
        /*if(points==null||points.length<1)return 0;
        int ans=0;
        int len = points.length;
        int pCnt=1; int x1,y1,x2,y2,x3,y3;
        for(int i=0;i<len;i++){
            pCnt=1;
            x1=points[i].x;
            y1=points[i].y;
            for(int j=i+1;j<len;j++){
                int cnt=0;
                x2=points[j].x;
                y2=points[j].y;
                if(x1==x2&&y1==y2){
                    pCnt++;
                    continue;
                }
                for(int k=0;k<len;k++){
                    x3=points[k].x;
                    y3=points[k].y;
                    if(x1*y2 + x2*y3 + x3*y1 - x3*y2 - x2*y1 - x1 * y3 == 0)
                        cnt++;
                }
                ans = Math.max(ans,cnt);
            }
            ans = Math.max(ans,pCnt);
        }*/
        return ans;
    }
	public static void main(String[] args) {
		int[][] p = {{0,9},{138,429},{115,359},{115,359},{-30,-102},{230,709},{-150,-686},{-135,-613},{-60,-248},{-161,-481},{207,639},
				{23,79},{-230,-691},{-115,-341},{92,289},{60,336},{-105,-467},{135,701},{-90,-394},{-184,-551},{150,774}};
		Point[] a= new Point[p.length];
		for(int i=0;i<p.length;i++){
			a[i]=new Point(p[i][0],p[i][1]);
		}
		System.out.println((double)((a[1].y-a[0].y)/(a[1].x-a[0].x)));
		System.out.println((double)(a[1].y-a[0].y)/(a[1].x-a[0].x));
		System.out.println((a[1].y-a[0].y)/(a[1].x-a[0].x));
		System.out.println(maxPoints(a));
	}
}