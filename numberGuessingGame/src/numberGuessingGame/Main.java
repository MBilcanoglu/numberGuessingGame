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
			System.out.print("Lütfen tahmini giriniz: ");
			selected = scan.nextInt();

			if (selected < 0 || selected > 99) {
				System.out.println("Lütfen 0 ila 100 arasýnda bir deðer giriniz.");
				if (isWrong) {
					right++;
					System.out.println("Çok fazla hatalý giriþ yaptýnýz. Kalan hak : " + (5 - right));
				} else {
					isWrong = true;
					System.out.println("Bir daha hatalý giriþinizde hakkýnýzdan düþülecektir.");
				}
				continue;
			}

			if (selected == number) {
				System.out.println("Tebrikler doðru tahmin! Tahmin edilen sayý: " + number);
				isWin = true;
				break;
			} else {
				System.out.println("Hatalý bir sayý girdiniz!");
				if (selected > number) {
					System.out.println("Girilen sayý büyüktür!!!");
				} else {
					System.out.println("Girilen sayý küçüktür!!!");
				}
				wrong[right] = selected;
				right++;
			}
			System.out.println("Kalan tahmin hakký: " + (5 - right));
		}

		if (!isWin) {
			System.out.println("***Kaybettiniz***");
			if (!isWrong) {
				System.out.println("Tahminleriniz: " + Arrays.toString(wrong));
			}
		}
	}

}
