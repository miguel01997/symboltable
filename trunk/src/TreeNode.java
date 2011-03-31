import java.util.LinkedList;

public class TreeNode {
	EntityBlock recentEntity;
	LinkedList<TreeNode> childList;
	TreeNode	parentNode;
	int nestingLevel;
	
	public TreeNode() {
		this.recentEntity	= null;
		this.childList	= new LinkedList<TreeNode>();
		this.parentNode	= null;
		this.nestingLevel	= 0;
	}
	
	public void addToChildList(TreeNode child) {
		childList.add(child);
	}
	
	public int getNestingLevel() {
		return nestingLevel;
	}

	public void setNestingLevel(int nestingLevel) {
		this.nestingLevel = nestingLevel;
	}

	public EntityBlock getRecentEntity() {
		return recentEntity;
	}

	public void setRecentEntity(EntityBlock recentEntity) {
		EntityBlock temp	= this.recentEntity;
		this.recentEntity	= recentEntity;
		recentEntity.setSameScope(temp);
	}
	
	public TreeNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(TreeNode parentNode) {
		this.parentNode = parentNode;
	}
}