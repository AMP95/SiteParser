package MainPackage;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	String GenerateFileName(String filename) 
	{
		String notAvaliable = "/\\*:?|\"<>";
		for (int i = 0; i < notAvaliable.length(); i++) 
		{
			char sym = notAvaliable.charAt(i);
			filename = filename.replace(sym,'_');
		}
		return filename;
	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите название книги");
		String title = scan.nextLine();
		String site = SiteFromUrl.getSite("https://tululu.org/search/?q=" + title);
		ArrayList<BookModel> books=BooksFromSite.getBooks(site);
		System.out.println("Результат: ");
		int index = 1;
		for(BookModel bookModel:books)
		{
			System.out.println(index++ + ")" + + bookModel.getTitle());
		}
		System.out.println("Введите номер книги: ");
		index = scan.nextInt();
		
		BookLoader.DownloadBook("", "F:\\загрузки", 
				books.get(index - 1).getTitle());
	}
}
