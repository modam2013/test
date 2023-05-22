package com.example.test.servis;

import com.example.test.exception.DivByZeroException;
import org.springframework.stereotype.Service;


@Service
public class   CalculatorServis {
    public  Number plus(int a, int b){
        return a+b;
    }
    public Number minus( int a, int b){
        return a-b;
    }
    public Number umnogit(int a, int b){
        return a*b;
    }
    public Number podelit( int a, int b){
        if (b==0){
            throw new DivByZeroException();

        }

        return (double)a/b;
    }

}

