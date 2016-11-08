    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class AssignNode implements INode {

    private AssignNode leftNode;
    private ExprNode rightNode;
    private Lexeme value;

    public AssignNode() {
    }

    public AssignNode(Lexeme current) {
        value = current;
    }


    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        leftNode.buildString(builder, tabs);
        tabs++;
        // köra egen stringbuilder
        tabs--;
        rightNode.buildString(builder, tabs);
    }

    public INode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AssignNode leftNode) {
        this.leftNode = leftNode;
    }

    public INode getRightNode() {
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
