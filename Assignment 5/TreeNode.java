/**
 * Class that is used to create a tree in MorseCodeTree
 * 
 * @author Saad Aulakh
 *
 * @param <T>
 */
public class TreeNode<T> {
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	protected T data;

	/**
	 * Constructor which creates a treeNode using data that is passed into it
	 * 
	 * @param data data of the treeNode
	 */
	public TreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	/**
	 * Copy constructor
	 * 
	 * @param treeNode node that will be used to set a node
	 */
	public TreeNode(TreeNode<T> treeNode) {
		this.left = treeNode.left;
		this.right = treeNode.right;
		this.data = treeNode.data;
	}


	/**
	 * Returns the data of the treeNode
	 * 
	 * @return data data of the treeNode
	 */
	public T getData() {
		return data;
	}
}
