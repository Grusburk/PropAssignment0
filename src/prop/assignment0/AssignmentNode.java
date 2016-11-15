    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class AssignmentNode implements INode {

    private INode exprNode;
    private Lexeme lexemeId , lexemeOp, lexemeCurrent;

    public AssignmentNode() {
    }

    public AssignmentNode(Lexeme current) {
        lexemeCurrent = current;
    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        if (exprNode != null){
            return exprNode.evaluate(args);
        }
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        appendTab(builder, tabs);
        builder.append("AssignmentNode\n");
        tabs++;
        appendTab(builder, tabs);
        builder.append(lexemeCurrent + "\n");
        appendTab(builder, tabs);
        builder.append(lexemeOp + "\n");
        if (exprNode != null){
            exprNode.buildString(builder, tabs);
        }
        appendTab(builder, tabs);
        builder.append(lexemeId + "\n");
    }

    private void appendTab (StringBuilder builder, int tabs) {
        for(int i = 0; i < tabs; i++){
            builder.append("\t");
        }
    }

    public void setChild(INode childNode) {
        this.exprNode = childNode;
    }

    public void setLexemeId(Lexeme lexeme) {
        this.lexemeId = lexeme;
    }

    public void setLexemeOp(Lexeme lexeme) {
        this.lexemeOp = lexeme;
    }

    public void setLexemeCurrent(Lexeme lexeme) {
        this.lexemeCurrent = lexeme;
    }

}
