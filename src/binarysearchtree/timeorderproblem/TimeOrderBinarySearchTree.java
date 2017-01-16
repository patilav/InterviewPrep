package binarysearchtree.timeorderproblem;

public class TimeOrderBinarySearchTree {

	public static int countOrders(TimeOrderNode root, int low, int high){
		if (root == null)
			return 0;

		if (root.time < high && root.time >= low)
			return root.orderCount + countOrders(root.left, low, high)
					+ countOrders(root.right, low, high);

		else if (root.time < low)
			return countOrders(root.right, low, high);
		else
			return countOrders(root.left, low, high);
	}
	
	public static void main(String args[]){
		TimeOrderNode root = new TimeOrderNode();
		root.time = 1200;
		root.orderCount = 5;
		
		TimeOrderNode eleven = new TimeOrderNode();
		eleven.time = 1100;
		eleven.orderCount = 5;
		
		TimeOrderNode ten = new TimeOrderNode();
		ten.time = 1000;
		ten.orderCount = 5;
		
		TimeOrderNode eleven15 = new TimeOrderNode();
		eleven15.time = 1115;
		eleven15.orderCount = 5;
		
		TimeOrderNode thirteen1 = new TimeOrderNode();
		thirteen1.time = 1301;
		thirteen1.orderCount = 1;
		
		TimeOrderNode thirteen5 = new TimeOrderNode();
		thirteen5.time = 1305;
		thirteen5.orderCount = 20;
		
		TimeOrderNode thirteen15 = new TimeOrderNode();
		thirteen15.time = 1315;
		thirteen15.orderCount = 15;
		
		root.left = eleven;
		root.right = thirteen1;
		
		eleven.left = ten;
		eleven.right = eleven15;
		
		thirteen1.left = thirteen5;
		thirteen1.right = thirteen15;
		
		int total = countOrders(root, 1300, 1400);
		System.out.println(total);
	}
}
