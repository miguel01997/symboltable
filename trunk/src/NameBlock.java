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


class NameBlock {
    String id;
    EntityBlock entity;
    NameBlock next;
    
    public NameBlock(String id) {
		super();
		this.id = id;
		this.entity = null;
		this.next	= null;
	}
    
    public NameBlock(String id, EntityBlock entity) {
		super();
		this.id = id;
		this.entity = entity;
		this.next	= null;
	}

	public NameBlock(String id, EntityBlock entity, NameBlock next) {
		super();
    	this.id	= id;
    	this.entity	= entity;
    	this.next	= next;
    }
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EntityBlock getEntity() {
		return entity;
	}

	public void setEntity(EntityBlock entity) {
		this.entity = entity;
	}

	public NameBlock getNext() {
		return next;
	}
	
	public void setNext(NameBlock next) {
		this.next	= next;
	}
}
