ArrayList<Integer> numbers = new ArrayList<Integer>();
Scanner input = new Scanner(new File("Numbers.txt"));
while (input.hasNextInt()) {
    int n = input.nextInt();
    numbers.add(n);
}

System.out.println(numbers);

//insert additional methods and calls here ...

filterEvens(numbers);
System.out.println(numbers);

// Removes all elements with even values from the given list.
public static void filterEvens(ArrayList<Integer> list) {
    for (int i = list.size() - 1; i >= 0; i--) {
        int n = list.get(i);
        if (n % 2 == 0) {
            list.remove(i);
        }
    }
}