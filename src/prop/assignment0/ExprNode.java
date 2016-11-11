package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class ExprNode implements INode {
    private TermNode leftNode;
    private ExprNode rightNode;
    public Lexeme lexeme;

    public ExprNode() {

    }

    public ExprNode(Lexeme current) {
        lexeme = current;
    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return lexeme.value();
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("ExprNode\n");
//        leftNode.buildString(builder, tabs);
//        builder.append(lexeme.token() + " " + lexeme.value()  + "\n");
//        builder.append(rightNode.lexeme.token() + " " + rightNode.lexeme.value() + "\n");
    }

    public TermNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TermNode leftNode) {
        this.leftNode = leftNode;
    }

    public ExprNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(ExprNode rightNode) {
        this.rightNode = rightNode;
    }

    public Lexeme getLexeme() {
        return lexeme;
    }

    public void setLexeme(Lexeme lexeme) {
        this.lexeme = lexeme;
    }
}
