package Sums;
import java.util.ArrayList;

class Head {

	int data;
	Head left, right;

	Head(int d)
	{
		data = d;
		left = right = null;
	}
}

class TwoSumPair {
	Head root;
	TwoSumPair()
	{
		root = null;
	}
	void inorder()
	{
		inorderUtil(this.root);
	}
	void inorderUtil(Head node)
	{
		if (node == null)
			return;

		inorderUtil(node.left);
		System.out.print(node.data + " ");
		inorderUtil(node.right);
	}
	void insert(int key)
	{
		root = insertRec(root, key);
	}
	Head insertRec(Head root, int data)
	{
		if (root == null) {
			root = new Head(data);
			return root;
		}
		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}
	ArrayList<Integer> treeToList(Head node, ArrayList<Integer>list)
	{
		if (node == null)
			return list;

		treeToList(node.left, list);
		list.add(node.data);
		treeToList(node.right, list);

		return list;
	}
	boolean isPairPresent(Head node, int target)
	{
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = treeToList(node, a1);

		int start = 0;

		int end = a2.size() - 1;

		while (start < end) {

			if (a2.get(start) + a2.get(end) == target) 
			{
				System.out.println("true");
				return true;
			}

			if (a2.get(start) + a2.get(end) > target)
			{
				end--;
			}

			if (a2.get(start) + a2.get(end) < target)
			{
				start++;
			}
		}

		System.out.println("false");
		return false;
	}
	public static void main(String[] args)
	{
		TwoSumPair tree = new TwoSumPair();
		
		tree.insert(15);
		tree.insert(10);
		tree.insert(20);
		tree.insert(8);
		tree.insert(12);
		tree.insert(16);
		tree.insert(25);

		tree.isPairPresent(tree.root, 33);
	}
}


	