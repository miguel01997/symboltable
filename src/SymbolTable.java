import java.util.Vector;


class SymbolTable {
	Vector<EntityBlock> scopeStack;
	NameTable nameTable;
	
    public SymbolTable() {
    	super();
    	this.scopeStack	= new Vector<EntityBlock>();
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
        			EntityBlock topEntity	= this.scopeStack.lastElement();
        			
        			if (topEntity.getNestingLevel() == latestEntity.getNestingLevel()) {
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
        EntityBlock newEntityBlock = new EntityBlock(name, kind, this.scopeStack.lastElement().getNestingLevel());
        EntityBlock tempEntityBlock	= name.getEntity();
        
        newEntityBlock.setSameName(tempEntityBlock);
        name.setEntity(newEntityBlock);
        
        tempEntityBlock	= this.scopeStack.lastElement().getSameScope();
        newEntityBlock.setSameScope(tempEntityBlock);
        this.scopeStack.lastElement().setSameScope(newEntityBlock);
        
        System.out.println(id + " with the type " + EntityKind.getKindStr(kind) + " have inserted succefully");
        this.print();
        return newEntityBlock;
    }

    public void enterBlock() {
    	EntityBlock newEntityBlock	= new EntityBlock();
    	int nestingLevel	= 0;
    	
    	if (this.scopeStack.size() != 0) {
    		nestingLevel	= this.scopeStack.lastElement().getNestingLevel()+1;
    	}
    	
    	newEntityBlock.setNestingLevel(nestingLevel);
    	this.scopeStack.add(newEntityBlock);
    	
    	System.out.println("Enter block " + nestingLevel);
    	this.print();
    }

    public void leaveBlock() {
    	EntityBlock entity	= this.scopeStack.remove(this.scopeStack.size() - 1);
    	int nestingLevel	= entity.getNestingLevel();
    	EntityBlock	scopeEntity	= null;
    	entity	= entity.getSameScope();
    	
    	while (entity != null) {
    		scopeEntity	= entity;
    		NameBlock name	= scopeEntity.getName();
    		
    		while (scopeEntity != null && scopeEntity.getNestingLevel() == nestingLevel) {
    			scopeEntity	= scopeEntity.getSameName();
    		}
    		
    		name.setEntity(scopeEntity);
    		entity	= entity.getSameScope();
    	}
    	
    	System.out.println("Leave block " + nestingLevel);
    	this.print();
    }
    
    public void print() {
    	System.out.println("Symbol Table");
    	System.out.println("Name Kind  level");
    	
    	for (int index = this.scopeStack.size()-1; index >= 0; index--) {
    		EntityBlock entity	= this.scopeStack.get(index);
    		
    		entity	= entity.getSameScope();
    		
    		while (entity != null) {
    			System.out.println(entity.getName().getId() + " " + EntityKind.getKindStr(entity.getKind()) + " " + entity.getNestingLevel());
    			entity	= entity.getSameScope();
    		}
    	}
    }
}