/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 *
 * @author Minh Huy
 */
public class BookList extends ArrayList<Book> {
    Validation scInput = new Validation();

    protected void addNewBook() {
        String code;
        String title;
        int qua;
        double price;
        System.out.println("Enter New Book Details:");
        do {
            System.out.print("Enter book's code: ");
            code = scInput.inputStr();
            if (find(code) >= 0) {
                System.out.println("The book's code already exists.");
            }
        } while (find(code) >= 0);
        System.out.print("Enter book's title: ");
        title = scInput.inputStr();
        System.out.print("Enter book's quantity: ");
        qua = scInput.inputInt();
        System.out.print("Enter book's price: ");
        price = scInput.inputDouble();
        this.add(new Book(code, title, qua, price));
        System.out.println("Add new book successfully!");
    }

    protected int find(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    protected void updatePrice() {
        String code;
        int pos;
        System.out.print("Enter the code of updated book: ");
        code = scInput.inputStr();
        pos = find(code);
        if (pos < 0) {
            System.out.println("The book doesn't exist!");
        } else {
            System.out.print("Enter new price: ");
            this.get(pos).setPrice(scInput.inputInt());
            System.out.print("Update \"" + code + "\" price successfully!");
        }
    }

    protected void search() {
        String code;
        int pos;
        System.out.print("Enter the code of book: ");
        code = scInput.inputStr();
        pos = find(code);
        if (pos < 0) {
            System.out.println("The book doesn't exist!");
        } else {
            System.out.println("The book exists at position: " + (pos + 1) + "(th)");
        }
    }

    protected void maxPrice() {
        int maxIndex = 0;
        for (int i = 1; i < this.size(); i++) {
            if (this.get(i).getPrice() > this.get(maxIndex).getPrice()) {
                maxIndex = i;
            }
        }
        System.out.println("The first max price value exists at position: " + (maxIndex + 1) + "(th)");
    }

    protected void sortCode() {
        for (int i = 0; i < this.size() - 1; i++) {
            for (int j = i + 1; j < this.size(); j++) {
                if (this.get(i).getCode().compareTo(this.get(j).getCode()) > 0) {
                    Collections.swap(this, i, j);
                }
            }
        }
    }

    protected void remove() {
        String code;
        System.out.print("Enter the code of removed book: ");
        code = scInput.inputStr();
        int pos = find(code);
        if (pos < 0) {
            System.out.println("This code does not exist.");
        } else {
            this.remove(pos);
            System.out.println("The book " + code + " has been removed.");
        }
    }
    
    protected void printAll(){
        if(this.isEmpty()){
            System.out.println("Empty List.");
            return;
        }
        System.out.println("Book List:");
        for(Book x:this){
            x.print();
        }
    }
    
    public void AddFromFile(String fname){
        this.clear();
        try{
            File f = new File(fname);
            if (!f.exists()) return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details=bf.readLine())!=null)
            {
                StringTokenizer stk = new StringTokenizer(details,",");
                String code=stk.nextToken().toUpperCase();
                String title=stk.nextToken().toUpperCase();
                int qua=Integer.parseInt(stk.nextToken());
                double price = Double.parseDouble(stk.nextToken());
                Book book = new Book(code, title, qua, price);
                this.add(book);
            }
            bf.close();
            fr.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

    
