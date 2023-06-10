public class MultiProduct extends Function {
    public Function[] functions;

    public MultiProduct(Function... functions) {
        this.functions = functions;
        // add test to make compile-time error for less than 2 functions
    }


    @Override
    public double valueAt(double x) {
        double value = 1.0;
        for (Function function : functions) {
            value *= function.valueAt(x);
        }
        return value;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Function function : this.functions) {
            sb.append("(");
            sb.append(function.toString());
            sb.append(") * ");
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

        Function[] derivativeMultiProductI = new Function[functions.length];

        for (i = 0; i < functions.length; i++) {
            Function[] makeMultiProductI = new Function[functions.length - 1];
            for (int j = 0; j < makeMultiProductI.length; j++) {
                if (j != i) {
                    makeMultiProductI[j] = functions[j];
                }
            }
            Function multiProductI = new MultiProduct(makeMultiProductI);
            derivativeMultiProductI[i] = new Product(functionsDerivative[i], multiProductI);
        }

        return new MultiSum(derivativeMultiProductI);
    }
}
