package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class ExprNode implements INode {
    private TermNode leftNode;
    private ExprNode rightNode;
    private Lexeme value;

    public ExprNode(Lexeme current) {
        value = current;
    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {

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

    public Lexeme getValue() {
        return value;
    }

    public void setValue(Lexeme value) {
        this.value = value;
    }
}
