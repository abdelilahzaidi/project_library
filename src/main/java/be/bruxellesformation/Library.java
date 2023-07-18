package be.bruxellesformation;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Book> borrowed = new ArrayList<>();

    public void addBook(Book newBook){
        books.add(newBook);
    }
    public void removeBook(Book newBook){
        books.remove(newBook);
    }

    public void displayBooks(){
        for (Book element:books) {
            System.out.println(element);
        }
    }

    public void findBookByAuthor(String author){
        for (Book element:books) {
            if(author.equals(element.getAuthor())){
                System.out.println(element);
            }
        }
    }

    public void findBookByTitle(String title){
        for (Book element:books) {
            if(title.equals(element.getTitle())){
                System.out.println(element);
            }
        }
    }


    public void borrowBook(Book book){
        borrowed.add(book);
        books.remove(book);
    }

    public void returnBook(Book book){
        books.add(book);
        borrowed.remove(book);
    }

    public int getNumberBook(){
        return books.size();
    }

}
