package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class ExpressionNode implements INode {
    private INode leftNode, rightNode;
    private Lexeme lexeme;

    public ExpressionNode() {

    }

    public ExpressionNode(Lexeme current) {
        lexeme = current;
    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return lexeme.value();
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("ExpressionNode\n");
//        leftNode.buildString(builder, tabs);
//        builder.append(lexeme.token() + " " + lexeme.value()  + "\n");
//        builder.append(rightNode.lexeme.token() + " " + rightNode.lexeme.value() + "\n");
    }

    public void setChildNode(INode node) {
        if (leftNode == null){
            leftNode = node;
        }else {
            rightNode = node;
        }
    }

    public Lexeme getLexeme() {
        return lexeme;
    }

    public void setLexeme(Lexeme lexeme) {
        this.lexeme = lexeme;
    }
}
