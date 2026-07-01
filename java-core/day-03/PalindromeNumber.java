public class PalindromeNumber {
    public static boolean isPalindrome(int num) {
        // Negative numbers are not palindromes
        if (num < 0) return false;

        int originalNum = num;
        int reversedNum = 0;

        while (num != 0) {
            int lastDigit = num % 10;
            reversedNum = (reversedNum * 10) + lastDigit;
            num /= 10; // Remove last digit
        }

        return originalNum == reversedNum;
    }

    public static void main(String[] args) {
        int test = 121;
        System.out.println(test + " is palindrome? " + isPalindrome(test)); // Output: true
    }
}