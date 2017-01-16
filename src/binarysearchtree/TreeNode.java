package binarysearchtree;

public class TreeNode {

	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(){}
	
	public TreeNode(Integer data){
		this.data =  data;
	}
	
	@Override
	public String toString(){
		return String.valueOf(this.data);
	}
}
