package prop.assignment0;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by matt on 2016-11-02.
 */
public class Parser implements IParser {
	
	private Tokenizer tokenizer;
	private ArrayList<INode> senteces = new ArrayList<>();
	private AssignNode assignNode;
	ExprNode exprNode;
	TermNode termNode;
	FactorNode factorNode;
	public Parser (){
		
	}
	
    @Override
    public void open(String fileName) throws IOException, TokenizerException {
		tokenizer = new Tokenizer();
		tokenizer.open(fileName);
		tokenizer.moveNext();
    }

    @Override
    public INode parse() throws IOException, TokenizerException, ParserException {
//		while loop, kolla typ(tokenizer.current().token(), assigna vänster, lexeme eller höger beroende på typ och regel.
//		while (tokenizer.current().token() != Token.EOF){
//		for (int i = 0; i != 3; i++){
//			constructAssignNode();
//			switch (tokenizer.current().token()){
//				case IDENT:
//				case SEMICOLON:
//				case ASSIGN_OP:
//					constructAssignNode();
//					break;
//				case ADD_OP:
//				case SUB_OP:
//					constructExprNode();
//					break;
//
//				case LEFT_PAREN:
//				case RIGHT_PAREN:
//				case INT_LIT:
////					constructFactorNode();
//					break;
//
//				case DIV_OP:
//				case MULT_OP:
////					constructTermNode();
//					break;
//			}
//		}

//		}
        return constructAssignNode();
    }

	private INode constructAssignNode() throws IOException, TokenizerException {
		assignNode = new AssignNode(tokenizer.current());
//		assignNode.setLexeme(tokenizer.current());
		tokenizer.moveNext();
		assignNode.setLeftNode(new AssignNode(tokenizer.current()));
		tokenizer.moveNext();
//		assignNode.setLexeme(tokenizer.current());
		tokenizer.moveNext();
		constructExprNode();
		assignNode.setRightNode(exprNode);


		return assignNode;
	}
	private INode constructExprNode() throws IOException, TokenizerException {
		exprNode = new ExprNode(tokenizer.current());
		tokenizer.moveNext();
		exprNode.setRightNode(new ExprNode(tokenizer.current()));
		tokenizer.moveNext();
		constructTermNode();
		exprNode.setLeftNode(termNode);

		return exprNode;
	}

	private INode constructTermNode() throws IOException, TokenizerException {
		termNode = new TermNode(tokenizer.current());
		tokenizer.moveNext();
		termNode.setRightNode(new TermNode(tokenizer.current()));
		tokenizer.moveNext();
		constructFactorNode();
		termNode.setLeftNode(factorNode);
		return termNode;
	}

	private INode constructFactorNode() throws IOException, TokenizerException {
		factorNode = new FactorNode(tokenizer.current());
		tokenizer.moveNext();
		factorNode.setLexeme(tokenizer.current());
		factorNode.setLeftNode(factorNode);
//		System.out.println(factorNode.getLeftNode());
		tokenizer.moveNext();
		factorNode.setLexeme(tokenizer.current());
		factorNode.setRightNode(factorNode);
//		System.out.println(factorNode.getRightNode());
		return factorNode;
	}
//
//
//	private INode constructBlockNode() {
//		//BlockNode blockNode = new BlockNode();
//        return null;
//	}
//
//	private INode constructStmtsNode(){
//		StmtsNode stmtsNode = new StmtsNode();
//		return null;
//	}
//

    @Override
    public void close() throws IOException {

    }
}
