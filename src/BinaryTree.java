import java.util.Stack;


public class BinaryTree {

	private class BSTNode{

	    int  key;
	    BSTNode left;
	    BSTNode right;

	       
	    public BSTNode(int key,BSTNode left,BSTNode right){

	         this.key= key;
	         this.left=left;
	         this.right=right;
	      }

	 }

    private BSTNode  mRoot;//根结点
	    
    public void insert(int key){
    	BSTNode newNode = new BSTNode(key,null,null);
    	//最终也要保证生成的根节点是整棵树的根，所以最后要把root return
    	mRoot = insert(mRoot,newNode);
    	
    }
	public BSTNode insert(BSTNode root,BSTNode newNode){
				
		if(root==null) root=newNode;
		
		if(newNode.key < root.key){
			root.left = insert(root.left,newNode);
		}else if(newNode.key > root.key){
			root.right = insert(root.right,newNode);
		}
		
		return root;
	}
    
	/*
	 * 后序遍历
	 * 维护一个visited标记
	 * 判断栈顶元素。
	 *    如果栈顶元素有右节点，并且不是刚刚被访问的节点，则将栈顶的右子树作为root，循环push
	 *    如果栈顶无右子树，或者右子树被访问过，输出栈顶元素，修改pre元素
	 *     
	 * */
	public void PostSort(){
		
		PostSort(mRoot);
		
	}
	
    public void PostSort(BSTNode root){
    	if(root==null)  return;
    	
    	Stack<BSTNode> s = new Stack<BSTNode>();
    	BSTNode pre =null;
    	
    	while(root!=null||!s.isEmpty()){
    		while(root!=null){
    			s.push(root);
    			root=root.left;
    		}
    		
    		if(s.peek().right!=null&&s.peek().right!=pre){
    			root = s.peek().right;
    		}else{
    			System.out.print(s.peek().key+" ");
    			pre = s.pop();
    		}
    	}
    }
	
	
    
    
    
	public static void main(String[] args) {
		
		int [] arr ={7,3,5,6,1,9,11};
		BinaryTree bt = new BinaryTree();
		
		for(int i=0;i<arr.length;i++){
			bt.insert(arr[i]);
		}
		
		bt.PostSort();

	}

}
