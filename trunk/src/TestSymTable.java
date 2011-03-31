import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class TestSymTable {

	/**
	 * @param args
	 */
	private SymbolTable symTable;
	
	public TestSymTable() {
		this.symTable	= new SymbolTable();
	}
	
	public void callFunction(String line) {
		String[] splitString	= line.split(" ");
		
		if (splitString.length > 0) {
			if (splitString [0].equalsIgnoreCase("lookup")) {
				this.symTable.lookup(splitString [1], EntityKind.getKind(splitString [2].trim()), new Integer("1"));
			}
			else if (splitString [0].equalsIgnoreCase("insert")) {
				this.symTable.insert(splitString [1], EntityKind.getKind(splitString [2].trim()));
			}
			else if (splitString [0].equalsIgnoreCase("enterBlock")) {
				this.symTable.enterBlock();
			}
			else if (splitString [0].equalsIgnoreCase("leaveBlock")) {
				this.symTable.leaveBlock();
			}
		}
	}
	
	public static void main(String[] args) {		
		try {
			TestSymTable testObj	= new TestSymTable();
			
			try {
				BufferedReader reader	= new BufferedReader(new FileReader(args [0]));
				
				while (reader.ready()) {
					testObj.callFunction(reader.readLine());
					System.out.println("");
				}
			}
			catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}