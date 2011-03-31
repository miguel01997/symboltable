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


class EntityBlock {
    NameBlock name;
    EntityKind kind;
    int nestingLevel;
    EntityBlock sameName;
    EntityBlock sameScope;
    
    public EntityBlock() {
    	super();
    	this.name	= null;
    	this.kind	= null;
    	this.nestingLevel	= 0;
    	this.sameName	= null;
    	this.sameScope	= null;
    }
    
    public EntityBlock(NameBlock name, EntityKind kind, int nestingLevel) {
    	super();
    	this.name	= name;
    	this.kind	= kind;
    	this.nestingLevel	= nestingLevel;
    	this.sameName	= null;
    	this.sameScope	= null;
    }

	public NameBlock getName() {
		return name;
	}

	public void setName(NameBlock name) {
		this.name = name;
	}

	public EntityKind getKind() {
		return kind;
	}

	public void setKind(EntityKind kind) {
		this.kind = kind;
	}

	public int getNestingLevel() {
		return nestingLevel;
	}

	public void setNestingLevel(int nestingLevel) {
		this.nestingLevel = nestingLevel;
	}

	public EntityBlock getSameName() {
		return sameName;
	}

	public void setSameName(EntityBlock sameName) {
		this.sameName = sameName;
	}

	public EntityBlock getSameScope() {
		return sameScope;
	}

	public void setSameScope(EntityBlock sameScope) {
		this.sameScope = sameScope;
	}
}
