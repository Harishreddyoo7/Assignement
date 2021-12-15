package bts;

	import java.util.*;
	import java.io.*;
	
	class RootNode
	{
		int data;
		RootNode left, right;
		public RootNode(int x)
		{
			data = x;
			left = right = null;
		}
		public boolean isLeaf()
		{
			return (left == null && right == null);
		}
	}

	class LeafSimilarTrees{
		public static boolean isSame(RootNode root1, RootNode root2){
			Stack<RootNode> s1 = new Stack<RootNode>();
			Stack<RootNode> s2 = new Stack<RootNode>();

			s1.push(root1);
			s2.push(root2);

			while (!s1.empty() || !s2.empty())
			{
				if (s1.empty() || s2.empty())
					return false;

				RootNode temp1 = s1.pop();
				while (temp1 != null && !temp1.isLeaf())
				{
					if (temp1.right != null)
						s1.push(temp1.right);
					if (temp1.left != null)
						s1.push(temp1.left);
					temp1 = s1.pop();
				}
				RootNode temp2 = s2.pop();
				while (temp2 != null && !temp2.isLeaf())
				{
					if (temp2.right != null)
						s2.push(temp2.right);
					if (temp2.left != null)
						s2.push(temp2.left);
					temp2 = s2.pop();
				}
				if (temp1 == null && temp2 != null)
					return false;
				if (temp1 != null && temp2 == null)
					return false;

				if (temp1 != null && temp2 != null)
				{
					if (temp1.data != temp2.data)
						return false;
				}
			}
			return true;
		}
		public static void main(String[] args)
		{
			RootNode root1 = new RootNode(1);
			root1.left = new RootNode(2);
			root1.right = new RootNode(3);
			root1.left.left = new RootNode(4);
			root1.right.left = new RootNode(6);
			root1.right.right = new RootNode(7);

			RootNode root2 = new RootNode(0);
			root2.left = new RootNode(1);
			root2.right = new RootNode(5);
			root2.left.right = new RootNode(4);
			root2.right.left = new RootNode(6);
			root2.right.right = new RootNode(7);

			if (isSame(root1, root2))
				System.out.println("true");
			else
				System.out.println("false");
		}
	}

