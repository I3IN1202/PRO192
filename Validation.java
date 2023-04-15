/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.util.Scanner;
/**
 *
 * @author Minh Huy
 */
public class Validation {
     Scanner sc = new Scanner(System.in);
    public int inputInt() {
        int value;
        while(true){
            try{
                value=Integer.parseInt(sc.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Error!");
            }
            System.out.print("Re-input: ");
        }
        return value;
    }
    
    public int inputInt(int min, int max) {
        int value;
        while(true){
            try{
                value=Integer.parseInt(sc.nextLine());
                if(value < min || value > max){
                    System.out.println("Number must in range " + min + " to " + max);
                }
                break;
            }
            catch (Exception e){
                System.out.println("Error!");
            }
            System.out.print("Re-input: ");
        }
        return value;
    }
    
    public double inputDouble() {
        double value;
        while(true){
            try{
                value=Double.parseDouble(sc.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Error!");
            }
            System.out.print("Re-input: ");
        }
        return value;
    }
    
    public String inputStr() {
        String str;
        str=sc.nextLine();
        return str;
    }
}
