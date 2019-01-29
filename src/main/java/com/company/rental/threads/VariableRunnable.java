package com.company.rental.threads;

import com.company.rental.model.Variable;
import com.company.rental.services.VariableService;

public class VariableRunnable implements Runnable{


    @Override
    public void run() {

        while (true) {
            VariableService.updateVariable();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
