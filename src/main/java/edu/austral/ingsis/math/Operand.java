package edu.austral.ingsis.math;

public class Operand implements Evaluable {

    final String name;
    double value;

    public Operand(double value) {
        this.name = String.valueOf(value);
        this.value = value;
    }

    public Operand(String name) {
        this.name = name;
        this.value = Double.NaN;
    }

    public Operand(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    @Override
    public double evaluate() {
        return value;
    }
}

