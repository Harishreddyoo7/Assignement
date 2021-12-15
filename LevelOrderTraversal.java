package bts;

	class newnode {
		int data;
		newnode left, right;
		public newnode(int item)
		{
			data = item;
			left = right = null;
		}
	}

	class LevelOrderTraversal {
		newnode root;

		public LevelOrderTraversal() {
			root = null;
			}

		void printLevelOrder()
		{
			int h = height(root);
			int i;
			for (i = 1; i <= h; i++)
				printCurrentLevel(root, i);
		}
		int height(newnode root)
		{
			if (root == null)
				return 0;
			else {
				int lheight = height(root.left);
				int rheight = height(root.right);

				if (lheight > rheight)
					return (lheight + 1);
				else
					return (rheight + 1);
			}
		}
		void printCurrentLevel(newnode root, int level)
		{
			if (root == null)
				return;
			if (level == 1)
				System.out.print(root.data + " ");
			else if (level > 1) {
				printCurrentLevel(root.left, level - 1);
				printCurrentLevel(root.right, level - 1);
			}
		}

		public static void main(String args[])
		{
			LevelOrderTraversal tree = new LevelOrderTraversal();
			tree.root = new newnode(1);
			tree.root.left = new newnode(2);
			tree.root.right = new newnode(3);
			tree.root.left.left = new newnode(4);
			tree.root.left.right = new newnode(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
		}
	}
