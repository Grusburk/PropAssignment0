    package prop.assignment0;

/**
 * Created by matt on 2016-11-02.
 */
public class FactorNode implements INode {
    private INode rightNode;
    public Lexeme lexeme1, lexeme2;

    public FactorNode() {

    }

    public FactorNode(Lexeme current) {

    }


    @Override
    public Object evaluate(Object[] args) throws Exception {
        return null;
    }

    @Override
    public void buildString(StringBuilder builder, int tabs) {
        builder.append("FactorNode\n");
        System.out.println(rightNode);

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

    public void setChildNode(INode rightNode) {
        this.rightNode = rightNode;
    }

    public void setLexeme(Lexeme lexeme) {
        if (lexeme1 == null){
            lexeme1 = lexeme;
        }else {
            lexeme2 = lexeme;
        }
    }
}
