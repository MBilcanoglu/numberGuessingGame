package numberGuessingGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		int number = random.nextInt(100);
		Scanner scan = new Scanner(System.in);
		int right = 0;
		int selected;
		boolean isWin = false;
		boolean isWrong = false;
		int[] wrong = new int[5];
		while (right < 5) {
			System.out.print("L�tfen tahmini giriniz: ");
			selected = scan.nextInt();

			if (selected < 0 || selected > 99) {
				System.out.println("L�tfen 0 ila 100 aras�nda bir de�er giriniz.");
				if (isWrong) {
					right++;
					System.out.println("�ok fazla hatal� giri� yapt�n�z. Kalan hak : " + (5 - right));
				} else {
					isWrong = true;
					System.out.println("Bir daha hatal� giri�inizde hakk�n�zdan d���lecektir.");
				}
				continue;
			}

			if (selected == number) {
				System.out.println("Tebrikler do�ru tahmin! Tahmin edilen say�: " + number);
				isWin = true;
				break;
			} else {
				System.out.println("Hatal� bir say� girdiniz!");
				if (selected > number) {
					System.out.println("Girilen say� b�y�kt�r!!!");
				} else {
					System.out.println("Girilen say� k���kt�r!!!");
				}
				wrong[right] = selected;
				right++;
			}
			System.out.println("Kalan tahmin hakk�: " + (5 - right));
		}

		if (!isWin) {
			System.out.println("***Kaybettiniz***");
			if (!isWrong) {
				System.out.println("Tahminleriniz: " + Arrays.toString(wrong));
			}
		}
	}

}
