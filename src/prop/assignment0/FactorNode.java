    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class FactorNode implements INode {
    private FactorNode leftNode;
    private FactorNode rightNode;
    public Lexeme lexeme;

    public FactorNode(Lexeme current) {

    }

    public FactorNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(FactorNode leftNode) {
        this.leftNode = leftNode;
    }

    public FactorNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(FactorNode rightNode) {
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
//        System.out.println(rightNode.lexeme);
        builder.append(leftNode.lexeme.token() + " " + leftNode.lexeme.value() + "\n");
        builder.append(rightNode.lexeme.token() + " " + rightNode.lexeme.value() + "\n");


//        rightNode.buildString(builder, tabs);
//        leftNode.buildString(builder, tabs);
//        tabs++;
//        builder.append(leftNode.lexeme);
//        tabs--;
//        rightNode.buildString(builder, tabs);
//        builder.append(rightNode.lexeme);

    }
}
