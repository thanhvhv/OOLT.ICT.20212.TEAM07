package Tree;




public interface Tree {
	
	public void insertNode(int parent,int child);
	public void traverse();
	public int deleteNode(int value);
	public boolean search(int value);
	public void update(int current,int value);

}
