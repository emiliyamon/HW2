public class MultiProduct extends Function {
    public Function[] functions;

    public MultiProduct(Function... functions) {
        if (functions.length < 2) {
            throw new IllegalArgumentException("MultiProduct requires at least two functions");
        }
        this.functions = functions;
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

            Function multiProductI;

            if (makeMultiProductI.length > 2) {
                multiProductI = new MultiProduct(makeMultiProductI);
            } else if (makeMultiProductI.length == 2) {
                multiProductI = new Product(makeMultiProductI[0], makeMultiProductI[1]);
            } else {
                multiProductI = makeMultiProductI[0];
            }

            derivativeMultiProductI[i] = new Product(functionsDerivative[i], multiProductI);
        }

        if (derivativeMultiProductI.length > 2) {
            return new MultiSum(derivativeMultiProductI);
        } else if (derivativeMultiProductI.length == 2) {
            return new Sum(derivativeMultiProductI[0], derivativeMultiProductI[1]);
        } else {
            return derivativeMultiProductI[0];
        }
    }
}