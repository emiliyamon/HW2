public class Quotient extends Function {
    private Function[] functions;

    public Quotient(Function function1, Function function2) {
        this.functions = new Function[2];
        this.functions[0] = function1;
        this.functions[1] = function2;
    }

    public Function[] getFunctions() {
        return functions;
    }

    public void setFunctions(Function[] functions) {
        this.functions = functions;
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

        for (Function function : functions) {
            String functionString = function.toString();
            sb.append("(");
            sb.append(functionString);
            sb.append(")/");

        }
        sb.deleteCharAt(sb.length() - 1); // check later if ok to use
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
