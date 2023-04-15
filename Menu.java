/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author Minh Huy
 */
public class Menu {

    public static void main(String[] args) {
        Validation input = new Validation();
        BookList list = new BookList();
        String filename = "Book.txt";
        int choice;
        do{
            System.out.println("");
            System.out.println("Book Management System");
            System.out.println("============================");
            System.out.println("1. Add new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search a book");
            System.out.println("4. Update book's price");
            System.out.println("5. Find the (first) max price");
            System.out.println("6. Sort the list ascendingly by code");
            System.out.println("7. Remove book");
            System.out.println("8. Load data from file");
            System.out.println("0. Exit");
            System.out.println("============================");
            System.out.print("Choice: ");
            choice=input.inputInt(0,8);
            
            switch(choice){
                case 1: list.addNewBook(); break;
                case 2: list.printAll(); break;
                case 3: list.search(); break;
                case 4: list.updatePrice(); break;
                case 5: list.maxPrice(); break;
                case 6: list.sortCode(); break;
                case 7: list.remove(); break;
                case 8: list.AddFromFile(filename); break;
                default: System.out.println("Goodbye!");
            }
        }
        while(choice != 0);
    }
}
    

