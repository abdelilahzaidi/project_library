package be.bruxellesformation;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static String author = "";
    static String title = "";
    static Scanner scan = new Scanner(System.in);
    static Library library = new Library();
    static Library libraryULB = new Library();
    static FileReader fileReader = new FileReader("src/books.txt");

    
    public static void main(String[] args){
        library.addBooksFromFile(fileReader.read());
        menu();
    }


    public static void menu(){

        System.out.println("Bonjour et bienvenue à la bibliothèque de DigitalCity");
        System.out.println("Il y a plus de " + library.getNumberBook() + " livres à emprunter ou consulter");
        System.out.println("Que souhaitez vous faire ?");
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
        entry();
        library.borrowBook(new Book(author, title));
    }

    public static void returnBook(){
        entry();
        library.returnBook(new Book(author,title));
    }

    public static void entry(){
        System.out.println("Veuillez entrer le titre");
        title = scan.nextLine();
        System.out.println("Veuillez entrer l'auteur");
        author = scan.nextLine();
    }

}