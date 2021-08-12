package tables;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public final class VarTable {

	// No mundo real isto certamente deveria ser um hash...
	// Implementação da classe não é exatamente Javanesca porque
	// tentei deixar o mais parecido possível com a original em C.
	private List<Entry> table = new ArrayList<Entry>(); 

	public int lookupVar(String s) {
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).name.equals(s)) {
				return i;
			}
		}
		return -1;
	}
	
	public int addVar(String s, int line) {
		Entry entry = new Entry(s, line);
		int idxAdded = table.size();
		table.add(entry);
		return idxAdded;
	}
	
	public String getName(int i) {
		return table.get(i).name;
	}
	
	public int getLine(int i) {
		return table.get(i).line;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("Variables table:\n");
		for (int i = 0; i < table.size(); i++) {
			f.format("Entry %d -- name: %s, line: %d\n", i,
	                 getName(i), getLine(i));
		}
		f.close();
		return sb.toString();
	}
	
	private final class Entry {
		String name;
		int line;
		
		Entry(String name, int line) {
			this.name = name;
			this.line = line;
		}
	}
}
