    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class FactorNode implements INode {
    private Lexeme lexemeId, lexemeOp;
    private ExprNode exprNode;

//    public FactorNode(Lexeme current) {
//
//    }
//
//    public FactorNode() {
//
//    }

//    public Lexeme getLeftNode() {
//        return leftNode;
//    }
    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    public void setLexemeId(Lexeme lexemeId) {
        this.lexemeId = lexemeId;
    }

//    public ExprNode getRightNode() {
//        return rightNode;
//    }

    public void setExprNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }

//    public Lexeme getLexeme() {
//        return lexeme;
//    }

    public void setLexemeOp(Lexeme lexemeOp) {
        this.lexemeOp = lexemeOp;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("FactorNode\n");
        System.out.println(exprNode);

//        builder.append(lexeme.token() + " " + lexeme.value()  + "\n");
//        builder.append(leftNode.token() + " " + leftNode.value() + "\n");
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
