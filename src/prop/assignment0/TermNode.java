    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class TermNode implements INode {

    private FactorNode leftNode;
    private TermNode rightNode;
    public Lexeme lexeme;

    public TermNode() {

    }

    public TermNode(Lexeme current) {
        lexeme = current;
    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return lexeme.value();
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("TermNode\n");
        builder.append(lexeme.token() + " " + lexeme.value()  + "\n");
        leftNode.buildString(builder, tabs);
        builder.append(rightNode.lexeme.token() + " " + rightNode.lexeme.value() + "\n");
//        leftNode.buildString(builder, tabs);
//        tabs++;
//        builder.append(leftNode.lexeme);
//        tabs--;
//        rightNode.buildString(builder, tabs);
//        builder.append(rightNode.lexeme);

    }

    public FactorNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(FactorNode leftNode) {
        this.leftNode = leftNode;
    }

    public TermNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TermNode rightNode) {
        this.rightNode = rightNode;
    }

    public Lexeme getLexeme() {
        return lexeme;
    }

    public void setLexeme(Lexeme lexeme) {
        this.lexeme = lexeme;
    }
}
