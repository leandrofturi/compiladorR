package tables;

import java.util.ArrayList;
import java.util.Formatter;

@SuppressWarnings("serial")
public final class StrTable extends ArrayList<String>{

    public int addStr(String s) {
		s = s.substring(0, s.length() - 1) + "\\n\"";
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals(s)) {
				return i;
			}
		}
		super.add(s);
		return super.size()-1;
	}

	public String getName(int i) {
		return super.get(i);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("Strings table:\n");
		for (int i = 0; i < this.size(); i++) {
			f.format("Entry %d -- %s\n", i, this.get(i));
		}
		f.close();
		return sb.toString();
	}

}
