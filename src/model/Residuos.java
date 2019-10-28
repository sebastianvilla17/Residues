package model;

public class Residuos{
	
	private String id;
	private String name;
	private char origin;
	private String color;
	private double decotime;
	public double harmful;
	static final char INDUSTRIALS = 'I';
	static final char HOME = 'H';
	static final char MUNICIPALITIES= 'M';
	static final char BUILDING = 'B';
	static final char HOSPITALS = 'O';
	
	/** Residuos
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Residuos(String id, String name, char origin, String color, double decotime){
		
		this.id= id;
		this.name= name;
		this.origin= origin;
		this.color = color;
		this.decotime = decotime;
	}
	
	/** getId
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data String
	*/
	public String getId (){
		
		return id;
	}
	
	/** getName
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data String
	*/
	public String getName (){
		
		return name;
	}
	
	/** getOrigin
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data char
	*/
	public char getOrigin (){
		
		return origin;
	}
	
	/** getColor
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data String
	*/
	public String getColor (){
		
		return color;
	}
	
	/** getDecotime
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data double
	*/
	public double getDecotime (){
		
		return decotime;
	}
	
	/** PrintResidue
	*<p> desc:</p> This method collects all the information (attributes)
	*of the class and prepares them to print them in a single variable
	*
	*@return this method returns a type data String whit the all information
	*/
	public String PrintResidue(){
		
		String infoR;
		
		infoR= "Name:" +name + " Origin:" + origin + " Color:" + color + " Descomposition time:" + decotime + " Id:" +id+ " Harmful:" +harmful;
		
		return infoR;
		
	}
	
/** harmful
	*<p> desc:</p> This method calculates the harmful effect of waste for 
	*the planet, through a series of conditionals to determine the value
	*
	*@return This method returns a double type value that refers to the 
	*harmful effect of the relapse
	*/
	public void harmful (){
		
		
				
		if(getOrigin()== 'I' ){
			
			harmful= (getDecotime()) * 0.10;
		}
		
		if(getOrigin()== 'H' ){
			
			harmful= (getDecotime()) * 0.05;
		}
		
		if(getOrigin()== 'B' ){
			
			harmful=( getDecotime()) * 0.08;
		}
		
		if(getOrigin()== 'M' ){
			
			harmful= (getDecotime()) * 0.12;
		}
		
		if(getOrigin()== 'O' ){
			
			harmful= (getDecotime()) * 0.15;
		}
	}
}