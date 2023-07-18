package be.bruxellesformation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Rent {
    private User emprunteur;
     private ArrayList<Book> books;
     private LocalDate borrowDate;
     private LocalDate returnDate;

    public Rent(User emprunteur, ArrayList<Book> books, LocalDate borrowDate, LocalDate returnDate) {
        this.emprunteur = emprunteur;
        this.books = books;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public User getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(User emprunteur) {
        this.emprunteur = emprunteur;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    /*public boolean borrowBooks(User borrower, LocalDate borrowDate, LocalDate returnDate,Library library) {

        if (this.emprunteur != null && returnDate.isBefore(returnDate) && library.getBooks().size()>=1) {
            this.emprunteur = borrower;
            this.borrowDate = borrowDate;
            this.returnDate = returnDate;
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return Objects.equals(emprunteur, rent.emprunteur) && Objects.equals(books, rent.books) && Objects.equals(borrowDate, rent.borrowDate) && Objects.equals(returnDate, rent.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emprunteur, books, borrowDate, returnDate);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "emprunteur=" + emprunteur +
                ", books=" + books +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
