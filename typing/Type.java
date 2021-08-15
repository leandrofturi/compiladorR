package typing;

// Enumeração dos tipos primitivos mapeados.
// https://cran.r-project.org/doc/manuals/r-release/R-lang.html
public enum Type {
	//"NULL"	NULL
	NULL_TYPE {
		public String toString() {
            return "NULL";
        }
	},

	//"symbol"	a variable name

	//"pairlist"	a pairlist object (mainly internal)

	//"closure"	a function

	//"environment"	an environment

	//"promise"	an object used to implement lazy evaluation

	//"language"	an R language construct

	//"special"	an internal function that does not evaluate its arguments

	//"builtin"	an internal function that evaluates its arguments

	//"logical"	a vector containing logical values
	LOGICAL_TYPE {
		public String toString() {
            return "logical";
        }
	},

	//"integer"	a vector containing integer values
	INTEGER_TYPE {
		public String toString() {
            return "integer";
        }
	},

	//"double"	a vector containing real values
	DOUBLE_TYPE {
		public String toString() {
            return "double";
        }
	},

	//"complex"	a vector containing complex values
	COMPLEX_TYPE {
		public String toString() {
            return "complex";
        }
	},

	//"character"	a vector containing character values
	CHARACTER_TYPE {
		public String toString() {
            return "character";
        }
	},

	//"expression"	an expression object

	//"list"	a list
	LIST_TYPE {
		public String toString() {
            return "list";
        }
	},

	//"externalptr"	an external pointer object

	//"weakref"	a weak reference object

	//"raw"	a vector containing bytes

	//"S4"	an S4 object which is not a simple object

	// Identificadores de variáveis.
	ID_TYPE {
		public String toString() {
            return "id";
        }
	},

	// Indica um erro de tipos.
	NO_TYPE {
		public String toString() {
            return "no_type";
        }
	};

}