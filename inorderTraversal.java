package leetcode;

import java.util.*;

//定义树结构
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		this.val = x;
	}
}

public class inorderTraversal {
	/*递归方法*/
	ArrayList<Integer> result = new ArrayList<Integer>();

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root != null)
			Xutil(root);
		return result;
	}

	private void Xutil(TreeNode root) {
		// 递归左节点
		if (root.left != null)
			Xutil(root.left);
		result.add(root.val);
		if (root.right != null)
			Xutil(root.right);
	}
	
	/*非递归需要借助栈中转*/
	public List<Integer> inorderTraversal1(TreeNode root) {
		
		ArrayList<Integer> ast = new ArrayList<Integer>();
		if (root == null)
			return ast;
		//定义中转栈
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode p = root;
		while(!st.empty() || root!=null){
			//把左子树放到栈中去
			if(root!=null){
				st.push(p);
				p = p.left;	
			}else{
				TreeNode t = st.pop();
				ast.add(t.val);
				p = p.right;
			}
		}
		return ast;

	}
}
