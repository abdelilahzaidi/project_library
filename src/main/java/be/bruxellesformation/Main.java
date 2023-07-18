package be.bruxellesformation;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static String author = "";
    static String title = "";
    static String firstName= "";
    static  String lastName="";

    static LocalDate dateBorrow;
   static LocalDate dateReturn;

   static User borrower;
    static Book livre =new Book(author, title);
    static Scanner scan = new Scanner(System.in);
    static Library library = new Library();
    static ArrayList<Book> livres = new ArrayList<>();
    static Rent rent=new Rent(borrower,livres,dateReturn,  dateBorrow);
    public static void main(String[] args) {
        menu();

    }


    public static void menu(){

        library.addBook(new Book("JK", "HP"));
        library.addBook(new Book("Tolkien", "Seigneur des anneaux"));

        System.out.println("Bonjour, Que souhaitez vous faire ?");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Supprimer un livre");
        System.out.println("3. Afficher tous les livres");
        System.out.println("4. Chercher un livre");
        System.out.println("5. Emprunter un livre");
        System.out.println("6. Rendre un livre");

        String option = scan.nextLine();

        switch (option){
            case "1":
                addBook();
                break;
            case "2":
                removeBook();
                break;
            case "3":
                library.displayBooks();
                break;
            case "4":
                findBook();
                break;
            case "5":
                borrowBook();
                break;
            case "6":
                returnBook();
                break;
            default:
                System.out.println("Je n'ai pas compris votre choix");
        }
        menu();
    }

    public static void addBook(){
        entry();
        library.addBook(new Book(author, title));
        System.out.println(library.getNumberBook());
    }
    public static void removeBook(){
        entry();
        library.removeBook(new Book(author, title));
    }

    public static void findBook(){
        entry();
        if(title.equals("\n")){
            library.findBookByAuthor(author);
        }
        if(author.equals("\n")){
            library.findBookByTitle(title);
        }
        else{
            library.findBookByTitle(title);
            library.findBookByAuthor(author);
        }
    }

    public static void borrowBook(){
        //library.borrowBook(new Book(author, title,borrower,dateBorrow,dateReturn));
        entry_book_borrok();
        library.borrowBooks(borrower,dateBorrow,dateReturn,livres);
    }

    public static void returnBook(){
        entry_book();
        library.returnBook(new Book(author, title));
    }
    public static void entry(){
        System.out.println("Veuillez entrer le titre");
        title = scan.nextLine();
        System.out.println("Veuillez entrer l'auteur");
        author = scan.nextLine();
    }

    public static void entry_book(){
        System.out.println("Veuillez entrer le titre");
        title = scan.nextLine();
        System.out.println("Veuillez entrer l'auteur");
        author = scan.nextLine();
        System.out.println("Veuillez entrer le nom");
        firstName = scan.nextLine();
        System.out.println("Veuillez entrer le prenom");
        lastName = scan.nextLine();
        System.out.println("Veuillez entrer la date d'emprunt");
        dateBorrow=LocalDate.parse(scan.nextLine());
        System.out.println("Veuillez entrer la date de retour");
        dateReturn=LocalDate.parse(scan.nextLine());
    }
    public static void entry_book_borrok(){
        System.out.println("Veuillez entrer le nom");
        firstName = scan.nextLine();
        System.out.println("Veuillez entrer le prenom");
        lastName = scan.nextLine();
        borrower = new User(firstName, lastName);
        System.out.println("Veuillez entrer la date d'emprunt");
        dateBorrow=LocalDate.parse(scan.nextLine());
        System.out.println("Veuillez entrer la date de retour");
        dateReturn=LocalDate.parse(scan.nextLine());
        System.out.println("Veuillez entrer les titres séparé par des virgules");
        title = scan.nextLine();

        String[] titles = title.split(",");

        for (String t : titles) {
            for (Book book : library.books) {
                if (book.getTitle().equals(t)) {
                    livres.add(book);
                }
            }
        }

//        while(title !="*"){
//            library.addBook(new Book(author, title));
//        }
    }
}