package com.aston.javabase;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        // Перевернуть строку и вывести на консоль
        String string = "I love Java";
        turnString(string);

        // Удалить дубликаты из массива и вывести в консоль
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        getDistinctNumbers(ints);

        // Дан массив, заполненный уникальными значениями типа int.
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        int result = findSecondMaxElement(arr);
        System.out.println(result);

        // Найти длину последнего слова в строке. В строке только буквы и пробелы.
        System.out.println(lengthOfLastWord("Hello world"));
        //"    fly me    to the moon    " - 4
        System.out.println(lengthOfLastWord("    fly me    to the moon    "));

        // Определить, что строка является палиндромом
        // Примеры:
        // abc - false
        System.out.println(isPalindrome("abc"));
        // 112233 - false
        System.out.println(isPalindrome("112233"));
        // aba - true
        System.out.println(isPalindrome("aba"));
        // 112211 - true
        System.out.println(isPalindrome("112211"));



    }

    // Перевернуть строку и вывести на консоль
    public static void turnString(String string) {
        String result = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            result += string.charAt(i);
        }
        System.out.println(result);
    }


    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        int[] number = new int[ints.length];
        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            boolean isUnic = false;
            for (int j = 0; j < index; j++) {
                if (number[j] == ints[i]) {
                    isUnic = true;
                    break;
                }
            }
            if (!isUnic) {
                number[index++] = ints[i];
            }
        }
        number = Arrays.copyOf(number, index);
        System.out.println(Arrays.toString(number));
    }


    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        int maxResult = arr[0];
        int element = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxResult) {
                maxResult = arr[i];
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != maxResult && arr[j] > arr[i]) {
                    element = arr[j];
                }
            }
        }
        return element;

    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.

    public static Integer lengthOfLastWord(String string) {
        int result= 0;
        String[] words = string.split(" ");
        String word = words[words.length - 1];
        result = word.length();
        return result;
    }


    // Сложность по памяти O(1), не создавать новые String, StringBuilder

    public static boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right){
            if(string.charAt(left) != string.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}