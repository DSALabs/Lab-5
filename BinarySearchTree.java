package Lab5;

public class BinarySearchTree {
	public Node root;

	public BinarySearchTree(Comparable x) {
		root = new Node(x);
	}

	public Node insert(Node node, Comparable x) {
		if (node == null) {
			return node = new Node(x);
		}
		if (x.compareTo(node.element) < 0/*x < (Integer) node.element*/) {
			node.left = insert(node.left, x);
		} else {
			node.right = insert(node.right, x);
		}
		return node;
	}

	// inOrder Traversal
	public void inOrderTreeSort(Node node) {
		if (node != null) {
			inOrderTreeSort(node.left);
			System.out.println(((Integer) node.element).intValue() + ",");
			inOrderTreeSort(node.right);
		}
	}

	public void descOrderTreeSort(Node node) {
		if (node != null) {
			descOrderTreeSort(node.right);
			System.out.print(((Integer) node.element).intValue() + ",");
			descOrderTreeSort(node.left);
		}
	}

	class Node {
		public Object element;
		public Node left;
		public Node right;

		// Constructor
		public Node(Comparable theElement) {
			this(theElement, null, null);
		}

		public Node(Comparable theElement, Node lLink, Node rLink) {
			element = theElement;
			this.left = lLink;
			this.right = rLink;
		}
	}
}
