package bts;
	class Root {
		int data;
		Root left, right;

		Root(int item)
		{
			data = item;
			left = right = null;
		}
	}
	class PathSum {

		Root root;

		boolean hasPathSum(Root node, int sum)
		{
		boolean ans = false;
		int subSum = sum - node.data;
		if(subSum == 0 && node.left == null && node.right == null)
			return(ans = true);
		if(node.left != null)
			
			ans = ans || hasPathSum(node.left, subSum);	
		
		if(node.right != null)
			ans = ans || hasPathSum(node.right, subSum);
		return(ans);
		}
		public static void main(String args[])
		{
			int sum = 14;
			PathSum tree = new PathSum();
			tree.root = new Root(10);
			tree.root.left = new Root(8);
			tree.root.right = new Root(2);
			tree.root.left.left = new Root(3);
			tree.root.left.right = new Root(5);
			tree.root.right.left = new Root(2);

			if (tree.hasPathSum(tree.root, sum))
				System.out.println("true");
			else
				System.out.println("false");
		}
	}