package zipcode;

public class Hamming {
    private String s;
    private String s1;

    //https://stackoverflow.com/questions/15186202/should-i-validate-parameters-in-constructor

    //The constructor handles validation, and the method handles the calculation.
    public Hamming(String s, String s1) {
        if (s.length() != s1.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.s = s;
        this.s1 = s1;
    }

    //seperate the responsibility of the code throwing exception here was not working because of the test but also because we want to
    //validate the data before we perform any actions on it. if the object is broken no need to try and perform calculations on it, since its already
    //broken just throw the exception before it screws up more of your code
    public int getHammingDistance() throws IllegalArgumentException{

            int hamming = 0;
            if (s.length() == s1.length()) {
                int count = 0;
                while (count < s.length()) {
                    if (s.charAt(count) != s1.charAt(count)) {
                        hamming++;
                        count++;
                    } else {
                        count++;
                    }
                }
            } else {
                throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
            }
            return hamming;
    }
}
