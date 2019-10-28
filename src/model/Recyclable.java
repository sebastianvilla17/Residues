package model;

public class Recyclable extends Residuos{
	
	private char type;
	private String description= "";
	static final char PAPER = 'P';
	static final char PAPERBOARDE= 'B';
	static final char GLASS= 'G';
	static final char PLASTIC= 'S';
	
	/** Recyclable
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Recyclable (String id, String name, char origin, String color, double decotime, char type, String description){
		
		super(id,  name, origin,  color,  decotime);
		this.type = type;
		this.description = description;
		harmful();
		harmful= (harmful- (harmful* 0.02));
	}
	
	/** getType
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data char
	*/
	public char getType (){
		
		return type;
	}
	
	/** getDescription
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data String
	*/
	public String getDescription (){
		
		return description;
	}
	
	/** PrintResidue
	*<p> desc:</p> This method collects all the information (attributes)
	*of the class and prepares them to print them in a single variable
	*
	*@return this method returns a type data String whit the all information
	*/
	public String PrintResidue(){
		
		String infoR;
		
		infoR= super.PrintResidue()+ " Type:" + type + " Description:" + description;
		
		return infoR;
		
	}
}