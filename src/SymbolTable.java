import java.awt.Cursor;
import java.util.Vector;


class SymbolTable {
	ScopeTree	scopeTree;
	NameTable nameTable;
	
    public SymbolTable() {
    	super();
    	this.scopeTree	= new ScopeTree();
    	this.nameTable	= new NameTable();
    }

    public EntityBlock lookup(String id, EntityKind kind, Integer scope) {
        if (this.nameTable.exits(id)) {
        	NameBlock name = this.nameTable.name2nameBlock(id);
        	
        	if (name != null) {
        		EntityBlock latestEntity	= name.getEntity();
        		
        		while (latestEntity != null) {
        			if (latestEntity.getKind() != kind) {
        				latestEntity	= latestEntity.getSameName();
        			}
        			else {
        				break;
        			}
        		}
        		
        		if (latestEntity != null) {
        			
        			if (latestEntity.getNestingLevel() == this.scopeTree.getCurScope().getNestingLevel()) {
        				scope	= 1;
        				System.out.println(id + " with the type " + EntityKind.getKindStr(kind) + " exists and is in current scope");
        				this.print();
        			}
        			else {
        				scope	= 0;
        				System.out.println(id + " with the type " + EntityKind.getKindStr(kind) + " exists and is in other scope");
        				this.print();
        			}
        			
        			return latestEntity;
        		}
        	}
        }
        
        System.out.println(id + " with the type " + EntityKind.getKindStr(kind) + " does not exist");
        this.print();
        return null;
    }
    
    public EntityBlock insert(String id, EntityKind kind) {
    	NameBlock name	= this.nameTable.name2nameBlock(id);
    	
        EntityBlock newEntityBlock = new EntityBlock(name, kind, this.scopeTree.getCurScope().getNestingLevel());
        EntityBlock tempEntityBlock	= name.getEntity();
        newEntityBlock.setSameName(tempEntityBlock);
        name.setEntity(newEntityBlock);
        
        tempEntityBlock	= this.scopeTree.getCurScope().getRecentEntity();
        newEntityBlock.setSameScope(tempEntityBlock);
        this.scopeTree.getCurScope().setRecentEntity(newEntityBlock);
        
        System.out.println(id + " with the type " + EntityKind.getKindStr(kind) + " have inserted succefully");
        this.print();
        return newEntityBlock;
    }

    public void enterBlock() {
    	int nestingLevel	= 0;
    	
    	if (this.scopeTree.getCurScope().getNestingLevel() != -1) {
    		//Add new TreeNode
    		TreeNode newScope	= new TreeNode();
    		nestingLevel	= this.scopeTree.getCurScope().getNestingLevel() + 1;
    		newScope.setParentNode(this.scopeTree.getCurScope());
    		this.scopeTree.setCurScope(newScope);
    	}

    	this.scopeTree.getCurScope().setNestingLevel(nestingLevel);
    	
    	System.out.println("Enter block " + nestingLevel);
    	this.print();
    }

    public void leaveBlock() {
    	EntityBlock entity	= this.scopeTree.getCurScope().getRecentEntity();
    	int nestingLevel	= this.scopeTree.getCurScope().getNestingLevel();
    	EntityBlock	scopeEntity	= null;
    	
    	while (entity != null) {
    		scopeEntity	= entity;
    		NameBlock name	= scopeEntity.getName();
    		
    		while (scopeEntity != null && scopeEntity.getNestingLevel() == nestingLevel) {
    			scopeEntity	= scopeEntity.getSameName();
    		}
    		
    		name.setEntity(scopeEntity);
    		entity	= entity.getSameScope();
    	}
    	
    	this.scopeTree.setCurScope(this.scopeTree.getCurScope().getParentNode());
    	
    	System.out.println("Leave block " + nestingLevel);
    	this.print();
    }
    
    public void print() {
    	System.out.println("Symbol Table");
    	System.out.println("Name Kind  level");
    	
    	TreeNode	node	= this.scopeTree.getCurScope();
    	
    	while (node != null) {
    		EntityBlock entity	= node.getRecentEntity();
    		
    		while (entity != null) {
    			System.out.println(entity.getName().getId() + " " + EntityKind.getKindStr(entity.getKind()) + " " + entity.getNestingLevel());
    			entity	= entity.getSameScope();
    		}
    		node	= node.getParentNode();
    	}
    }
}