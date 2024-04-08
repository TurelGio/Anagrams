import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int counter = 0;

    public static void main(String[] args) {
        String word;
        int number;
        // Create new scanner to read the input line from console and use number form args.
        Scanner scanner = new Scanner(System.in);


        System.out.println("Greetings, select program functionality: ");
        System.out.println("        1- N anagrams;");
        System.out.println("        2- All Anagrams;");

        int choice = scanner.nextInt();
        if(choice == 1){
            if(checkArgs(args)) {
                number = Integer.parseInt(args[0]);
            } else {
                number = 1;
            }
            // Create an array of string that will contain the anagrams.
            String[] anagrams = new String[number];
            // Greeting the user and ask the word to process.
            System.out.println("Greetings, please insert a new word to find n anagrams of it:");
            word = scanner.next();
            // Check correctness and look if the word is c
            if(!checkWord(word)) {
                return;
            }

            getResult(word, "", number, anagrams);
        } else if (choice == 2) {
            // Greeting the user and ask the word to process.
            System.out.println("Greetings, please insert a new word to find all the anagrams of it:");
            word = scanner.next();
            // Check correctness and look if the word is c
            if(!checkWord(word)) {
                return;
            }
            // Create an array of string that will contain the anagrams.
            number = getFactorial(word.length());
            String[] anagrams = new String[number];

            getAllResult(word, "", anagrams);
        } else {
            System.out.println("[WARNING]: No acceptable value inserted. Please enter an acceptable value");
            return;
        }

    }

    // Checks if there are arguments from console.
    // If there are none end the program with error.
    static boolean checkWord(String word) {
        if (!word.matches("[A-Za-z]+")) {
            System.out.println("[WARNING]: The word is not matching the requirements");
            System.out.println("           Please try again.");
            return false;
        } else {
        return true;
        }
    }

    // Checks if the word obtained from program is matching
    // the requirements of definition of word
    static boolean checkArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("[WARNING]: There is no number of args requested.");
            System.out.println("           Number set to 1.");
            return false;
        } else {
            return true;
        }
    }

    // Create set of n anagrams of the word passed in the argument.
    static void getAnagrams(String str, String ans, int num, String[] anagrams) {
      // Convert all letters to lowercase
      str = str.toLowerCase();

      // Base case for recursive algorithm
      if (str.isEmpty() || counter >= num) {
          if (counter < num) {
              anagrams[counter] = ans;
              counter++;
          }
          return;
      }

      // Recursive algorithm to permute letters.
      for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          String res = str.substring(0, i) + str.substring(i + 1);
          getAnagrams(res, ans + ch, num, anagrams);
      }
    }

    // Create set of all the anagrams of the word passed in the argument.
    static void getAllAnagrams(String str, String ans, String[] anagrams) {
        // Convert all letters to lowercase
        str = str.toLowerCase();

        // Base case for recursive algorithm
        if (str.isEmpty()) {
            // Add the permutation to the array
            for (int i = 0; i < anagrams.length; i++) {
                if (anagrams[i] == null) {
                    anagrams[i] = ans;
                    break;
                }
            }
            return;
        }

        // Recursive algorithm to permute letters.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String res = str.substring(0, i) + str.substring(i + 1);
            getAllAnagrams(res, ans + ch, anagrams);
        }
    }

      // Capitalize first letter of string.
      static String firstCapitalLetter(String word) {
          if (word == null || word.isEmpty()) {
              return word;
          }
          return word.substring(0, 1).toUpperCase() + word.substring(1);
      }

      // Prints on console the array of strings.
      static void printAnagrams(String[] array) {
            for(int i = 0; i < array.length; i++) {
                array[i] = firstCapitalLetter(array[i]);
                System.out.println(array[i]);
            }
      }

      // Final method to find the anagrams of the word.
      static void getResult(String word, String ans, int number, String[] anagrams) {
        System.out.println("Printing "+number+" anagrams of the word \""+word+"\":");
        getAnagrams(word, "", number, anagrams);
        printAnagrams(anagrams);
      }

    // Final method to find the anagrams of the word.
    static void getAllResult(String word, String ans, String[] anagrams) {
        System.out.println("Printing anagrams of the word \""+word+"\":");
        getAllAnagrams(word, "", anagrams);
        printAnagrams(anagrams);
    }
    static int getFactorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n * getFactorial(n - 1);
    }
}