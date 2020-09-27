package com.enot.neuralNetwork;

import static com.enot.neuralNetwork.MainApp.*;

class NeuralOperations {

    void parityTraining(int letter, int teta) {
        int sum = 0;
        int out;
        int coefficient;    // TODO
        for (int i = 0; i < COUNT_OF_SIGNALS; i++) {
            coefficient = list.get(letter).charAt(i);
            sum += coefficient * weight.get(i);
            //sum += ABC[letter][i] * W[i];
        }
        out = output(teta, sum);
        if (out != correctResult.get(letter))
            if (out == 0)
                for (int i = 0; i < COUNT_OF_SIGNALS; i++)
                    weight.set(i, weight.get(i) + list.get(letter).charAt(i));
            else
                for (int i = 0; i < COUNT_OF_SIGNALS; i++)
                    weight.set(i, weight.get(i) - list.get(letter).charAt(i));
    }


    int output(int teta, int sum) {
        if (sum >= teta)
            return 1;
        else
            return 0;
    }
}