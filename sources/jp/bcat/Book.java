package jp.bcat;
import java.io.Serializable;

public class Book implements Serializable {
	protected String bookId;
	protected String title;
	protected String author;
	protected String translator;
	protected String publisher;
	protected String publicationDate;
	protected String code;
	protected String status;
	protected String keyword;
	protected String memo;
	protected String dataCreator;
	protected String dataCreatedDate;

	public String getBookId() {
		return bookId;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getTranslator() {
		return translator;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public String getCode() {
		return code;
	}
	public String getStatus() {
		return status;
	}
	public String getKeyword() {
		return keyword;
	}
	public String getMemo() {
		return memo;
	}
	public String getDataCreator() {
		return dataCreator;
	}
	public String getDataCreatedDate() {
		return dataCreatedDate;
	}
	public void setBookId(String value) {
		bookId = value;
	}
	public void setTitle(String value) {
		title = value;
	}
	public void setAuthor(String value) {
		author = value;
	}
	public void setTranslator(String value) {
		translator = value;
	}
	public void setPublisher(String value) {
		publisher = value;
	}
	public void setPublicationDate(String value) {
		publicationDate = value;
	}
	public void setCode(String value) {
		code = value;
	}
	public void setStatus(String value) {
		status = value;
	}
	public void setKeyword(String value) {
		keyword = value;
	}
	public void setMemo(String value) {
		memo = value;
	}
	public void setDataCreator(String value) {
		dataCreator = value;
	}
	public void setDataCreatedDate(String value) {
		dataCreatedDate = value;
	}
}