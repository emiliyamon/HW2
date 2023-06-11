public class Quotient extends Function {
    public Function[] functions;

    public Quotient(Function function1, Function function2) {
        this.functions = new Function[2];
        this.functions[0] = function1;
        this.functions[1] = function2;
    }


    @Override
    public double valueAt(double x) {
        double sum = functions[0].valueAt(x);
        sum /= functions[1].valueAt(x);
        return sum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i != functions.length - 1) {
                sb.append(" / ");
            }
        }
        sb.append(")");

        return sb.toString();
    }


    @Override
    public Function derivative() {
        Function[] functionsDerivative = new Function[functions.length];
        int i = 0;

        for (Function function : functions) {
            functionsDerivative[i] = function.derivative();
            i++;
        }
        return new Quotient((new Difference(new Product(functionsDerivative[0], this.functions[1]),
                new Product(this.functions[0], functionsDerivative[1]))),
                new Power(this.functions[1], 2));
    }

}
