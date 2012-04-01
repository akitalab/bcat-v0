package jp.bcat;
import junit.framework.TestCase;

public class BookCatalogTest extends TestCase {
	public BookCatalogTest(String arg0) {
		super(arg0);
	}
    
	public static void main(String[] args) {
		junit.textui.TestRunner.run(BookCatalogTest.class);
		//junit.swingui.TestRunner.run(BookCatalogTest.class);
	}

	Book createBook() {
		Book testData = new Book();
		testData.setTitle("Java本");
		testData.setAuthor("Foo J. Bar");
		testData.setTranslator("言語 太郎, 言語 次郎");
		testData.setPublisher("言語太郎出版");
		testData.setPublicationDate("2003-12-25");
		testData.setCode("ISBN4-123-4567-X");
		testData.setMemo("メモ");
		testData.setKeyword("プログラミング言語");
		testData.setDataCreator("fujiwara");
		testData.setDataCreatedDate("2004-01-15");
		return testData;
	}

	void assertBookEquals(Book book1, Book book2) {
		assertEquals(book1.getBookId(), book2.getBookId());
		assertEquals(book1.getTitle(), book2.getTitle());
		assertEquals(book1.getAuthor(), book2.getAuthor());
		assertEquals(book1.getTranslator(), book2.getTranslator());
		assertEquals(book1.getPublisher(), book2.getPublisher());
		assertEquals(book1.getPublicationDate(), book2.getPublicationDate());
		assertEquals(book1.getCode(), book2.getCode());
		assertEquals(book1.getMemo(), book2.getMemo());
		assertEquals(book1.getKeyword(), book2.getKeyword());
		assertEquals(book1.getDataCreator(), book2.getDataCreator());
		assertEquals(book1.getDataCreatedDate(), book2.getDataCreatedDate());
	}

	public void testAddGetAndDelete() {
		BookCatalog catalog = new BookCatalog();
		// テストデータの作成
		Book testData1 = createBook();
		Book testData2 = createBook();
		// addBookのテスト
		Book created1 = catalog.addBook(testData1);
		Book created2 = catalog.addBook(testData2);
		assertNotNull(created1);
		assertNotNull(created2);
		String bookId1 = created1.getBookId();
		String bookId2 = created2.getBookId();
		assertNotNull(bookId1);
		assertFalse(bookId1.equals(bookId2));
		// getBookのテスト
		Book book = catalog.getBook(bookId1);
		assertNotNull(book);
		assertBookEquals(book, created1);
		// getBooksのテスト
		Book [] books = catalog.getBooks();
		assertNotNull(books);
		assertTrue(books.length >= 2);
		// deleteBookのテスト
		catalog.deleteBook(bookId1);
		assertNull(catalog.getBook(bookId1));
		catalog.deleteBook(bookId2);
		assertNull(catalog.getBook(bookId2));
	}

	public void testSaveAndLoad() {
		BookCatalog catalog = new BookCatalog();
		// テストデータの準備
		Book testData = createBook();
		// saveのテスト
		Book created = catalog.addBook(testData);
		assertNotNull(created);
		String bookId = created.getBookId();
		assertNotNull(bookId);
		// loadのテスト
		catalog = new BookCatalog();
		Book reloaded = catalog.getBook(bookId);
		assertNotNull(reloaded);
		assertBookEquals(created, reloaded);
		// テストデータの消去
		catalog.deleteBook(bookId);
	}
}
