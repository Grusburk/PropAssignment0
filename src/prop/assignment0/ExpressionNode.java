package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */

public class ExpressionNode implements INode {
    private INode termNode;
    private INode exprNode;
    public Lexeme lexeme;

    public ExpressionNode() {

    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        if (exprNode != null) {
            double d1 = Double.parseDouble(termNode.evaluate(args).toString());
            double d2 = Double.parseDouble(exprNode.evaluate(args).toString());
            if (lexeme.token() == Token.ADD_OP) {
                return d1 + d2;
            } else {
                return d1 - d2;
            }
        }
        return termNode.evaluate(args);
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        appendTab(builder, tabs);
        builder.append("ExpressionNode\n");
        tabs++;
        if (termNode != null){
            termNode.buildString(builder, tabs);
        }
        if (lexeme != null){
            appendTab(builder, tabs);
            builder.append(lexeme + "\n");
            if (exprNode != null){
                exprNode.buildString(builder, tabs);
            }
        }
    }

    private void appendTab (StringBuilder builder, int tabs) {
        for(int i = 0; i < tabs; i++){
            builder.append("\t");
        }
    }

    public void setTermNode(INode termNode) {
        this.termNode = termNode;
    }


    public void setExprNode(INode exprNode) {
        this.exprNode = exprNode;
    }


    public void setLexeme(Lexeme lexeme) {
        this.lexeme = lexeme;
    }
}
