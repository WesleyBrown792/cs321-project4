// driver class
public interface GeneBankCreateBTree {

}

// reads from given file and converts DNA to binary
public interface FileReader {

}

// wrapper for Scanner 
public interface ScannerWrapper {

	// constructor given location of file to read from
	public ScannerWrapper(String location);

	// checks cache for node with given line number first
	// if not there, then read from file
	public BTreeNode getNode(int lineNumber);

	// checks if node is full
	public boolean isFull(int lineNumber);

	// returns the next line
	public String nextLine();

	// closes Scanner
	public void close();
}

// wrapper for printWriter
public interface PrintWrapper {
	// splits the node given by the line number
	public void split(int lineNumber);

	// adds a new node to the end of the file
	public void addNode(BTreeNode node);

	// closes PrintWriter
	public void close();
}

// do in sprint 1
// parses file to node and vice versa
public interface Parser {
	// instantiates a ScannerWrapper and reads file into a BTreeNode object
	public static BTreeNode fileToNode(int lineNumber);

	// calls BTreeNode.toString
	public static String nodeToFile(BTreeNode node);

	// converts decimal long to String of binary
	// don't forget to add missing 0's in front
	public static String decimalToBinary(long dec);

	// converts String DNA to a decimal long
	public static long dnaToDecimal(String dna);
}

// do in sprint 1
// btree node object
public interface BTreeNode extends Comparable {
	int[] childPointers;	// stores line # of children
	int selfPointer;	// pointer to self line number 
	long[] values;	// stored DNA values in long form

	// returns values
	public long[] getValues();

	// returns child pointers as line number
	public int[] getChildren();

	// returns self pointer
	public int getSelfPointer();

	// compares value to another Node based on the first value stored (getValues[0])
	public int compareTo(BTreeNode node);

	// converts self to a String suitable for writing into the file
	public String toString();
}

// cache class to store nodes
public interface Cache {
	// already done
}