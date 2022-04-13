import java.util.ArrayList;

/**
 * Class that creates a binary tree using tree nodes
 * 
 * @author Saad Aulakh
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> rootNode;

	/**
	 * Constructor that calls on buildTree() which builds the tree
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * Returns the root node
	 * 
	 * @return rootNode - root node
	 */
	@Override
	public TreeNode<String> getRoot() {
		// TODO Auto-generated method stub
		return rootNode;
	}

	/**
	 * Sets the root node
	 * 
	 * @param newNode - node that rootNode will be set to
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		// TODO Auto-generated method stub
		rootNode = new TreeNode<String>(newNode);
	}

	/**
	 * Method that inserts a letter into a tree based on the morse code
	 * 
	 * @param code   - morse code
	 * @param letter - letter that will be placed into the tree
	 */
	@Override
	public void insert(String code, String letter) {
		// TODO Auto-generated method stub
		addNode(rootNode, code, letter);

	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code.
	 * 
	 * @param root   the root of the tree for this particular recursive instance of
	 *               addNode
	 * @param code   the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		// TODO Auto-generated method stub

		// keep calling this method until code is one character
		if (code.length() > 1) {
			if (code.charAt(0) == '-') {
				addNode(root.right, code.substring(1), letter);
			} else if (code.charAt(0) == '.') {
				addNode(root.left, code.substring(1), letter);
			}
		}
		// once code is one character, insert it into the tree
		else if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				root.left = new TreeNode<String>(letter);
			} else if (code.charAt(0) == '-') {

				root.right = new TreeNode<String>(letter);
			}
		}
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the
	 * recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		// TODO Auto-generated method stub
		String fetch = fetchNode(rootNode, code);
		return fetch;
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of
	 *             addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		// TODO Auto-generated method stub
		String str = "";
		// keep calling method until code is one character
		if (code.length() > 1) {
			if (code.charAt(0) == '-') {
				str = fetchNode(root.right, code.substring(1));
			} else if (code.charAt(0) == '.') {
				str = fetchNode(root.left, code.substring(1));
			}
		}
		// once code is one character, return right or left node based on what code is
		else {
			if (code.equals("-")) {
				return root.right.getData();
			} else if (code.equals(".")) {
				return root.left.getData();
			}
		}
		return str;
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T> into
	 * their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		// TODO Auto-generated method stub
		// root
		rootNode = new TreeNode<>("");
		// 1
		insert(".", "e");
		insert("-", "t");
		// 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		// 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");

		// 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR
	 * (Inorder) Traversal order Used for testing to make sure tree is built
	 * correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(rootNode, list);
		return list;
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an
	 * ArrayList<T> LNR (Inorder)
	 * 
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR
	 *             order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// TODO Auto-generated method stub
		if (!(root == null)) {
			if (root.left != null) {
				LNRoutputTraversal(root.left, list);
			}
			
			list.add(root.data);
			if (root.right != null) {
				LNRoutputTraversal(root.right, list);
			}
		}

		if (root == null) {
			return;
		}
	}
}
