import java.util.HashMap;

class NameTable {
	HashMap<String, NameBlock> hashMap;
	
	public NameTable() {
		super();
		hashMap	= new HashMap<String, NameBlock>();
	}
	
    public NameBlock name2nameBlock(String id) {        
        if (hashMap.containsKey(id) == true) {
        	return hashMap.get(id);
        }
        else {
        	NameBlock nameBlock = new NameBlock(id);
        	hashMap.put(id, nameBlock);
        	
        	return nameBlock;
        }
    }
    
    public boolean exits(String id) {
    	if (hashMap.containsKey(id)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}