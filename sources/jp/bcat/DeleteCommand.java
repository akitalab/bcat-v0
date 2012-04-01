package jp.bcat;
import java.io.*;

public class DeleteCommand implements CLICommand {
	protected BookCatalog catalog;

	public DeleteCommand(BookCatalog catalog) {
		this.catalog = catalog;
	}
	
	public void process(BufferedReader in, PrintWriter out) throws IOException {
		out.print("削除する図書ID: ");
		out.flush();
		String no = in.readLine();
		Book book = catalog.getBook(no);
		if (book == null) {
			out.println("該当する図書がありません。");
			return;
		}
		new BookWriter(out, "- ").write(book);
		out.print("この図書情報を削除しますか？(y/n)[n]: ");
		out.flush();
		if (! "y".equals(in.readLine()))
			return;
		catalog.deleteBook(no);
		out.println("削除しました。");
	}

	public static void main(String args[]) {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(System.out), true);
			BookCatalog catalog = new BookCatalog();
			DeleteCommand command = new DeleteCommand(catalog);
			command.process(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
