import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio2Avancado {

    public static List<int[]> encontrarMenorDiferenca(int[] arr, boolean allowDuplicates, boolean sortedPairs, boolean uniquePairs) {
        // Ordenar manualmente o array
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int menorDiferenca = Integer.MAX_VALUE;
        List<int[]> pares = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int diferenca = arr[i + 1] - arr[i];
            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                pares.clear();
                if (verificarPar(arr[i], arr[i + 1], allowDuplicates, uniquePairs, pares)) {
                    pares.add(criarPar(arr[i], arr[i + 1], sortedPairs));
                }
            } else if (diferenca == menorDiferenca) {
                if (verificarPar(arr[i], arr[i + 1], allowDuplicates, uniquePairs, pares)) {
                    pares.add(criarPar(arr[i], arr[i + 1], sortedPairs));
                }
            }
        }
        return pares;
    }
    private static boolean verificarPar(int a, int b, boolean allowDuplicates, boolean uniquePairs, List<int[]> pares) {
        if (!allowDuplicates && a == b) {
            return false;
        }
        if (uniquePairs) {
            for (int[] par : pares) {
                if ((par[0] == a && par[1] == b) || (par[0] == b && par[1] == a)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static int[] criarPar(int a, int b, boolean sortedPairs) {
        if (sortedPairs && a > b) {
            return new int[]{b, a};
        }
        return new int[]{a, b};
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade de numeros:");
        int n = scanner.nextInt();
        int[] numeros = new int[n];
        System.out.println("Digite os numeros:");
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }
        System.out.println("Permitir duplicatas (true/false):");
        boolean allowDuplicates = scanner.nextBoolean();
        System.out.println("Ordenar pares (true/false):");
        boolean sortedPairs = scanner.nextBoolean();
        System.out.println("Apenas pares unicos (true/false):");
        boolean uniquePairs = scanner.nextBoolean();
        List<int[]> resultado = encontrarMenorDiferenca(numeros, allowDuplicates, sortedPairs, uniquePairs);
        System.out.println("Pares com a menor diferenca:");
        for (int[] par : resultado) {
            System.out.println("[" + par[0] + ", " + par[1] + "]");
        }
    }
}
