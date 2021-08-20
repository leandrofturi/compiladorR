package typing;

import java.util.ArrayList;
import java.util.List;

import static ast.NodeKind.L2I_NODE;
import static ast.NodeKind.L2D_NODE;
import static ast.NodeKind.I2D_NODE;
import static ast.NodeKind.I2L_NODE;
import static ast.NodeKind.D2L_NODE;

import ast.AST;

public enum Conv {
	L2I,  // logical to integer
    L2D,  // logical to double
    I2D,  // integer to double
	I2L,  // integer to logical
    D2L,  // double to logical
    NONE; // No type conversion
    
	// Cria e retorna um novo nó de conversão da AST segundo o parâmetro 'conv' passado.
	// O parâmetro 'n' é o nó que será pendurado como filho do nó de conversão.
	// Caso a conversão indicada seja 'NONE', a função simplesmente retorna o próprio
	// nó passado como argumento.
	public static AST createConvNode(Conv conv, AST n) {
	    switch(conv) {
	        case L2I:  return AST.newSubtree(L2I_NODE, Type.INTEGER_TYPE, n);
	        case L2D:  return AST.newSubtree(L2D_NODE, Type.DOUBLE_TYPE, n);
	        case I2D:  return AST.newSubtree(I2D_NODE, Type.DOUBLE_TYPE, n);
			case I2L:  return AST.newSubtree(I2L_NODE, Type.LOGICAL_TYPE, n);
	        case D2L:  return AST.newSubtree(D2L_NODE, Type.LOGICAL_TYPE, n);
	        case NONE: return n;
	        default:
	            System.err.printf("INTERNAL ERROR: invalid conversion of types!\n");
	            System.exit(1);
	            return null;
	    }
	}
	
	// Classe que define as informações de unificação para os tipos em expressões.
    public static final class Unif {
    	
    	public final Type type; // Tipo unificado
		public final List<Conv> c = new ArrayList<>(); // Elementos
    	
		public Unif(Type type, List<Conv> args) {
			this.type = type;
			for(Conv a: args) c.add(a);
		}

		public Unif(Type type, Conv... args) {
			this.type = type;
			for(Conv a: args) c.add(a);
		}
		
	}
}
