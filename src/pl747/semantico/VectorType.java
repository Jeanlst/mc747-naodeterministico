package pl747.semantico;
import java.util.ArrayList;

import pl747.TreeNode;
import pl747.tabelaSimbolos.*;

/**
 * Representa um tipo vetor.
 */
public class VectorType extends Type {

	private String size;
	
	private Symbol symbType;

	private Type elementType;
	
	public VectorType(String size, TreeNode type) {
		super(null);
		this.size = size;
		this.elementType = (Type) type;
		this.type = (Type) type;
		//this.name = "vector";
	}
	

	/**
	 * Devolve o numero de elementos do vetor.
	 * @return tamanho do vetor (numero de elementos que pode ter)
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Devolve o tipo dos elementos do vetor.
	 * @return tipo dos elementos do vetor
	 */
	public Type getElementType() {
		return this.type;
	}

	@Override
	public String getName() {		
		return null; //"vector";
	}
	
	@Override
	public PrimTypeSymb getSymbType() 
	{
	      if(symbType == null) 
	      {
	          if(elementType != null)
				try 
	          	{
					elementType.check(new ArrayList<String>());
			        symbType = new VectorTypeSymb(Integer.parseInt(size),SymbolTable.getTypeAsSymbol(elementType));
				} catch (Exception e) 
				{
					e.printStackTrace();
				}

	      }
	      return (PrimTypeSymb)symbType;
	}

}
