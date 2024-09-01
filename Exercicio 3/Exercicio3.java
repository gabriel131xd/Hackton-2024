import java.util.ArrayList;
import java.util.List;

public class Exercicio3 {
    public static List<List<Integer>> encontrarSubconjuntos(int[] nums) {
        List<List<Integer>> subconjuntos = new ArrayList<>();
        gerarSubconjuntos(0, nums, new ArrayList<>(), subconjuntos);
        return subconjuntos;
    }

    private static void gerarSubconjuntos(int index, int[] nums, List<Integer> subconjuntoAtual, List<List<Integer>> subconjuntos) {
        subconjuntos.add(new ArrayList<>(subconjuntoAtual));

        for (int i = index; i < nums.length; i++) {
            subconjuntoAtual.add(nums[i]);
            gerarSubconjuntos(i + 1, nums, subconjuntoAtual, subconjuntos);
            subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] numeros = {5,6};
        List<List<Integer>> resultado = encontrarSubconjuntos(numeros);
        for (List<Integer> subconjunto : resultado) {
            System.out.println(subconjunto);
        }
    }
}
