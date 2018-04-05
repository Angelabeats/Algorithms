import java.util.*;
import java.lang.*;
class TreeNode{
	int val;
	int height;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x)
    {
        val = x;
        left = null;
        right = null;
        height=0;
    }
    public static int hei(TreeNode root) {
    	return root==null?-1:root.height;
    }
}
public class TreeOP {
	static int[] preOrder, inOrder, postOrder;
    static int[] tra_preval, tra_inval, tra_postval,tra_levelval, tra_depthval;
    static int index_post,index_in,index_pre,index_level,index_depth;
	public static void main(String[] args) {
		inOrder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
		
		/*先序遍历+中序遍历*/
		preOrder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8 };
		postOrder = new int[inOrder.length];
		TreeNode root=reBuild_pre_in(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
		
		/*后序序遍历+中序遍历*/
        //postOrder = new int[] { 7, 4, 2, 5, 8, 6, 3, 1 };
        //preOrder = new int[inOrder.length];
        //TreeNode root = reBuild_in_post(inOrder, 0, inOrder.length - 1,postOrder,0,postOrder.length-1);
        
        tra_preval = new int[inOrder.length];
        tra_inval = new int[inOrder.length];
        tra_postval = new int[inOrder.length];
        tra_levelval = new int[inOrder.length];
        tra_depthval = new int[inOrder.length];
        index_pre = index_in = index_post =index_level= index_depth=0;

        traverse_pre(root);
        traverse_in(root);
        traverse_post(root);
        traverse_level(root);
        traverse_depth(root);

        System.out.print("preOrder:");
        for(int a : tra_preval)
        {
        	System.out.print(a+" ");
        }
        System.out.println();
        System.out.print("inOrder:");
        for(int a : tra_inval)
        {
        	System.out.print(a + " ");
        }
        System.out.println();
        System.out.print("postOrder:");
        for(int a : tra_postval)
        {
        	System.out.print(a + " ");
        }
        System.out.println();
        System.out.print("levelOrder:");
        for(int a : tra_levelval)
        {
        	System.out.print(a + " ");
        }
        System.out.println();
        System.out.print("depthOrder:");
        for(int a : tra_depthval)
        {
        	System.out.print(a + " ");
        }
	}
	
	@SuppressWarnings("unused")
	private static TreeNode reBuild_pre_in(int[] pre, int pre_low, int pre_high, int[] inorder, int in_low, int in_high)
    {
        if (pre_low > pre_high|| in_low> in_high) return null;
        TreeNode root = new TreeNode(pre[pre_low]);
        for(int i= in_low; i<= in_high;i++)
        {
            if (inorder[i] == pre[pre_low])
            {
                root.left = reBuild_pre_in(pre, pre_low + 1, pre_low + i - in_low, inorder, in_low, i - 1);
                root.right = reBuild_pre_in(pre, pre_low + i - in_low + 1, pre_high, inorder, i + 1, in_high);
            }
        }
        root.height = Math.max(TreeNode.hei(root.left), TreeNode.hei(root.right)) + 1;
        return root;
    }
    private static TreeNode reBuild_in_post(int[] inorder, int in_low, int in_high, int[] postorder, int post_low, int post_high)
    {
        if (post_low > post_high || in_low > in_high) return null;
        TreeNode root = new TreeNode(postorder[post_high]);
        for (int i = in_low; i <= in_high; i++)
        {
            if (inorder[i] == postorder[post_high])
            {
                root.left = reBuild_in_post(inorder, in_low, i - 1, postorder, post_low, post_low + i - in_low - 1);
                root.right = reBuild_in_post(inorder, i + 1, in_high, postorder, post_low + i - in_low, post_high - 1);
            }
        }
        root.height = Math.max(TreeNode.hei(root.left), TreeNode.hei(root.right)) + 1;
        return root;
    }
    public static void traverse_post(TreeNode root)//后序遍历
    {
        if (root == null) return;
        traverse_post(root.left);
        traverse_post(root.right);
        tra_postval[index_post++] = root.val;
    }
    public static void traverse_in(TreeNode root)//中序遍历
    {
        if (root == null) return;
        traverse_in(root.left);
        tra_inval[index_in++] = root.val;
        traverse_in(root.right);
    }
    public static void traverse_pre(TreeNode root)//先序遍历
    {
        if (root == null) return;
        tra_preval[index_pre++] = root.val;
        traverse_pre(root.left);
        traverse_pre(root.right);
    }
    public static void traverse_level(TreeNode root)//层序遍历
    {
    	ArrayDeque<TreeNode> queue =new ArrayDeque<TreeNode>();
    	queue.add(root);
        while(!queue.isEmpty()) {
        	TreeNode tmp=queue.poll();
        	tra_levelval[index_level++]=tmp.val;
        	if(tmp.left!=null)
        		queue.offer(tmp.left);
        	if(tmp.right!=null)
        		queue.offer(tmp.right);
        }
    }
    public static void traverse_depth(TreeNode root) {
    	/*Stack<TreeNode> stack=new Stack<TreeNode>();
    	stack.push(root);
    	while(!stack.isEmpty()) {
    		TreeNode tmp=stack.pop();
        	if(tmp.right!=null)
        		stack.push(tmp.right);
    		if(tmp.left!=null)
    			stack.push(tmp.left);
        	tra_depthval[index_depth++]=tmp.val;
    	}*/
    	
    	if(root==null)return;
    	tra_depthval[index_depth++]=root.val;
    	traverse_depth(root.left);
    	traverse_depth(root.right);
    }
}
