
public class RemoveDigitToMaximizeResult {

    // Logic: if immediate next value is greater than the digit to be deleted, then remove that digit.

    public static String removeDigitIfImmediateNextDigitIsGreaterThanIt(String str, char digitToBeRemoved) {
      
        String maxedString = str; // Initialize with the original string.

        // Loop to find the first occurrence of digit to be removed where the next digit is greater.
        
        for (int i = 0; i < str.length() - 1; i++) {  // Loop stops at second last index
            if (str.charAt(i) == digitToBeRemoved) {
                if (str.charAt(i + 1) > str.charAt(i)) {
                    // Remove the digit at position i
                    maxedString = str.substring(0, i) + str.substring(i + 1);
                    return maxedString;  // Return immediately after the first valid modification
                }
            }
        }

        // If no valid digit removal occurred, remove the last occurrence of digitToBeRemoved
        int lastIndexOfDigitToBeRemoved = str.lastIndexOf(digitToBeRemoved);
        if (lastIndexOfDigitToBeRemoved != -1) {  // Ensure the digit is found
            maxedString = str.substring(0, lastIndexOfDigitToBeRemoved) + str.substring(lastIndexOfDigitToBeRemoved + 1);
        }

        return maxedString;  // Return the final modified string
    }

    public static void main(String[] args) {

        String str = "712327132743755"; // Special-Edge-Case : since no next digt is greater then digit to be removed, thus remove the digit next to last occurrance of digit to be removed.
    //  String str = "7135712789";      // Example string
        char digitToBeRemoved = '7';

        // Call the function and print the result
        System.out.println(removeDigitIfImmediateNextDigitIsGreaterThanIt(str, digitToBeRemoved));
    }
}
