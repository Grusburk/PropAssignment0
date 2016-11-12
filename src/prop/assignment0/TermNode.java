    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class TermNode implements INode {

    private INode leftNode, rightNode;
    private Lexeme lexeme;

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
        System.out.println(leftNode);
        leftNode.buildString(builder, tabs);
//        leftNode.buildString(builder, tabs);
//        tabs++;
//        builder.append(leftNode.lexeme);
//        tabs--;
//        rightNode.buildString(builder, tabs);
//        builder.append(rightNode.lexeme);

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
