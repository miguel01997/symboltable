/** 
 * CSE 504: Compiler Design
 * Programming Assignment #3
 * Symbol Table
 *
 * By 
 *	Amitha Cheluvagopal
 *	ID# 107569253
 *	Email: amitha_c@yahoo.com
 *
 *	Naresh P Singh
 *	ID# 107669049
 *	Email: mail2naresh@gmail.com
 **/


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
