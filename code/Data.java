package code;

import java.util.Formatter;
import java.util.ArrayList;


public final class Data {

    public String label;
    public String directive;
    public ArrayList<String> data;

	public Data(String label, String directive, ArrayList<String> data) {
		this.label = label;
		this.directive = directive;
		this.data = data;
	}

    public Data(String label, String directive, String data) {
		this.label = label;
		this.directive = directive;
        ArrayList<String> datum = new ArrayList<String>();
        datum.add(data);
		this.data = datum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("%s: %s", this.label, this.directive);
        f.format(" %s", this.data.get(0));
		for (int i = 1; i < this.data.size(); i++) {
            f.format(", %s", this.data.get(i));
        }
		f.close();
		return sb.toString();
	}

}
