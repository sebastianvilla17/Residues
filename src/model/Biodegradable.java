package model;

public class Biodegradable extends Residuos{
	
	private char composting;
	static final char SUITABLE = 'S';
	static final char NOT_SUITABLE= 'N';
	
	/** Biodegradable
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Biodegradable (String id, String name, char origin, String color, double decotime, char composting){
		
		super(id,  name, origin,  color,  decotime);
		this.composting = composting;
		harmful();
		if(getComposting() == 'S'){
			harmful= (harmful -(harmful*0.01));
		}
	}
	
	/** getComposting
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data char
	*/
	public char getComposting (){
		
		return composting;
	}
	
	/** PrintResidue
	*<p> desc:</p> This method collects all the information (attributes)
	*of the class and prepares them to print them in a single variable
	*
	*@return this method returns a type data String whit the all information
	*/
	public String PrintResidue(){
		
		String infoR;
		
		infoR= super.PrintResidue()+ " Composting:" +composting;
		
		return infoR;
		
	}
	

}