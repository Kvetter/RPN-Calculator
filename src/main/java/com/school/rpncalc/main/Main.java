/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.rpncalc.main;

import com.school.rpncalc.ArrayStack;
import java.util.Scanner;

/**
 *
 * @author kaspe
 */
public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        // creating instances of my stack to hold the numbers and math symbols
        ArrayStack mathToDO = new ArrayStack();
        ArrayStack stack = new ArrayStack();
        
        // setting up while loop to collect user input
        while (true) {
            
            // collecting user input, and splitting each number/symbol seperated by a space
            String input = reader.nextLine();
            String[] inputArray = input.split(" ");

            
            //looping over the input to see which is a number and which is a symbol
            // and saving it in the correct stack
            for (String string : inputArray) {

                try {
                    stack.push(Integer.parseInt(string));

                } catch (NumberFormatException e) {
                    mathToDO.push(string);
                }
            }

            //checking to see if there are any calculations that needs to be done
            while (!mathToDO.isEmpty()) {
                // we need atleast 2 numbers in the stack to perform a calculation
                if (stack.getTop() > 1) {
                    System.out.println("length: " + stack.length());
                    switch ((String) mathToDO.pop()) {
                        case "+":
                            stack.push((int) stack.pop() + (int) stack.pop());
                            break;
                        case "*":
                            stack.push((int) stack.pop() * (int) stack.pop());
                            break;
                        case "/":
                            stack.push((int) stack.pop() / (int) stack.pop());
                            break;
                        case "-":
                            stack.push((int) stack.pop() - (int) stack.pop());
                            break;
                    }
                } else {
                    System.out.println("Too few numbers to calculate");
                    break;
                }
            }
            System.out.println("Numbers in stack: ");
            for (Object object : stack) {
                System.out.println(object.toString());
            }

            if (input.equals("exit")) {
                break;
            }
        }
    }

}
