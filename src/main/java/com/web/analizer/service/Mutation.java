package com.web.analizer.service;

public class Mutation {
	   private String adn;
	   private int[] indexLeft = {12,6,0,1,2};
	   private int[] indexRigth = {3,4,5,11,17};
	   private int FactorVertical = 6;
	   private int FactorLeft = 7;
	   private int FactorRigth = 5;
	   private int founded = 0;
	   private Boolean result = false;
	   
	   public Mutation(String adn) {
	      this.adn = adn;
	      SetResult(hasMutation());
	      System.out.println("Times with mutation: "+this.founded);
	    }
	    
	    public String AddPipes(){
	        String origin = this.adn;
	        String nuevo = "";
	        for(int i=0;i < origin.length();i++){
	            nuevo+= origin.charAt(i);
	            if(i == 5 || i == 11 || i == 17 || i == 23 || i == 29 || i==35){
	                nuevo+= '|';
	            }
	        }
	        return nuevo;
	    }

	   public Boolean hasMutation(){
	       String Mixadn = MixSecuences();
	       int concurrence = 0;
	       int found = 0;
	       Boolean result = false;
	       for(int i = 0;i < Mixadn.length()-1;i++){
	           if(Mixadn.charAt(i) != '|'){
	                    if(Mixadn.charAt(i) == Mixadn.charAt(i+1)){
	                      concurrence++;
	                    }
	                  else{
	                      concurrence = 0;
	                  }
	                 
	                  if(concurrence == 3){
	                      found++;
	                      result = true;
	                      concurrence = 0;
	                  } 
	                  
	              }
	              else{
	                  concurrence = 0;
	              }
	             
	       }
	       this.founded = found;
	       return result;
	       
	   }
	   
	   public String MixSecuences(){
	       // Lineal
	       //Computed by AddPipes() method
	       // Result of Vertical transformation
	       String VerticalToLineal = TransformVerticalToLineal(this.FactorVertical);
	       // Result of Diagonal Left transformation
	       String DiagonalLeftToLineal = TransformDiagonalToLineal(this.indexLeft,this.FactorLeft);
	       // Result of Diagonal Rigth transformation
	       String DiagonalRigthToLineal = TransformDiagonalToLineal(this.indexRigth,this.FactorRigth);
	       //Mix all string to allow full OneByOne analisis
	       return AddPipes()+VerticalToLineal+DiagonalLeftToLineal+DiagonalRigthToLineal;
	       
	   }
	   
	    //Transform vertical secuences into lineal string to allow OneByOne anlisis
	    //Parameter Factor: to know difference between vertical numbers
	    public String TransformVerticalToLineal(int Factor){
	        String adn = this.adn;
	        int factor = Factor;
	        String fila = "";
	       
	       for(int column = 0;column<=5;column++){
	           
	           int inicio = column;
	           for(int row=1; row<=6; row++){
	               fila+=adn.charAt(inicio);
	               inicio+=factor;
	            }
	            fila+="|";
	       }
	       return fila;
	    }
	    //Transform diagonal secuences into lineal string to allow OnebyOne analisis
	    //Parameter indexs: to start from Rigth or Left
	    //Parameter Factor: to know difference between diagonal numbers
	    public String TransformDiagonalToLineal(int[] Indexs, int Factor){
	        String adn = this.adn;
	        int factor = Factor;
	        String fila = "";
	       
	        int[] indexs = Indexs;
	        int[] limit = {4,5,6,5,4};
	       
	       for(int i = 0;i<=4;i++){
	           
	           int inicio = indexs[i];
	           for(int row=0; row < limit[i]; row++){
	           fila+=adn.charAt(inicio);
	               inicio+=factor;
	            }
	            fila+="|";
	       }
	       return fila;
	    }
	//Getters and Setters
	public void SetResult(Boolean r) {
		this.result = r;
	}
	public Boolean GetResult() {
		return this.result;
	}
	    
	}