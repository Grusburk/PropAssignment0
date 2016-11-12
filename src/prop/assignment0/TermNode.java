    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class TermNode implements INode {

    private INode factorNode;
    private INode termNode;
    public Lexeme lexeme;

//    public TermNode() {
//
//    }
//
//    public TermNode(Lexeme current) {
//        lexeme = current;
//    }

    @Override
    public Object evaluate(Object[] args) throws Exception {
        return lexeme.value();
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("TermNode\n");
        System.out.println(factorNode);
        factorNode.buildString(builder, tabs);
//        builder.append(termNode.lexeme.token() + " " + factorNode.lexeme.value() + "\n");
//        leftNode.buildString(builder, tabs);
//        tabs++;
//        builder.append(leftNode.lexeme);
//        tabs--;
//        rightNode.buildString(builder, tabs);
//        builder.append(rightNode.lexeme);

    }

//    public FactorNode getLeftNode() {
//        return leftNode;
//    }

    public void setFactorNode(INode factorNode) {
        this.factorNode = factorNode;
    }

//    public TermNode getRightNode() {
//        return rightNode;
//    }

    public void setTermNode(INode termNode) {
        this.termNode = termNode;
    }

//    public Lexeme getLexeme() {
//        return lexeme;
//    }

    public void setLexeme(Lexeme lexeme) {
        this.lexeme = lexeme;
    }
}
