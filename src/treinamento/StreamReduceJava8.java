package treinamento;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceJava8 {

    public static void main(String[] args){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        String s = "Essa é uma String grande para testar reduce de concatenação";
        String[] split = s.split(" ");
        List<String> listStr = Arrays.asList(split);

        //reduce soma. Basicamente n1 e n2 são a primeira e a segunda posição da lista
        //Depois ele soma os 2 e o n1 torna-se o resultado da soma e o n2 pega a terceira posição da lista.
        //E sucessivamente.
        Optional<Integer> reduceSoma = list.stream()
                .reduce((n1, n2) -> n1 + n2);

        System.out.println(reduceSoma.get()); //21

        //Reduce - multiplicação
        Optional<Integer> reduceMultiplicacao = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(reduceMultiplicacao.get()); //720


        //Reduce - Concatenação
        Optional<String> reduceConcatenacao = listStr.stream()
                .reduce((s1, s2) -> s1.concat(s2));

        System.out.println(reduceConcatenacao.get()); //EssaéumaStringgrandeparatestarreducedeconcatenação




        //Esse próximo exemplo é um reduce que recebe 2 argumentos, sendo o primeiro deles um valor de identidade
        //O valor de identidade tem que ser um valor onde não faz diferençao uza-la na operação.
        //Ex.: Qualquer número somado com 0 é ele mesmo.
        //Isso é usado para caso uma lista venha vazia, o resultado é 0.
        Integer reduceSoma2 = list.stream()
                        .reduce(0, (n1, n2) -> n1 + n2);

        System.out.println(reduceSoma2); //21

        //Nesse caso, qualquer número multiplicado por 1 é ele mesmo.
        Integer reduceMultiplicacao2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(reduceMultiplicacao2); //720


        //Nesse caso, qualquer String concatenada com uma String vazia, é sempre ela mesma.
        String reduceConcatenacao2 = listStr.stream()
                .reduce("",(s1, s2) -> s1.concat(s2));

        System.out.println(reduceConcatenacao2); //EssaéumaStringgrandeparatestarreducedeconcatenação
    }

}
