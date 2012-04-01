package jp.bcat;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddCommand implements CLICommand {
	protected BookCatalog catalog;

	public AddCommand(BookCatalog catalog) {
		this.catalog = catalog;
	}
	
	public void process(BufferedReader in, PrintWriter out) throws IOException {
		Book book = new Book();
		out.println("図書の情報を入力してください。"
				+ "*印は入力必須項目");
		out.print("タイトル*: ");
		out.flush();
		book.setTitle(in.readLine());
		out.print("著者*: ");
		out.flush();
		book.setAuthor(in.readLine());
		out.print("訳者: ");
		out.flush();
		book.setTranslator(in.readLine());
		out.print("出版社*: ");
		out.flush();
		book.setPublisher(in.readLine());
		out.print("出版年月日*(例:2003-04-05): ");
		out.flush();
		book.setPublicationDate(in.readLine());
		out.print("ISBN(例:ISBN1-2345-6789-X): ");
		out.flush();
		book.setCode(in.readLine());
		out.print("備考: ");
		out.flush();
		book.setMemo(in.readLine());
		out.print("キーワード: ");
		out.flush();
		book.setKeyword(in.readLine());
		out.print("登録者名*: ");
		out.flush();
		book.setDataCreator(in.readLine());
		String now = new SimpleDateFormat("yyyy-MM-dd")
			.format(new Date());
		book.setDataCreatedDate(now);
		new BookWriter(out, "+ ").write(book);
		out.print("この内容で登録しますか？(y/n)[y]: ");
		out.flush();
		if ("n".equals(in.readLine()))
			return;
		catalog.addBook(book);
		out.println("登録しました。");
	}

	public static void main(String args[]) {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(
					new OutputStreamWriter(System.out), true);
			BookCatalog catalog = new BookCatalog();
			AddCommand command = new AddCommand(catalog);
			command.process(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
