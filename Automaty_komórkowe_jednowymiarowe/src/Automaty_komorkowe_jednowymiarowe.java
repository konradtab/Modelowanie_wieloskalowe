import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Konrad Tabiś on 19.04.2018.
 */

public class Automaty_komorkowe_jednowymiarowe {
    public static void main(String [] args)
    {
        int rozmiar=10;
        int [] tablica= new int [rozmiar];
        int [] temp= new int [rozmiar];
        for (int i=0;i<rozmiar;i++)
        {
            tablica[i]=0;
        }
        tablica[4]=1;

        System.out.print("Podaj metodę:");
        Scanner scanner= new Scanner(System.in);
        int choice =scanner.nextInt();
        boolean [] bits2= new boolean[8];
        bits2=toBinary(choice,8);
        System.out.println(choice + " = " + Arrays.toString(bits2));


        int prev, current, next;
        System.out.println(Arrays.toString(tablica));
        for(int i=0; i<10; i++)
        {
            for (int g = 0; g < rozmiar; g++) {
                if (g == 0) {
                    prev = tablica[(rozmiar - 1)];
                    next = tablica[(g + 1)];
                    current = tablica[g];
                } else if (g == (rozmiar - 1)) {
                    prev = tablica[(g - 1)];
                    next = tablica[0];
                    current = tablica[g];
                } else {
                    prev = tablica[(g - 1)];
                    next = tablica[(g + 1)];
                    current = tablica[g];
                }
                //reguła
                if (prev == 1 && current == 1 && next == 1)
                    temp[g] = bits2[0]? 1 : 0;
                if (prev == 1 && current == 1 && next == 0)
                    temp[g] = bits2[1]? 1 : 0;
                if (prev == 1 && current == 0 && next == 1)
                    temp[g] = bits2[2]? 1 : 0;
                if (prev == 1 && current == 0 && next == 0)
                    temp[g] = bits2[3]? 1 : 0;
                if (prev == 0 && current == 1 && next == 1)
                    temp[g] = bits2[4]? 1 : 0;
                if (prev == 0 && current == 1 && next == 0)
                    temp[g] = bits2[5]? 1 : 0;
                if (prev == 0 && current == 0 && next == 1)
                    temp[g] = bits2[6]? 1 : 0;
                if (prev == 0 && current == 0 && next == 0)
                    temp[g] = bits2[7]? 1 : 0;
            }
            for (int j = 0; j < rozmiar; j++) {
                tablica[j] = temp[j];
            }
            System.out.println(Arrays.toString(tablica));
        }
    }

    private static boolean[] toBinary(int number, int base) {
        final boolean[] ret = new boolean[base];
        for (int i = 0; i < base; i++) {
            ret[base - 1 - i] = (1 << i & number) != 0;
        }
        return ret;
    }
}
