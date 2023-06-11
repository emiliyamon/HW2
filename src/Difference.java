public class Difference extends Function {
    Function[] functions;

    public Difference(Function function1, Function function2) {
        this.functions = new Function[2];
        this.functions[0] = function1;
        this.functions[1] = function2;
    }


    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : functions) {
            sum -= function.valueAt(x);
        }
        return sum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Function function : functions) {
            String functionString = function.toString();
            sb.append("(");
            sb.append(functionString);
            sb.append(") - ");

        }
        for (int i = 0; i < 3; i++) { // eliminate the trailing symbol
            sb.deleteCharAt(sb.length() - 1); // check later if ok to use
        }
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
        return new Difference(functionsDerivative[0], functionsDerivative[1]);
    }

    public Function taylorPolynomial(int n) {
        return super.taylorPolynomial(n);
    }

}
