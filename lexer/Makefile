# Diretório para aonde vão os arquivos gerados.
GEN_PATH=gen

run:
	antlr4 R.g4 RFilter.g4 -o $(GEN_PATH)
	cp *.R $(GEN_PATH) && cp *.java $(GEN_PATH)
	javac $(GEN_PATH)/*.java
	cd $(GEN_PATH) && java TestR $(FILE)
	cd ..

clean:
	@rm -rf $(GEN_PATH)
