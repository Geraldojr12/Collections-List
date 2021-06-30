package com.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<TimesDeFutebol> times = new ArrayList<>(){{
            add(new TimesDeFutebol("Cruzeiro",100, "azul"));
            add(new TimesDeFutebol("Atletico Mg", 113, "preto"));
            add(new TimesDeFutebol("America Mg", 109, "verde"));
            add(new TimesDeFutebol("Atletico Pr", 97, "preto"));
        }};
        System.out.println(times);

        System.out.println("--\t0rdem de insercao\t--");
        System.out.println(times);

        System.out.println("--\tOrdem aleátoria\t--");
        Collections.shuffle(times);
        System.out.println(times);

        System.out.println("--\tOrdem natural(Nome)\t--");
        Collections.sort(times);
        System.out.println(times);

        System.out.println("--\tOrdem Idade\t--");
        //Collections.sort(times, new ComparatorIdade());
        times.sort(new ComparatorIdade());
        System.out.println(times);

        System.out.println("--\tOrdem Cor\t--");
        times.sort(new ComparatorCor());
        System.out.println(times);

        System.out.println("--\tOrdem Nome/Cor/Idade\t--");
        times.sort(new ComparatorNomeCorIdade());
        System.out.println(times);
    }
}

class TimesDeFutebol implements  Comparable<TimesDeFutebol>{
    private String Nome;
    private Integer IdadeTime;
    private String Cor;

    public String getNome() {
        return Nome;
    }

    public Integer getIdadeTime() {
        return IdadeTime;
    }

    public String getCor() {
        return Cor;
    }

    @Override
    public String toString() {
        return "{" +
                "Nome='" + Nome + '\'' +
                ", IdadeTime=" + IdadeTime +
                ", Cor='" + Cor + '\'' +
                '}';
    }

    public TimesDeFutebol(String nome, Integer idadeTime, String cor) {
        Nome = nome;
        IdadeTime = idadeTime;
        Cor = cor;
    }

    @Override
    public int compareTo(TimesDeFutebol times) {
        return this.getNome().compareToIgnoreCase(times.getNome());
    }
}
    class ComparatorIdade implements Comparator<TimesDeFutebol>{
        @Override
        public int compare(TimesDeFutebol t1, TimesDeFutebol t2) {
            return Integer.compare(t1.getIdadeTime(), t2.getIdadeTime());
        }
    }
 class ComparatorCor implements Comparator<TimesDeFutebol>{
     @Override
     public int compare(TimesDeFutebol t1, TimesDeFutebol t2) {
         return t1.getCor().compareToIgnoreCase(t2.getCor());
     }
 }
class ComparatorNomeCorIdade implements Comparator<TimesDeFutebol>{
    @Override
    public int compare(TimesDeFutebol t1, TimesDeFutebol t2) {
            int nome = t1.getNome().compareToIgnoreCase(t2.getNome());
            if(nome != 0) return nome;

            int cor = t1.getCor().compareToIgnoreCase(t2.getCor());
            if(cor != 0 ) return cor;

            return Integer.compare(t1.getIdadeTime(), t2.getIdadeTime());
    }
}