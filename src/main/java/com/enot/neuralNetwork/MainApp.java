package com.enot.neuralNetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static NeuralOperations neuralOperations = new NeuralOperations();
    public static final int COUNT_OF_NUMBERS = 10;
    public static final int COUNT_OF_SIGNALS = 12;
    public static ArrayList<Integer> weight;
    public static ArrayList<Integer> oldWeight;
    public static List<String> list = Arrays.asList(
            "010011011000",   //0
            "010110010111",   //1
            "011101010111",   //2
            "010010010110",   //3
            "110110010010",   //4
            "011011101111",   //5
            "010110111110",   //6
            "111011010010",   //7
            "010011110110",   //8
            "010010110000"   //9
    );
    public static ArrayList<Integer> correctResult =
            new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 0, 1, 0, 1, 0)); //четное - 1, нечетное - 0


    public static void main(String[] args) {
        weight = new ArrayList<>(Arrays.asList(4, 3, 5, -4, 3, 1, -6, -1, 2, 6, -3, 4)); //весовые коэффициенты
        int teta = 1;

        boolean flag = true;
        //TODO БЛОК ТРЕНИРОВКИ
        while (flag) {
            oldWeight = new ArrayList<>();
            for (int i = 0; i < COUNT_OF_SIGNALS; i++)
                oldWeight.add(weight.get(i));

            for (int i = 0; i < COUNT_OF_NUMBERS; i++)
                neuralOperations.parityTraining(i, teta);

            int lenght = 0;
            for (int i = 0; i < COUNT_OF_SIGNALS; i++)
                lenght += Math.pow((oldWeight.get(i) - weight.get(i)), 2);
            if (lenght == 0)
                flag = false;

            /*// как меняются веса
            for(int i=0;i<weight.size();i++){
                System.out.print(weight.get(i)+" , ");
            }
            System.out.println();*/
        }


        System.out.println("\nВ итоге веса получились такими: ");
        for (int i = 0; i < COUNT_OF_SIGNALS; i++) {
            System.out.print(weight.get(i) + "\t");
        }
        System.out.println("\n");

        //теперь наш перцептрон обучен, проверим
        int sum;
        int coefficient;
        System.out.println("Вот, что получилось в итоге: ");
        for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
            sum = 0;
            for (int j = 0; j < COUNT_OF_SIGNALS; j++) {
                coefficient = (list.get(i)).charAt(j);
                sum += coefficient * weight.get(j);
            }
            System.out.print(neuralOperations.output(teta, sum));
        }
        System.out.println();
    }


}