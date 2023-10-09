package no.tobias.firstspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class numberGete {

    @Value("${jason.happyWord}")
    private String happyWord;

    @Value("${rnd.number}")
    private int number;


    public int getNumber() {
        System.out.println(happyWord);
        System.out.println("111111"+number);

        return number;
    }
}
