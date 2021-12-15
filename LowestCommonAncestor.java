package Sums;


	class HeadNode
	{
		int data;
		HeadNode left, right;

		HeadNode(int item)
		{
			data = item;
			left = right = null;
		}
	}

	class LowestCommonAncestor
	{
		HeadNode root;
		
		HeadNode lca(HeadNode node, int n1, int n2)
		{
			if (node == null)
				return null;
			if (node.data > n1 && node.data > n2)
				return lca(node.left, n1, n2);
			if (node.data < n1 && node.data < n2)
				return lca(node.right, n1, n2);

			return node;
		}
		public static void main(String args[])
		{
			LowestCommonAncestor tree = new LowestCommonAncestor();
			tree.root = new HeadNode(20);
			tree.root.left = new HeadNode(8);
			tree.root.right = new HeadNode(22);
			tree.root.left.left = new HeadNode(4);
			tree.root.left.right = new HeadNode(12);
			tree.root.left.right.left = new HeadNode(10);
			tree.root.left.right.right = new HeadNode(14);

			int n1 = 10, n2 = 14;
			HeadNode t = tree.lca(tree.root, n1, n2);
			System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

			n1 = 14;
			n2 = 8;
			t = tree.lca(tree.root, n1, n2);
			System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

			n1 = 10;
			n2 = 22;
			t = tree.lca(tree.root, n1, n2);
			System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		}
	}



