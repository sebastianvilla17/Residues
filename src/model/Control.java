package model;

import java.util.ArrayList;


public class Control{
	
	ArrayList<Product> Products;
	
	/** Control
	*<p> desc:</p> This method serves to assign a value to
	*the attributes of the class
	*
	*@return this method has no return
	*/
	public Control(){		
		this.Products = new ArrayList<Product>();		
	}
	
	/** getProducts
	*<p> desc:</p> This method allows to obtain private data
	*
	*@return this method returns a type data Products
	*/
	public ArrayList<Product> getProducts(){
		return Products;
	}
	
	/** CreateProduct
	*<p> desc:</p> This method is responsible for taking the data entered 
	*by the user and creating an object to add it to the corresponding list
	*
	*@param alphabetic type attributes must be in lower case
	*@return this method returns a type data Product
	*/
	public Product CreateProduct(String nameP, String descriptionP, String idP)
	{
		Product productAdd;
		productAdd = new Product(nameP, descriptionP, idP);
		Products.add(productAdd);
		
		return productAdd;
	}
	
	/** CreateResidual
	*<p> desc:</p> This method is responsible for taking the data entered 
	*by the user and creating an object to add it to the corresponding list
	*
	*@param alphabetic type attributes must be in lower case
	*@return this method returns a type data Product
	*/
	public Residuos CreateResidual(Product product, String id, String name, char origin, String color, double decotime, char composting)
	{
		Residuos residuoAdd;
		residuoAdd = new Biodegradable(id, name, origin, color, decotime, composting);
		product.Residuo.add(residuoAdd);
		
		return residuoAdd;
	}
	
	/** CreateResidual
	*<p> desc:</p> This method is responsible for taking the data entered 
	*by the user and creating an object to add it to the corresponding list
	*
	*@param alphabetic type attributes must be in lower case
	*@return this method returns a type data Product
	*/
	public Residuos CreateResidual(Product product, String id, String name, char origin, String color, double decotime, String tips)
	{
		Residuos residuoAdd;
		residuoAdd = new Inert(id, name, origin, color, decotime, tips);
		product.Residuo.add(residuoAdd);
		
		return residuoAdd;
	}
	
	/** CreateResidual
	*<p> desc:</p> This method is responsible for taking the data entered 
	*by the user and creating an object to add it to the corresponding list
	*
	*@param alphabetic type attributes must be in lower case
	*@return this method returns a type data Product
	*/
	public Residuos CreateResidual(Product product, String id, String name, char origin, String color, double decotime, char type, String description)
	{
		Residuos residuoAdd;
		residuoAdd = new Recyclable(id, name, origin, color, decotime, type, description);
		product.Residuo.add(residuoAdd);
		
		return residuoAdd;
	}
	
	/** printProducts
	*<p> desc:</p> this method prints all the products registered in the list
	*
	*@return this method returns a type data String
	*/
	public String printProducts(){
		String Nproduct="";
		for(int i=0; i< Products.size(); i++){
			Nproduct+="\n"+i+" - PRODUCT:" +Products.get(i).getNameP() + "  ID:"+ Products.get(i).getIdP();
		}
		return Nproduct;
	}
	
	/** printResiduals
	*<p> desc:</p> this method prints all information of  the residues
	*registered in the list
	*
	*@return this method returns a type data String
	*/
	public String printResiduals(){
		
		String infProduct="";
		for(int i=0; i< Products.size(); i++){			
			Products.get(i).printResiduals();
		}
		
		return infProduct;
	}
	
	/** printResidualsByCategory
	*<p> desc:</p> This method uses a series of cycles to generate a list 
	*sorted by categories of waste registered in the list
	*
	*@return this method returns a type data String whit the all information
	*/
	public String printResidualsByCategory(){
		
		String BioResidues="\nBiodegradable\n";
		String InertResidues="\nInert\n";
		String RecycResidues="\nRecyclable\n";
		
		for(int i=0; i< Products.size(); i++){			
			for(int r=0; r < Products.get(i).Residuo.size(); r++){
				
				if (Products.get(i).Residuo.get(r) instanceof Biodegradable){
					BioResidues += Products.get(i).Residuo.get(r).PrintResidue()+ 
							"(PRODUCT:" +Products.get(i).getNameP() + "  ID:"+ Products.get(i).getIdP()+")\n";
				}
				else if (Products.get(i).Residuo.get(r) instanceof Inert){
					InertResidues += Products.get(i).Residuo.get(r).PrintResidue()+ 
							"(PRODUCT:" +Products.get(i).getNameP() + "  ID:"+ Products.get(i).getIdP()+")\n";
				}
				else if (Products.get(i).Residuo.get(r) instanceof Recyclable){
					RecycResidues += Products.get(i).Residuo.get(r).PrintResidue()+ 
							"(PRODUCT:" +Products.get(i).getNameP() + "  ID:"+ Products.get(i).getIdP()+")\n";
				}
			}
		}
		
		return BioResidues+InertResidues+RecycResidues;
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
		for(int i=0; i< Products.size(); i++){
			infoProduct = Products.get(i).findResidueByName(nameR);
			if( infoProduct.equals("")){
				
				infoProduct= "not found";
		}
		}
		return infoProduct;

	}
	
	/** findResidueByIdP
	*<p> desc:</p> This method is a search engine that uses a cycle 
	*to cycle through the list and take the necessary information.
	*
	*@param the name you enter must be lowercase
	*@return This method returns a message whit the all information, 
	*String type data
	*/
	public String findResidueByIdP(String idP){
		
		String infoProduct = "";
		for(int i=0; i< Products.size(); i++){
			if (Products.get(i).getIdP().equals(idP)) {
				infoProduct = Products.get(i).printResiduals();
			}
		}
		
		return infoProduct;
	}
	
	/** itsUsable
	*<p> desc:</p> This method is responsible for scrolling through 
	*the list of products looking for a residue and the method is 
	*called to determine if it is usable or not.
	*
	*@param the name you enter must be lowercase
	*@return This method returns a message whit the all information, 
	*String type data
	*/
	public String itsUsable(String nameR){
		String infoProduct = "";
		for(int i=0; i< Products.size(); i++){
			infoProduct = Products.get(i).usable(nameR);
			
		}
		return infoProduct;

	}
}