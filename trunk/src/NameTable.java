import java.util.HashMap;

class NameTable
{
	HashMap<String, NameBlock> hashMap;
	
	public NameTable()
	{
		super();
		hashMap	= new HashMap<String, NameBlock>();
	}
	
    public NameBlock name2nameBlock(String id)
    {        
        if (hashMap.containsKey(id) == true)
        {
        	NameBlock tempBlock	= hashMap.get(id);
        	
        	while (tempBlock.getNext() != null)
        	{
        		if (tempBlock.getId() == id)
        		{
        			return tempBlock;
        		}
        		
        		tempBlock	= tempBlock.getNext();
        	}
        	
        	NameBlock nameBlock	= new NameBlock(id);
        	
        	tempBlock.setNext(nameBlock);
        	return nameBlock;
        }
        else
        {
        	NameBlock nameBlock = new NameBlock(id);
        	
        	hashMap.put(id, nameBlock);
        	return nameBlock;
        }
    }
}