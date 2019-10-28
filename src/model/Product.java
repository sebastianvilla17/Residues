package model;

import java.util.ArrayList;

public class Product {
	
	private String nameP= ""; 
	private String descriptionP= "";
	private String idP = "";
	String infoProduct="";
	 double harmful;
	 String usable="";
	
	ArrayList<Residuos> Residuo;
	
	/** Product
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Product(String nameP, String descriptionP, String idP){
		
		this.nameP = nameP;
		this.descriptionP = descriptionP;
		this.idP= idP;
		this.Residuo= new ArrayList<Residuos>();
	}
	
	/** getNameP
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data String
	*/
	public String getNameP (){
		return nameP;
	}
	
	/** getDescription
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data descriptionP
	*/
	public String getDescriptionP (){
		return descriptionP;
	}
	
	/** getIdP
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data String
	*/
	public String getIdP (){
		return idP;
	}
	
	/** getResiduo
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data Residuo
	*/
	public ArrayList<Residuos> getResiduo() {
		return Residuo;
	}
	
	/** infoSearch
	*<p> desc:</p> This method collects all the information (attributes)
	*of the class and prepares them to print them in a single variable
	*
	*@return this method returns a type data String whit the all information
	*/
	public String infoSearch (){
		
		String info;
		
		info= ("name Product" + nameP + "Id product" +idP + "description Product"+ descriptionP);
		
		return info;
		
	}
	
	/** usable
	*<p> desc:</p> This method uses cycles and conditionals to determine
	*whether a waste is usable or not.
	*
	*@param the name you enter must be lowercase
	*@return This method returns a message saying whether or not they 
	*are usable
	*/
	public  String usable(String name){
		
		for(int i=0; i<Residuo.size(); i++){
			
			if(Residuo.get(i).getName().equals (name)){
				
				if(Residuo.get(i) instanceof Biodegradable){
					
					if(Residuo.get(i).getDecotime()< 365 && ((Biodegradable)Residuo.get(i)).getComposting()=='S'){
						
						usable= "if it is usable";
					}
					
					else{
						usable= "Not it is usable";
					}
				} 
				
				else if(Residuo.get(i) instanceof Recyclable){
					
					if(((Recyclable)Residuo.get(i)).getDescription().equals("")){
						
						usable= "Not it is usable";
					}
					else {
						usable="If it is usable";
					}
				}
			}
		} 
		
		return usable;
	}
	
	/** findResidueByName
	*<p> desc:</p> This method is a search engine that uses a cycle 
	*to cycle through the list and take the necessary information.
	*
	*@param the name you enter must be lowercase
	*@return This method returns a message whit the all information, 
	*String type data
	*/
	public String findResidueByName(String nameR){
		String infoProduct = "";
		
		for(int r=0; r < Residuo.size(); r++){
			if(Residuo.get(r).getName().equals(nameR)){
				infoProduct= Residuo.get(r).PrintResidue();
			}
		}
		
		if(infoProduct.equals("")){infoProduct = "Not found";}
		
		return infoProduct;
	}
	
	public String printResiduals(){
		
		String infProduct="";
				
		for(int r=0; r < Residuo.size(); r++){
			infProduct += Residuo.get(r).PrintResidue()+ 
							"(PRODUCT:" +getNameP() + "  ID:"+ getIdP()+")\n";
		}

		return infProduct;
	}
	
	/** getResiduesOrderedByHarmful
	*<p> desc:</p> This method orders waste from least to greatest 
	*according to how harmful the products can be
	*
	*@return this method returns the ordered list, 
	*String type data
	*/
	public String getResiduesOrderedByHarmful(){
		
		Residuos auxiliar;
		ArrayList<Residuos> arreglo = Residuo;

		String infProduct="";
		
		infProduct= "\nANTES\n";
		
		for(int r=0; r < arreglo.size(); r++){
			infProduct += arreglo.get(r).PrintResidue()+"\n";
		}
		
		
		for(int i = 0; i < arreglo.size()-1; i++)
		{
			for(int j = 0;j < arreglo.size()-1;j++)
			{
				if(arreglo.get(j).harmful < arreglo.get(j+1).harmful)
				{
					auxiliar = arreglo.get(j+1);
					arreglo.set(j+1, arreglo.get(j));
					arreglo.set(j, auxiliar);
				}   
			}
		}
		
		infProduct+= "\nDESPUES\n";
		
		for(int r=0; r < arreglo.size(); r++){
			infProduct += arreglo.get(r).PrintResidue()+"\n";
		}

		return infProduct;
	}	
}