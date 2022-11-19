import java.util.Locale;

public class proj {
    public static void main(String[] args) {
        int data[][] = {{44, 35, 26, 81}, {38, 93, 14, 61}, {12, 47, 64, 20}};
        System.out.println(returnMaxFromArray(data));
       // printPatternUpToTenNumbersExlusevely();
        System.out.println(reverseWordsInSentence("Hello to Java class"));
    }

    public static int returnMaxFromArray(int[][] arrayNums) {
        int max = arrayNums[0][0];

        for (int i = 0; i < arrayNums.length; i++) {
            for (int j = 0; j < arrayNums[i].length; j++) {
                if (max < arrayNums[i][j]) {
                    max = arrayNums[i][j];
                }
            }
        }
        return max;
    }

// Write a program to Reverse words in a String
//      Example input - Welcome to java class
//      Output  - emocleW ot avaj ssalc
    public static String reverseWordsInSentence (String word){
        String[] words = word.split(" ");
        String reversed = "";
        for(int i=0;i<words.length;i++){
            String str = words[i];
            String reversedstr = "";
            for (int j=str.length()-1; j>=0; j--){
                reversedstr = reversedstr + str.charAt(j);
            }
            reversed = reversed+ reversedstr + " ";
        }

        return reversed;
    }

    //Write a program to print below pattern

//        1 2 3 4 5
//        2 3 4 5 6
//        3 4 5 6 7
//        4 5 6 7 8
//        5 6 7 8 9


    public static void printPatternUpToTenNumbersExlusevely() {
        int rows = 5;
        int num = 12345;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println(num + " ");
                ++num;
            }

            System.out.println();
        }
    }

        // Write a program to print below pattern

//        H       H
//        He     eH
//        Hel   leH
//        Hell lleH
//        HellolleH


        public static void printStringPattern (String word) {




        }

    }



