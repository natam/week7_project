package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsTasks {
    public static void main(String[] args) {
        //task 1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evens = numbers.stream().filter(x -> x%2!=0).toList();
        int odsSum = numbers.stream().filter(x -> x%2==0).reduce(0, Integer::sum);
        System.out.println(evens);
        System.out.println(odsSum);
        //task 2
        System.out.println("**************");
        List<String> words = Arrays.asList("hello", "world", "streams", "java");
        List<String> upperCaseWords = words.stream().map(String::toUpperCase).toList();
        int numberOfCharacters = upperCaseWords.stream().reduce(0,(abs,i) -> abs + i.length(), Integer::sum);
        System.out.println(words);
        System.out.println(upperCaseWords);
        System.out.println("Number of chars: " + numberOfCharacters);
        //task 3
        System.out.println("**************");
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers2.stream().reduce(0, Integer::sum);
        double avg = numbers2.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        System.out.println(numbers2);
        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + avg);
        //task 4
        System.out.println("**************");
        List<String> strs = Arrays.asList("apple", "banana", "cherry");
        String newStr = strs.stream().collect(Collectors.joining(","));
        String reverseStr = strs.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(","));
        System.out.println(newStr);
        System.out.println(reverseStr);
        //task 5
        System.out.println("**************");
        List<String> animals = Arrays.asList("cat", "elephant", "dog", "dolphin");
        int number = (int) animals.stream().filter(str -> str.length()>3).count();
        String shortestWord = animals.stream().min(Comparator.comparing(String::length)).toString();
        System.out.println(number);
        System.out.println(shortestWord);
    }
}
