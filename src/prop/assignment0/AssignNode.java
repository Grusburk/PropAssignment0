    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class AssignNode implements INode {

    private AssignNode leftNode;
    private ExprNode rightNode;
    private Lexeme lexeme;

    public AssignNode() {
    }

    public AssignNode(Lexeme current) {
        lexeme = current;
    }


    @Override
    public Object evaluate(Object[] args) throws Exception {
        return lexeme.value();
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("AssignmentNode\n");
        tabs++;
        builder.append(lexeme.token() + " " + lexeme.value()  + "\n");
        tabby(builder, tabs);
        builder.append(leftNode.lexeme.token() + " " + leftNode.lexeme.value() + "\n");
        tabby(builder, tabs);
        rightNode.buildString(builder, tabs);
        tabby(builder, tabs);
//        tabs++;
//        builder.append(rightNode.lexeme.token() + "" + leftNode.lexeme.lexeme());

//        builder.append(lexeme.token() + " " + lexeme.lexeme()+ "\n hejhej");


//        leftNode.buildString(builder, tabs);
//        tabs++;
//        builder.append(leftNode.lexeme);
//        tabs--;
//        rightNode.buildString(builder, tabs);
//        builder.append(rightNode.lexeme);
    }

    private void tabby(StringBuilder builder, int tabs) {
        for (int i = 0; i < tabs; i++) {
            builder.append("    ");
        }
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

    public Lexeme getLexeme() {
        return lexeme;
    }

    public void setLexeme(Lexeme lexeme) {
        this.lexeme = lexeme;
    }
}
