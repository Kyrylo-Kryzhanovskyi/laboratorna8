package Task2;


public class SecondTask {
    public static void main(String[] args) {
        MyStack<String> stack1 = new MyStack<>();
        MyStack<String> stack2 = new MyStack<>();

        stack1.push("DD");
        stack1.push("FF");
        stack1.push("EE");
//        stack1.push(20F);
//        stack1.push(50F);
//        stack1.push(212F);
        System.out.println("Стек 1: " + stack1);

        stack2.push("AAA");
        stack2.push("BBB");
        stack2.push("CCC");
        System.out.println("Стек 2: " + stack2);

        // Порівняння стеків
        int comparisonResult = stack1.compareTo(stack2);
        System.out.println("Порівняння стеку 1 з стеком 2:");
        if (comparisonResult == 0) {
            System.out.println("Стеки однакові.");
        } else if (comparisonResult > 0) {
            System.out.println("Стек 1 більше стеку 2.");
        } else if (comparisonResult == -42) {
            System.out.println("Неможливо порівняти елементи різних класів, їх порівняння не передбачено.");
        } else {
            System.out.println("Стек 1 менше стеку 2.");
        }

        System.out.println("Pop з стеку 1: " + stack1.pop());
        System.out.println("Стек 1 після pop: " + stack1);

        System.out.println("Pop з стеку 1: " + stack1.pop());
        System.out.println("Стек 1 після pop: " + stack1);


        System.out.println("Pop з стеку 2: " + stack2.pop());
        System.out.println("Стек 2 після pop: " + stack2);

    }

}

