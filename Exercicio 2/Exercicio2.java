import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio2 {
    public static List<int[]> encontrarMenorDiferenca(int[] arr) {
        Arrays.sort(arr);
        int menorDiferenca = Integer.MAX_VALUE;
        List<int[]> pares = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int diferenca = arr[i + 1] - arr[i];
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                pares.clear();
                pares.add(new int[]{arr[i], arr[i + 1]});
            } else if (diferenca == menorDiferenca) {
                pares.add(new int[]{arr[i], arr[i + 1]});
            }
        }
        return pares;
    }

    public static void main(String[] args) {
        int[] numeros = {2, 9, 1, 7, 5};
        List<int[]> resultado = encontrarMenorDiferenca(numeros);
        for (int[] par : resultado) {
            System.out.println(Arrays.toString(par));
        }
    }
}
