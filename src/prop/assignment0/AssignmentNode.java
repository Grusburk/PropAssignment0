    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class AssignmentNode implements INode {

    private INode exprNode;
    private Lexeme lexemeId, lexemeOp, lexemeSc;

    public AssignmentNode() {
    }

    public AssignmentNode(Lexeme current) {
        lexemeId = current;
    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        if (exprNode != null){
            String result = lexemeId.value() + " " + lexemeOp.value() + " " + exprNode.evaluate(args);
            return result;
        }
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        appendTab(builder, tabs);
        builder.append("AssignmentNode\n");
        tabs++;
        appendTab(builder, tabs);
        builder.append(lexemeId + "\n");
        appendTab(builder, tabs);
        builder.append(lexemeOp + "\n");
        if (exprNode != null){
            exprNode.buildString(builder, tabs);
        }
        appendTab(builder, tabs);
        builder.append(lexemeSc + "\n");
    }

    private void appendTab (StringBuilder builder, int tabs) {
        for(int i = 0; i < tabs; i++){
            builder.append("\t");
        }
    }

    public void setExprNode(INode exprNode) {
        this.exprNode = exprNode;
    }

    public void setLexemeId(Lexeme lexeme) {
        this.lexemeId = lexeme;
    }

    public void setLexemeOp(Lexeme lexeme) {
        this.lexemeOp = lexeme;
    }

    public void setLexemeSc(Lexeme lexeme) {
        this.lexemeSc = lexeme;
    }
}
