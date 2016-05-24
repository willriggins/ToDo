package com.theironyard;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void createItem(Scanner scanner, ArrayList<ToDoItem> items) {
        System.out.println("Enter your to do item:");
        String text = scanner.nextLine();
        ToDoItem item = new ToDoItem(text, false);
        items.add(item);
    }

    public static void toggleItem(Scanner scanner, ArrayList<ToDoItem> items) {
        System.out.println("Enter the # of the item you wish to toggle:");
        String numStr = scanner.nextLine();
        try {
            int num = Integer.valueOf(numStr);
            ToDoItem tempItem = items.get(num - 1);
            tempItem.isDone = !tempItem.isDone;
        }
        catch (NumberFormatException ex) {
            System.out.println("You didn't type a number!");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("There is no item with this number!");
        }

    }

    public static void listItems(ArrayList<ToDoItem> items) {
        int i = 1;
        for (ToDoItem toDoItem : items) {
            String checkbox = "[ ]";
            if (toDoItem.isDone) {
                checkbox = "[x]";
            }
            System.out.printf("%s %s. %s\n", checkbox, i, toDoItem.text);
            i++;
        }

    }

    public static void main(String[] args) {
        ArrayList<ToDoItem> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create New Item");
            System.out.println("2. Toggle Item");
            System.out.println("3. List Items");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    createItem(scanner, items);
                    break;

                case "2":
                    toggleItem(scanner, items);
                    break;

                case "3":
                    listItems(items);
                    break;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}
