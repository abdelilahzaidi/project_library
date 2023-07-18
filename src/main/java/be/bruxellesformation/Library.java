package be.bruxellesformation;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    User user;
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Book> borrowed = new ArrayList<>();

    ArrayList<Rent> rents = new ArrayList<>();

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
        for (Rent rent: rents) {
            System.out.println(rent);
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

    public void borrowBooks(User borrower, LocalDate borrowDate, LocalDate returnDate, ArrayList<Book> books) {

        if (borrower != null && borrowDate.isBefore(returnDate) && getBooks().size()>=1) {

            // Ajout des bouquin dans les borrowed
            for (Book b : books) {
                borrowBook(b);
            }
            // Création et ajout de emprunt dans librairie
            Rent rent = new Rent(borrower, this.books, borrowDate, returnDate);

            rents.add(rent);
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

    public  int getNumberBook(){
        return books.size();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getBorrowed() {
        return borrowed;
    }
}
