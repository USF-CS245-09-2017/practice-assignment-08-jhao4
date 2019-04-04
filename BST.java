
public class BST<T extends Comparable<T>>
{
	private class Node //create the node class
	{
		private T data;
		private Node left;
		private Node right;

		public Node (T i)
		{
			this.data = i; //sets the data of the node
			this.left = null; //sets the right value as null first
			this.right = null; //sets the left value as null first 
		} //node

	} //class node

	private Node root = null; //sets the root as null before the functions are called

	public void print()
	{
		print(root); //puts the root of the tree as the first parameter
	} //print

	public void print(Node cur)
	{
		if(cur != null)
		{
			print(cur.left); //moves to the most left value which is the smallest
			System.out.println(cur.data); //prints the value
			print(cur.right); //then moves to the most right value which is the largest value
		} //if

	} //print

	protected void delete(T i)
	{
		root = delete(i, root); //overrides the delete function so we can call it recursively
	}

	protected Node delete(T i, Node cur) //calls itself until it find the node
	{
		Node nodee = new Node(i); //creates a new node
		if(cur != null)
		{
			if(i.compareTo(cur.data) < 0)
			{
				cur.left = delete(i, cur.left); //recursively moves the items up
			} //if

			else if(i.compareTo(cur.data) > 0) //recursively moves the items up
			{
				cur.right = delete(i, cur.right);
			} //else if

			else
			{
				if(cur.left == null)
				{
					return cur.right; //if left is null, return current right
				} //if

				else if(cur.right == null)
				{
					return cur.left; //if right is null, return current left
				} //else if

				cur.data = findMin(cur.right).data;
				cur.right = delete(cur.data, cur.right);
			} //else

		} //if

		return null;

	} //delete

	public Node findMin(Node cur) //finds the smallest value
	{
		Node min = root; //looks at the root first 
		while(root.left != null) //moves left until you can't move left anymore
		{
			min = root.left; 
		} //while
		return min; //returns the smallest value
	} //min

	public boolean find(T i)
	{
		return find(i, root); //overrides to find the certain value
	} //find

	public boolean find(T i, Node cur)
	{
		if(cur != null) //while the current node doesn't equal null
		{
			if(i.compareTo(cur.data) == 0) //if the item is equal to the node, return true
			{
				return true; 
			} //if

			else if(i.compareTo(cur.data) < 0) //if the item is smaller, go left
			{
				return find(i, cur.left);
			} //else if

			else if(i.compareTo(cur.data) > 0) //if the item is larger, go right
			{
				return find(i, cur.right);
			} //else if

		} //if

		return false;

	} //find


	public void insert (T i) //insert item into the tree
	{
		root = insert(i, root);
	} //insert

	public Node insert(T i, Node cur)
	{
		Node nodee = new Node(i); //creates a new node for the new item

		if(cur == null) //when found the empty spot, inserts the node
		{
			return nodee;
		} //if

		else if(i.compareTo(cur.data) < 0) //if the current data is too higher than the item trying to put in, go left
		{
			cur.left = insert(i, cur.left); 
		} //else if

		else if(i.compareTo(cur.data) > 0) //if the current data is lower than the item tryign to put in, go right
		{
			cur.right = insert(i, cur.right);
		} //else if

		return cur; //return the node putting in

	} //insert

} //public class BST









