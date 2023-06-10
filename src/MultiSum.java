public class MultiSum extends Function {
    public Function[] functions;

    public MultiSum(Function function1, Function function2, Function... moreFunctions) {
        this.functions = new Function[2 + moreFunctions.length];
        functions[0] = function1;
        functions[1] = function2;
        for (int i = 2; i < moreFunctions.length; i++) {
            functions[i] = moreFunctions[i];
        }
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

        Function[] functionsDerivativeConstructor = new Function[functionsDerivative.length - 2];
        for (int k = 0; k < functionsDerivativeConstructor.length; k++) {
            functionsDerivativeConstructor[k] = functionsDerivative[k+2];
        }
        return new MultiSum(functionsDerivative[0], functionsDerivative[1], functionsDerivativeConstructor);
    }
}
