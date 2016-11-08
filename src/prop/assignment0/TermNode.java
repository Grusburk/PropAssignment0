    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class TermNode implements INode {

    private FactorNode leftNode;
    private TermNode rightNode;
    private Lexeme value;
    public TermNode(Lexeme current) {
        value = current;
    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {

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

    public Lexeme getValue() {
        return value;
    }

    public void setValue(Lexeme value) {
        this.value = value;
    }
}
