import java.io.*;

public class Lab3 {

    private static final String VOWELS = "aeyuio";

    private BufferedReader mReader;

    public Lab3(InputStream inputStream) {
        mReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void dispose() throws IOException {
        mReader.close();
    }

    public String getNextSentence() throws IOException {
        return mReader.readLine();
    }

    public boolean isVowel(char symbol) {
        return VOWELS.contains(String.valueOf(symbol).toLowerCase());
    }

    public static void main(String[] args){
        Lab3 lab = new Lab3(System.in);

        try {
            final String continueConfirmLetter = "y";
            boolean shouldContinue = true;
            do {
                System.out.println("Input a sentence:");
                String sentence = lab.getNextSentence();
                int vowels = 0;
                int consonants = 0;
                for (int i = 0, size = sentence.length(); i < size; i++) {
                    char symbol = sentence.charAt(i);
                    if (Character.isLetter(symbol)) {
                        if (lab.isVowel(symbol)) {
                            vowels++;
                        } else {
                            consonants++;
                        }
                    }
                }
                // results output
                if (vowels == 0 && consonants == 0) {
                    System.out.println("There are no letters in your sentence.");
                } else if (vowels == consonants) {
                    System.out.println(String.format("There are same number of vowels and consonants in your " +
                            "sentence: %d", vowels));
                } else {
                    final boolean moreVowels = vowels > consonants;
                    System.out.println(String.format("Sentence contains more " +
                                    (moreVowels ? "vowels(%d)" : "consonants(%d)") +
                                    " than " +
                                    (!moreVowels ? "vowels(%d)" : "consonants(%d)"),
                            moreVowels ? vowels : consonants,
                            !moreVowels ? vowels : consonants));
                }

                // wanna one more try?
                System.out.println("---------------------------------");
                System.out.println("Do you want to try one more time? Enter 'y' to continue...");
                System.out.println("---------------------------------");
                String answer = lab.getNextSentence();
                shouldContinue = continueConfirmLetter.equals(answer.toLowerCase());
            } while (shouldContinue);
            System.out.println("Goodbye!");
        } catch (Exception e){
            System.out.println("Ooops, some error occured!");
        } finally {
            try {
                lab.dispose();
            } catch (IOException ignore) {
                // no-op
            }
        }
    }
}
