package jp.bcat;
import java.io.*;

public class ListCommand implements CLICommand {
	BookCatalog catalog;

	public ListCommand(BookCatalog catalog) {
		this.catalog = catalog;
	}

	public void process(BufferedReader in, PrintWriter out) throws IOException {
		Book result[] = catalog.getBooks();
		out.println("合計" + result.length + "項目");
		BookWriter w = new BookWriter(out, " ");
		for (int i = 0; i < result.length; i++) {
			out.println("[" + (i+1) + "]:");
			out.println(" 図書ID: " + result[i].getBookId());
			w.write(result[i]);
			out.println();
		}
	}

	public static void main(String args[]) {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(System.out), true);
			BookCatalog catalog = new BookCatalog();
			ListCommand command = new ListCommand(catalog);
			command.process(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
