public class MultiSum extends Function {
    public Function[] functions;

    public MultiSum(Function... functions) {
        if (functions.length < 2) {
            throw new IllegalArgumentException("MultiSum requires at least two functions");
        }
        this.functions = functions;
    }


    @Override
    public double valueAt(double x) {
        double sum = 0.0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (int i = 0; i < functions.length; i++) {
            sb.append(functions[i].toString());
            if (i != functions.length - 1) {
                sb.append(" + ");
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

        if (functionsDerivative.length > 2) {
            return new MultiSum(functionsDerivative);
        } else if (functionsDerivative.length == 2) {
            return new Sum(functionsDerivative[0], functionsDerivative[1]);
        } else {
            return functionsDerivative[0];
        }
    }
}
