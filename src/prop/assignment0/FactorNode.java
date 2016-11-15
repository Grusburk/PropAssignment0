    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class FactorNode implements INode {
    private Lexeme lexemeId, lexemeOp;
    private INode exprNode;

    @Override
    public Object evaluate(Object[] args) throws Exception {
        if (exprNode == null)
            return lexemeId.value();
        else
            return exprNode.evaluate(args);
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        appendTab(builder, tabs);
        builder.append("FactorNode\n");
        tabs++;

        switch (lexemeId.token()){
            case INT_LIT:
                appendTab(builder, tabs);
                builder.append(lexemeId + ".0\n");
                break;
            case IDENT:
                appendTab(builder, tabs);
                builder.append(lexemeId + "\n");
                break;
            case LEFT_PAREN:
                appendTab(builder, tabs);
                builder.append(lexemeId + "\n");
                if (exprNode != null){
                    exprNode.buildString(builder, tabs);
                }
                appendTab(builder, tabs);
                builder.append(lexemeOp + "\n");
        }
    }

    private void appendTab (StringBuilder builder, int tabs) {
        for(int i = 0; i < tabs; i++){
            builder.append("\t");
        }
    }

    public void setLexemeId(Lexeme lexemeId) {
        this.lexemeId = lexemeId;
    }

    public void setExprNode(INode exprNode) {
        this.exprNode = exprNode;
    }

    public void setLexemeOp(Lexeme lexemeOp) {
        this.lexemeOp = lexemeOp;
    }

}
