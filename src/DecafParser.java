import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DecafParser {

	/**
	 * @param args
	 */
	private SymbolTable symTable;
	
	public DecafParser() {
		this.symTable	= new SymbolTable();
	}
	
	public SymbolTable getSymTable() {
		return this.symTable;
	}
	
	public void callFunction(String line) {
		String[] splitString	= line.split(" ");
		
		if (splitString.length > 0) {
			if (splitString [0].equalsIgnoreCase("lookup")) {
				Integer scope = -1;
				this.symTable.lookup(splitString [1], EntityKind.getKind(splitString [2].trim()), scope);
				System.out.println("Lookup returned: " + scope);
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
			DecafParser testObj	= new DecafParser();
			
			try {
				BufferedReader reader	= new BufferedReader(new FileReader(args [0]));
				
				while (reader.ready()) {
					testObj.callFunction(reader.readLine());
					System.out.println("");
				}
				
				if (testObj.getSymTable().getStatus()) {
					System.out.println("Parsing Completed.");
				}
				else {
					System.out.println("Input File Error. Inconsistent Symbol Tree encountered.");
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