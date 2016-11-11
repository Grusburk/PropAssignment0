    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class FactorNode implements INode {
    private Lexeme leftNode;
    private ExprNode rightNode;
    public Lexeme lexeme;

    public FactorNode(Lexeme current) {

    }

    public Lexeme getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Lexeme leftNode) {
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

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("FactorNode\n");
        builder.append(lexeme.token() + " " + lexeme.value()  + "\n");
        builder.append(leftNode.token() + " " + leftNode.value() + "\n");
        builder.append(rightNode.lexeme.token() + " " + rightNode.lexeme.value() + "\n");
//        rightNode.buildString(builder, tabs);


//        rightNode.buildString(builder, tabs);
//        leftNode.buildString(builder, tabs);
//        tabs++;
//        builder.append(leftNode.lexeme);
//        tabs--;
//        rightNode.buildString(builder, tabs);
//        builder.append(rightNode.lexeme);

    }
}
