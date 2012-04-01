package jp.bcat;
import java.io.PrintWriter;

public class BookWriter {
	protected PrintWriter out;
	protected String indent;

	public BookWriter(PrintWriter out, String indent) {
		this.out = out;
		this.indent = indent;
	}

	public void write(Book book) {
		out.println(indent + "タイトル: " + book.getTitle());
		out.println(indent + "著者: " + book.getAuthor());
		out.println(indent + "訳者: "
					+ book.getTranslator());
		out.println(indent + "出版社: "
					+ book.getPublisher());
		out.println(indent + "出版年月日: "
					+ book.getPublicationDate());
		out.println(indent + "ISBN/ISSN: "
					+ book.getCode());
		out.println(indent + "備考: " + book.getMemo());
		out.println(indent + "キーワード: "
					+ book.getKeyword());
		out.println(indent + "登録者: "
					+ book.getDataCreator());
		out.println(indent + "登録日: "
					+ book.getDataCreatedDate());
	}
}
