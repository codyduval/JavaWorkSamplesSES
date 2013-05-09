import java.util.Scanner;

public class LinkedListPractice {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("\nEnter 'list or stack' to start: ");
        String command = consoleScanner.next();
        if (command.equals("list")) {
            linkedList();
        }
        else if(command.equals("stack")) {
            intStack();
        }
        else {
            System.out.println("Invalid input, bailing");
        }
    }

    public static void linkedList() {
        IntLinkedList list =  new IntLinkedList();

        while(true) {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("\nEnter {add/remove} and a number to modify the list (or just {reverse 0} to reverse the list) : ");
            String command = consoleScanner.next();
            int value = consoleScanner.nextInt();

            if (command.equals("add")) {
                list.insert(value);
            }
            else if (command.equals("remove")) {
                list.remove(value);
            }
            else if (command.equals("reverse")) {
                list.reverse();
            }

            list.print();
        }
    }
    
    public static void intStack() {
    	IntStack list =  new IntStack();

        while(true) {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("\nEnter {push/pop/size/quit} to modify the list: ");
            String command = consoleScanner.next();
            
            if (command.equals("push")) {
            	System.out.print("\nEnter number to push onto list: ");
            	int value = consoleScanner.nextInt();
                list.push(value);
            }
            else if (command.equals("pop")) {
                int x = list.pop();
                System.out.println("The top of the stack is now the integer " + x);
            }
            else if (command.equals("size")) {
                int size = list.size();
                System.out.println(size);
            	
            }
            else {
            	System.out.print("Goodbye!");
            	break;
            	
            }
        }
    }
}
	
	
