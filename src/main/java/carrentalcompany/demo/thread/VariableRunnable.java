package carrentalcompany.demo.thread;

import carrentalcompany.demo.model.Variable;

public class VariableRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            Variable.setVariableValue();
            Variable.getVariable();
            System.out.println(Variable.getVariable());
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
