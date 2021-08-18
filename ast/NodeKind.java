package ast;

// Enumeração dos tipos de nós de uma AST.
public enum NodeKind {
    PROG_NODE {
		public String toString() {
            return "prog";
        }
	},
    VAR_DECL_NODE {
		public String toString() {
            return "var-decl";
        }
	},
    VAR_USE_NODE {
		public String toString() {
            return "var-use";
        }
	},
	EXPRSUBSUBLIST_NODE {
		public String toString() {
            return "[[";
        }
	},
	EXPRSUBLIST_NODE {
		public String toString() {
            return "[";
        }
	},
	VALUEPKG_NODE {
		public String toString() {
            return "::|:::";
        }
	},
	EXTRACT_NODE {
		public String toString() {
            return "$|@";
        }
	},
	ASSOCRIGHT_NODE {
		public String toString() {
            return "assoc=right";
        }
	},
	SIGN_NODE {
		public String toString() {
            return "sign";
        }
	},
	NAMESPACE_NODE {
		public String toString() {
            return ":";
        }
	},
	WRAPPEDIN_NODE {
		public String toString() {
            return "%";
        }
	},
	TIMES_NODE {
		public String toString() {
            return "*|/";
        }
	},
	SUM_NODE {
		public String toString() {
            return "+|-";
        }
	},
	EQUALITY_NODE {
		public String toString() {
            return ">|>=|<|<=|==|!=";
        }
	},
	NOT_NODE {
		public String toString() {
            return "!";
        }
	},
    AND_NODE {
		public String toString() {
            return "&|&&";
        }
	},
	OR_NODE {
		public String toString() {
            return "||||";
        }
	},
	NOTFORMULA_NODE {
		public String toString() {
            return "~";
        }
	},
	FORMULA_NODE {
		public String toString() {
            return "~";
        }
	},
	ASSIGN_NODE {
		public String toString() {
            return "<-|<<-|=|->|->>|:=";
        }
	},
	DEFINE_NODE {
		public String toString() {
            return "define";
        }
	},
    CALL_NODE {
		public String toString() {
            return "call";
        }
	},
	COMPOUND_NODE {
		public String toString() {
            return "{";
        }
	},
	IF_NODE {
		public String toString() {
            return "if";
        }
	},
	IFELSE_NODE {
		public String toString() {
            return "if-else";
        }
	},
	FOR_NODE {
		public String toString() {
            return "for";
        }
	},
	WHILE_NODE {
		public String toString() {
            return "while";
        }
	},
	REPEAT_NODE {
		public String toString() {
            return "repeat";
        }
	},
	HELP_NODE {
		public String toString() {
            return "?";
        }
	},
	NEXT_NODE {
		public String toString() {
            return "next";
        }
	},
	BREAK_NODE {
		public String toString() {
            return "break";
        }
	},
	PAR_NODE {
		public String toString() {
            return "(";
        }
	},
	ID_NODE {
		public String toString() {
            return "id";
        }
	},
	NULL_VAL_NODE {
		public String toString() {
            return "NULL";
        }
	},
	LOGICAL_VAL_NODE {
		public String toString() {
            return "logical";
        }
	},
	INTEGER_VAL_NODE {
		public String toString() {
            return "integer";
        }
	},
	DOUBLE_VAL_NODE {
		public String toString() {
            return "double";
        }
	},
	COMPLEX_VAL_NODE {
		public String toString() {
            return "complex";
        }
	},
	CHARACTER_VAL_NODE {
		public String toString() {
            return "character";
        }
	},
	VARARG_NODE {
		public String toString() {
            return "...";
        }
	},
	POINT_NODE {
		public String toString() {
            return ".";
        }
	},
	EMPTY_NODE {
		public String toString() {
            return " ";
        }
	},
	LIST_VAL_NODE {
		public String toString() {
            return "list";
        }
	},
	SUBLIST_NODE {
		public String toString() {
            return "sublist";
        }
	},
	EXPRLIST_NODE {
		public String toString() {
            return "expr-list";
        }
	},
	FORMLIST_NODE {
		public String toString() {
            return "form-list";
        }
	},
	FORMASSIGN_NODE {
		public String toString() {
            return "form-assign";
        }
	},
	SUBEXPR_NODE {
		public String toString() {
            return "sub-expr";
        }
	},
	SUBASSIGNID_NODE {
		public String toString() {
            return "sub-assign-id";
        }
	},
	SUBASSIGNCHARACTER_NODE {
		public String toString() {
            return "sub-assign-character";
        }
	},
	SUBASSIGNNULL_NODE {
		public String toString() {
            return "sub-assign-null";
        }
	};


	public static boolean hasData(NodeKind kind) {
		switch(kind) {
	        case VAR_DECL_NODE:
	        case VAR_USE_NODE:
			case NULL_VAL_NODE:
			case LOGICAL_VAL_NODE:
			case INTEGER_VAL_NODE:
			case DOUBLE_VAL_NODE:
			case COMPLEX_VAL_NODE:
			case CHARACTER_VAL_NODE:
	            return true;
	        default:
	            return false;
		}
	}
}