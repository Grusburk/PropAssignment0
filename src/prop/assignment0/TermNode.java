    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class TermNode implements INode {

    private INode factorNode, termNode;
    private Lexeme lexeme;

    @Override
    public Object evaluate(Object[] args) throws Exception {
        double d1 = (double)factorNode.evaluate(args);
        double d2 = (double)termNode.evaluate(args);
        if (lexeme.token() == Token.MULT_OP) {
            return d1 * d2;
        } else {
            return d1 / d2;
        }
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        appendTab(builder, tabs);
        builder.append("TermNode\n");
        tabs++;
        if (factorNode != null){
            factorNode.buildString(builder, tabs);
        }
        if (lexeme != null){
            appendTab(builder, tabs);
            builder.append(lexeme + "\n");
            if (termNode != null){
                termNode.buildString(builder, tabs);
            }
        }

    }

    private void appendTab (StringBuilder builder, int tabs) {
        for(int i = 0; i < tabs; i++){
            builder.append("\t");
        }
    }

    public void setFactorNode(INode factorNode) {
        this.factorNode = factorNode;
    }

    public void setTermNode(INode termNode) {
        this.termNode = termNode;
    }

    public void setLexeme(Lexeme lexeme) {
        this.lexeme = lexeme;
    }
}
