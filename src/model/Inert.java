package model;

public class Inert extends Residuos{
	
	private String tips = "";
	
	/** Inert
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Inert (String id, String name, char origin, String color, double decotime, String tips){
		
		super(id,  name, origin,  color,  decotime);
		this.tips = tips;
		harmful();
	}
	
	/** getTips
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data String
	*/
	public String getTips (){
		
		return tips;
	}
	
	/** PrintResidue
	*<p> desc:</p> This method collects all the information (attributes)
	*of the class and prepares them to print them in a single variable
	*
	*@return this method returns a type data String whit the all information
	*/
	public String PrintResidue(){
		
		String infoR;
		
		infoR= super.PrintResidue()+ " Tips:" + tips;
		
		return infoR;
		
	}
}