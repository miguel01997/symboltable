
class EntityBlock
{
    NameBlock name;
    EntityKind kind;
    int nestingLevel;
    EntityBlock sameName;
    EntityBlock sameScope;
    
    public EntityBlock()
    {
    	super();
    	this.name	= null;
    	this.kind	= null;
    	this.nestingLevel	= 0;
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
}