package ui;

import java.util.Scanner;
import model.Control;
import model.Product;
import model.Residuos;


public class Reciclemos {
	
	private static Scanner reader;
	private static Control reciclar;
	
	/** main
	*<p> desc:</p> This method is responsible for interacting with the user 
	*by presenting in the options menu and according to the option chosen to ask 
	*the necessary requirements. at the same time, it makes the necessary validations
	*and according to this it throws an error or takes it to the corresponding method
	*
	*@return this method has no return
	*/
	public static void main (String []args){
		
		int netx = 0;
		int option = 0;

		String nameR;
		String tips; 
		String result;
		
		Product productTemp;
		
		init();
		do{
			System.out.println ("What operation do you want to perform? \n" + "1 add a product \n" + "2 add a residue \n" + "3 search for information on a waste \n" +
			"4 Show a list of registered products \n" +  "5 Determine if a biodegradable or recyclable waste is usable.\n"+
			"6 List the waste of a product for order of harmful \n" +"7 generate report of residues");
			option= reader.nextInt();
			
			switch (option){
				case 1:	
					productTemp = CreateProduct();
					do{
						netx = 0;
						createResidual(productTemp);
						System.out.println ("Do you want to add other residual? \n"+ "1 yes\n"+ "2 no");
						netx= reader.nextInt();
					}
					while(netx==1);
					break;
				 
				case 2: 
					productTemp = null;
					boolean isValidOption = false;
					String optionAddResidual;
					do {
						System.out.println("Type the index to select the product o type + to add a new product");
						System.out.println(listProducts());
						System.out.println("+ Add new Product");
						optionAddResidual = reader.next();
						
						try {
							if (optionAddResidual.equals("+")){
								productTemp = CreateProduct();
								isValidOption = true;
							}
							else {
								productTemp = reciclar.getProducts().get(Integer.parseInt(optionAddResidual));
								isValidOption = true;
							}
						}
						catch(Exception e){
							isValidOption = false;
						}
					}
					while(isValidOption==false);

					do{
						createResidual(productTemp);
						System.out.println ("Do you want to add other residual? \n"+ "1 yes\n"+ "2 no");
						netx= reader.nextInt();
					}
					while(netx==1);
					break;				  
				case 3:
				  
					System.out.println ("you want to search by:\n"+ "1 name \n" + "2 id");
					option= reader.nextInt();

					if(option==1){
						System.out.println (reciclar.printProducts());
						System.out.println ("Enter the name of the residue in lowercase");
						nameR= reader.next();
						
						result=reciclar.findResidueByName(nameR);
						System.out.println (result);
					}
					else if (option==2){
						System.out.println (reciclar.printProducts());
						System.out.println ("Enter the id of the product");
						tips= reader.next();
						
						result=reciclar.findResidueByIdP(tips);
						System.out.println(result);
						
					}
					else {
						System.out.println("incorrect value");
					}
					break;
				 
				case 4: 
					System.out.println(listProducts());
					break;
				 
				case 5:
					System.out.println ("Enter the name of the residue");
						tips= reader.next();
					
					System.out.println (reciclar.itsUsable(tips));
					
					break;
					
				case 6:
					productTemp = null;
					isValidOption = false;
					String optionProductSelected;
					do {
						System.out.println("Type the index to select the product ");
						System.out.println(listProducts());
						optionProductSelected = reader.next();
						
						try {

							productTemp = reciclar.getProducts().get(Integer.parseInt(optionProductSelected));
							isValidOption = true;
						}
						catch(Exception e){
							isValidOption = false;
						}
					}
					while(isValidOption==false);
				
					System.out.println(productTemp.getResiduesOrderedByHarmful());
					
					break;
				case 7:
					System.out.println (reciclar.printResidualsByCategory());
					break;
			}
		
		
		System.out.println ("you want to return to the menu \n"+ "1 yes\n"+ "2 no");
		netx= reader.nextInt();
		}
		while(netx==1);
	}
	
	/**CreateProduct
	*<p> desc:</p> This method asks for the information necessary 
	*to create a product
	*
	*@return this method return a Product type data
	*/
	private static Product CreateProduct()
	{
		Scanner reader= new Scanner (System.in);
		Product productAdd;
		
		String nameP = "";
		String idP="";
		String descriptionP="";
		
		System.out.println ("Enter the product name in lowercase letters");
		nameP= reader.next();
		 
		System.out.println ("Enter the product id in lowercase letters");
		idP= reader.next();
		 
		System.out.println ("Enter the product description in lowercase letters");
		descriptionP= reader.next();
		
		productAdd = reciclar.CreateProduct(nameP, descriptionP, idP);
		
		return productAdd;
	}
	
	/**createResidual
	*<p> desc:</p> This method asks for the information necessary 
	*to create a residue
	*
	*@return this method return a Product type data
	*/
	private static Residuos createResidual(Product product)
	{
		Scanner reader= new Scanner (System.in);
		String id;
		String name;
		char origin;
		String color;
		double decotime;
		int typeR;
		char composting;
		String tips;
		String descriptionR;
		char type;
		Residuos residualAdd = null;
		
		System.out.println ("what type of residue will you enter \n"+ "1 Biodegradable \n" + "2 Inert \n"+ "3 Recyclable" );
		typeR = reader.nextInt();

		System.out.println ("Enter the residue name in lowercase letters");
		name= reader.next();

		System.out.println ("Enter the residue id in lowercase letters");
		id= reader.next();

		System.out.println ("Enter the residue origin in one letter and capital letter \n" + "INDUSTRIALS = 'I' \n"+ "HOME = 'H'\n" +
							"MUNICIPALITIES= 'M'\n" + "BUILDING = 'B' \n" + "HOSPITALS = 'O'");
		origin= reader.next().charAt(0);

		System.out.println ("Enter the residue color in lowercase letters");
		color= reader.next();

		System.out.println ("Enter the residue descomposition time in days");
		decotime= reader.nextDouble();

		if(typeR== 1){				 
			System.out.println ("the residue is suitable for composting in one letter and capital letter \n" + "YES= 'Y'\n" + "NO= 'N'");
			composting= reader.next().charAt(0);	

			residualAdd = reciclar.CreateResidual(product, id, name, origin, color, decotime, composting);
		}
		else if (typeR == 2){
			System.out.println ("Enter tips for using these in industries and home");
			tips= reader.next();
			residualAdd = reciclar.CreateResidual(product, id, name, origin, color, decotime, tips);
		}
		else if (typeR==3){
			System.out.println ("what kind of waste is in one letter and capital letter \n" + "PAPER = 'P' \n" + "PAPERBOARDE= 'B'\n" + "GLASS= 'G'\n"+ "PLASTIC= 'S'");
			type = reader.next().charAt(0);

			System.out.println ("enter the description of the residue");
			descriptionR= reader.next();
			residualAdd = reciclar.CreateResidual(product, id, name, origin, color, decotime, type, descriptionR);
		}
		else{
		  System.out.println ("error, incorrect value");
		}
		
		return residualAdd;
	}
	
	/** listProducts
	*<p> desc:</p> This method is used to call a method 
	*that prints control class information
	*
	*@return this method return String type data
	*/
	private static String listProducts()
	{
		return reciclar.printProducts();
	}
	
	/** init
	*<p> desc:</p> This method contains the 
	*pre-determined angels to be used in tests
	*
	*@return this method has no return
	*/
	private static void init(){
		
		reader = new Scanner(System.in);
		reciclar = new Control();
		
		
		Product productTemp;
		String nameP= "banano";
		String idP= "b205";
		String descriptionP="fruit, high in potacio consumed in homes";
		productTemp = reciclar.CreateProduct(nameP, descriptionP, idP);
		
		String name= "banana peel";
		String id= "bp89";
		String color="green";
		double decotime= 8;
		char origin= 'H';
		char composting= 'S';
		
		reciclar.CreateResidual(productTemp, id, name, origin, color, decotime, composting);
		
		nameP= "notebook";
		idP= "n289";
		descriptionP="stationery, used by children and young people to take notes";
		reciclar.CreateProduct(nameP, descriptionP, idP);
		
		nameP= "bottle";
		idP= "n289";
		descriptionP="It is used to package liquid drinks in different companies";
		productTemp = reciclar.CreateProduct(nameP, descriptionP, idP);
		
		name= "botella plastica";
		id= "pp45";
		color="blue";
		decotime= 54;
		origin= 'H';
		char type= 'S';
		String description="piece of recycled plastic to create other products";
		reciclar.CreateResidual(productTemp, id, name, origin, color, decotime, type, description);
		
		name= "tapa plastica";
		id= "pp45";
		color="blue";
		decotime= 50;
		origin= 'H';
		type= 'S';
		description="tapa plastica";
		reciclar.CreateResidual(productTemp, id, name, origin, color, decotime, type, description);
		
		name= "etiqueta";
		id= "e358";
		color="white";
		decotime= 80;
		origin= 'H';
		type= 'S';
		description="etiqueta de producto";
		reciclar.CreateResidual(productTemp, id, name, origin, color, decotime, type, description);
		
		name= "etiqueta";
		id= "et45";
		color="blue";
		decotime= 70;
		origin= 'H';
		type= 'S';
		description="etiqueta";
		reciclar.CreateResidual(productTemp, id, name, origin, color, decotime, type, description);
	}
}