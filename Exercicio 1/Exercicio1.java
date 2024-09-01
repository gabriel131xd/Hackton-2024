import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio1 {
    public static List<String> gerarAsteriscos(int n) {
        List<String> asteriscos = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            asteriscos.add("*".repeat(i));
        }
        return asteriscos;
    }

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("digite a um numero inteiro para(N):" );
        int n = sc.nextInt();
        List<String> resultado = gerarAsteriscos(n);
        System.out.println(resultado);
    }
}
/*
Pode Subistituir a linha 17 por int n = por um numero e comenta a linha 16 que tbm dar certo!
 lembrando que se fizer isso tire o sc.nextInt(); e coloque int n = numero exemplo int n=5;
*/
