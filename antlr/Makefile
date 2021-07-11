# Diretório para aonde vão os arquivos gerados.
GEN_PATH=gen
IN=tests/in

run:
	antlr4 R.g4 RFilter.g4 -o $(GEN_PATH)
	cp $(FILE) $(GEN_PATH) && cp *.java $(GEN_PATH)
	javac $(GEN_PATH)/*.java
	cd $(GEN_PATH) && java TestR $(notdir $(FILE))
	cd ..

runall:
	@rm -rf $(GEN_PATH)/*
	antlr4 R.g4 RFilter.g4 -o $(GEN_PATH)
	cp $(IN)/*.R $(GEN_PATH) && cp *.java $(GEN_PATH)
	javac $(GEN_PATH)/*.java
	for FILE in $(shell cd $(GEN_PATH) && ls | grep '\.R$$'); do \
		echo "\nRunning $${FILE}" && \
		cd $(GEN_PATH) && java TestR $${FILE} && cd ..; \
	done

clean:
	@rm -rf $(GEN_PATH)
