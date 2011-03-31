public class ScopeTree {
	TreeNode	rootScope;
	TreeNode 	curScope;
	
	public ScopeTree() {
		this.rootScope	= new TreeNode();
		this.curScope	= null;
	}

	public TreeNode getRootScope() {
		return rootScope;
	}
	
	public TreeNode getCurScope() {
		return curScope;
	}
	
	public void setCurScope(TreeNode curScope) {
		this.curScope = curScope;
	}
}
