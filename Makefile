JAVA=java
JAVAC=javac

ROOT=/mnt/c/Users/leand/OneDrive/Documentos/Ufes/compiladores/compiladorR

ANTLR_PATH=$(ROOT)/tools/antlr-4.9.2-complete.jar
CLASS_PATH_OPTION=-cp .:$(ANTLR_PATH)

# Comandos como descritos na página do ANTLR.
ANTLR4=$(JAVA) -jar $(ANTLR_PATH)
GRUN=$(JAVA) $(CLASS_PATH_OPTION) org.antlr.v4.gui.TestRig

# Diretório para aonde vão os arquivos gerados pelo ANTLR.
GEN_PATH=parser

# Diretório aonde está a classe com a função main.
MAIN_PATH=checker

# Diretório para os arquivos .class
BIN_PATH=bin

# Diretório para os casos de teste
DATA=$(ROOT)/tests
IN=$(DATA)/in

all: antlr javac
	@echo "Done."

antlr: R.g4 RFilter.g4
	$(ANTLR4) -no-listener -visitor -o $(GEN_PATH) R.g4 RFilter.g4

# Compila todos os subdiretórios e joga todos os .class em BIN_PATH pra organizar.
javac:
	rm -r $(BIN_PATH)
	mkdir $(BIN_PATH)
	$(JAVAC) $(CLASS_PATH_OPTION) -d $(BIN_PATH) */*.java

run:
	$(JAVA) $(CLASS_PATH_OPTION):$(BIN_PATH) $(MAIN_PATH)/Main $(FILE)

runall:
	-for FILE in $(IN)/*.ezl; do \
	 	echo -e "\nRunning $${FILE}" && \
	 	$(JAVA) $(CLASS_PATH_OPTION):$(BIN_PATH) $(MAIN_PATH)/Main $${FILE}; \
	done;

clean:
	@rm -rf $(GEN_PATH) $(BIN_PATH)
