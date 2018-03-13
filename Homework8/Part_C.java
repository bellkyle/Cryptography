
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Part_C {
    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");
        String encrypted = "mgodtbeidapsglsakowuhxukciawlrcsoyhprtrtudrqhcengxuuqtuhabxwdgkiektsnpsekldzlvnhwefssglzrnpeaoylbyiguaafveqgjoewabzsaawlrzjpvfeykygylwubtlydkroecbpfvtpsgkipuxfbuxfuqcvymyokaglsacttuwlrxpsgiyytpsfrjfuwigxhroyazdrakcedxeyrpdobrbuehruwcueekficzehrqijezrxsyortcylfegcy\n";
        double ic1 = 0;
        double ic2 = 0;
        double ic3 = 0;
        double ic4 = 0;
        double ic5 = 0;
        double ic6 = 0;
        double ic7 = 0;
        double ic8 = 0;
        double ic9 = 0;


        System.out.println("Enter the key length");
        int length = reader.nextInt();

        if (length < 1) {
            System.out.println("Key length must be 1 or greater");
            return;
        }

        System.out.println("\nIndices of coincidence: ");

        if (length >= 1) {
            String line1 = "";
            ArrayList<Character> list1 = new ArrayList<>();

            for (int i = 0; i < encrypted.length(); i += length) {
                line1 += encrypted.charAt(i);
            }

            for (int i = 0; i < line1.length(); i++) {
                for (int n = i + 1; n < line1.length(); n++) {
                    if (line1.charAt(i) == line1.charAt(n) && !list1.contains(line1.charAt(i)))
                        list1.add(line1.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list1.size(); i++) {
                String letter = String.valueOf(list1.get(i));
                int count = line1.length() - line1.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line1.length() * (line1.length() - 1);
            ic1 = pt1 / pt2;

            System.out.println(df.format(ic1));
                        if (length == 1) {
                System.out.println("\nAverage index of coincidence: " + df.format(ic1));
            }
        }

        if (length >= 2 ) {
            String line2 = "";
            ArrayList<Character> list2 = new ArrayList<>();

            for (int i = 1; i < encrypted.length(); i += length) {
                line2 += encrypted.charAt(i);
            }

            for (int i = 0; i < line2.length(); i++) {
                for (int n = i+1; n < line2.length(); n++) {
                    if (line2.charAt(i) == line2.charAt(n) && !list2.contains(line2.charAt(i)))
                        list2.add(line2.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list2.size(); i++) {
                String letter = String.valueOf(list2.get(i));
                int count = line2.length() - line2.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line2.length() * (line2.length() - 1);
            ic2 = pt1 / pt2;

            System.out.println(df.format(ic2));

            if (length == 2) {
                double avg = (ic1 + ic2) / 2;
                System.out.println("\nAverage index of coincidence: " + df.format(avg));

            }
        }

        if (length >= 3) {
            String line3 = "";
            ArrayList<Character> list3 = new ArrayList<>();

            for (int i = 2; i < encrypted.length(); i += length) {
                line3 += encrypted.charAt(i);
            }

            for (int i = 0; i < line3.length(); i++) {
                for (int n = i+1; n < line3.length(); n++) {
                    if (line3.charAt(i) == line3.charAt(n) && !list3.contains(line3.charAt(i)))
                        list3.add(line3.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list3.size(); i++) {
                String letter = String.valueOf(list3.get(i));
                int count = line3.length() - line3.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line3.length() * (line3.length() - 1);
            ic3 = pt1 / pt2;

            System.out.println(df.format(ic3));

            if (length == 3) {
                double avg = (ic1 + ic2 + ic3) / 3;
                System.out.println("\nAverage index of coincidence: " + df.format(avg));

            }
        }

        if (length >= 4) {
            String line4 = "";
            ArrayList<Character> list4 = new ArrayList<>();

            for (int i = 3; i < encrypted.length(); i += length) {
                line4 += encrypted.charAt(i);
            }

            for (int i = 0; i < line4.length(); i++) {
                for (int n = i+1; n < line4.length(); n++) {
                    if (line4.charAt(i) == line4.charAt(n) && !list4.contains(line4.charAt(i)))
                        list4.add(line4.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list4.size(); i++) {
                String letter = String.valueOf(list4.get(i));
                int count = line4.length() - line4.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line4.length() * (line4.length() - 1);
            ic4 = pt1 / pt2;

            System.out.println(df.format(ic4));

            if (length == 4) {
                double avg = (ic1 + ic2 + ic3 + ic4) / 4;
                System.out.println("\nAverage index of coincidence: " + df.format(avg));

            }
        }

        if (length >= 5) {
            String line5 = "";
            ArrayList<Character> list5 = new ArrayList<>();

            for (int i = 4; i < encrypted.length(); i += length) {
                line5 += encrypted.charAt(i);
            }

            for (int i = 0; i < line5.length(); i++) {
                for (int n = i+1; n < line5.length(); n++) {
                    if (line5.charAt(i) == line5.charAt(n) && !list5.contains(line5.charAt(i)))
                        list5.add(line5.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list5.size(); i++) {
                String letter = String.valueOf(list5.get(i));
                int count = line5.length() - line5.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line5.length() * (line5.length() - 1);
            ic5 = pt1 / pt2;

            System.out.println(df.format(ic5));

            
            
           
            
            
            if (length == 5) {
                double avg = (ic1 + ic2 + ic3 + ic4 + ic5) / 5;
                System.out.println("\nAverage index of coincidence: " + df.format(avg));

            }
        }

        if (length >= 6) {
            String line6 = "";
            ArrayList<Character> list6 = new ArrayList<>();

            for (int i = 5; i < encrypted.length(); i += length) {
                line6 += encrypted.charAt(i);
            }

            for (int i = 0; i < line6.length(); i++) {
                for (int n = i+1; n < line6.length(); n++) {
                    if (line6.charAt(i) == line6.charAt(n) && !list6.contains(line6.charAt(i)))
                        list6.add(line6.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list6.size(); i++) {
                String letter = String.valueOf(list6.get(i));
                int count = line6.length() - line6.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line6.length() * (line6.length() - 1);
            ic6 = pt1 / pt2;

            System.out.println(df.format(ic6));

            if (length == 6) {
                double avg = (ic1 + ic2 + ic3 + ic4 + ic5 + ic6) / 6;
                System.out.println("\nAverage index of coincidence: " + df.format(avg));

            }
        }

        if (length >= 7) {
            String line7 = "";
            ArrayList<Character> list7 = new ArrayList<>();

            for (int i = 6; i < encrypted.length(); i += length) {
                line7 += encrypted.charAt(i);
            }

            for (int i = 0; i < line7.length(); i++) {
                for (int n = i+1; n < line7.length(); n++) {
                    if (line7.charAt(i) == line7.charAt(n) && !list7.contains(line7.charAt(i)))
                        list7.add(line7.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list7.size(); i++) {
                String letter = String.valueOf(list7.get(i));
                int count = line7.length() - line7.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line7.length() * (line7.length() - 1);
            ic7 = pt1 / pt2;

            System.out.println(df.format(ic7));

            if (length == 7) {
                double avg = (ic1 + ic2 + ic3 + ic4 + ic5 + ic6 + ic7) / 7;
                System.out.println("\nAverage index of coincidence: " + df.format(avg));

            }
        }

        if (length >= 8) {
            String line8 = "";
            ArrayList<Character> list8 = new ArrayList<>();

            for (int i = 7; i < encrypted.length(); i += length) {
                line8 += encrypted.charAt(i);
            }

            for (int i = 0; i < line8.length(); i++) {
                for (int n = i+1; n < line8.length(); n++) {
                    if (line8.charAt(i) == line8.charAt(n) && !list8.contains(line8.charAt(i)))
                        list8.add(line8.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list8.size(); i++) {
                String letter = String.valueOf(list8.get(i));
                int count = line8.length() - line8.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line8.length() * (line8.length() - 1);
            ic8 = pt1 / pt2;

            System.out.println(df.format(ic8));

            if (length == 8) {
                double avg = (ic1 + ic2 + ic3 + ic4 + ic5 + ic6 + ic7 + ic8) / 8;
                System.out.println("\nAverage index of coincidence: " + df.format(avg));
            }
        }

        if (length >= 9) {
            String line9 = "";
            ArrayList<Character> list9 = new ArrayList<>();

            for (int i = 8; i < encrypted.length(); i += length) {
                line9 += encrypted.charAt(i);
            }

            for (int i = 0; i < line9.length(); i++) {
                for (int n = i+1; n < line9.length(); n++) {
                    if (line9.charAt(i) == line9.charAt(n) && !list9.contains(line9.charAt(i)))
                        list9.add(line9.charAt(i));
                }
            }

            int sum = 0;
            for (int i = 0; i < list9.size(); i++) {
                String letter = String.valueOf(list9.get(i));
                int count = line9.length() - line9.replace(letter, "").length();
                sum = sum + (count * (count - 1));
            }

            double pt1 = sum;
            double pt2 = line9.length() * (line9.length() - 1);
            ic9 = pt1 / pt2;

            System.out.println(df.format(ic9));

            if (length == 9) {
                double avg = (ic1 + ic2 + ic3 + ic4 + ic5 + ic6 + ic7 + ic8 + ic9) / 9;
                System.out.println("\nAverage index of coincidence: " + df.format(avg));
                double i= max(ic9);
                System.out.println(i);
            }
        }
        //ADD FOR PART C
        // Pick the largest indices from your table
        //did not work
        System.out.println("HELLO");
        double i= max(ic9);  
        System.out.println(i);
    }

	private static double max(double ic9) {
		// TODO Auto-generated method stub
		return 0;
	}
}