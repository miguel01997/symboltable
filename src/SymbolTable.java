import java.util.Stack;


class SymbolTable
{
	Stack<EntityBlock> scopeStack;
	NameTable nameTable;
	
    public SymbolTable()
    {
    	super();
    	this.scopeStack	= new Stack<EntityBlock>();
    	this.nameTable	= new NameTable();
    }

    public EntityBlock lookup(String id, EntityKind kind, Integer scope)
    {
        EntityBlock entityBlock = null;
        int currentScope;
        int otherScope;
        
        NameBlock nameBlock	= this.nameTable.name2nameBlock(id);
        entityBlock	= nameBlock.getEntity();
        currentScope = entityBlock.getNestingLevel();
        
        while (entityBlock != null) {
        	if (entityBlock.getKind() == kind )
        		scope	= 1;
        		return entityBlock;
        	}
        }

        return entityBlock;
    }
    
    public EntityBlock insert(String id, EntityKind kind)
    {
        EntityBlock entityBlock = null;

        return entityBlock;
    }

    public void enterBlock()
    {
    }

    public void leaveBlock()
    {
    }
}
