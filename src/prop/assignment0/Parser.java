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
    }

    @Override
    public INode parse() throws IOException, TokenizerException, ParserException {
		tokenizer.moveNext();
		INode node = assignNode;
		return assignNode;
    }

	private INode constructAssignNode() throws IOException, TokenizerException {
			assignNode = new AssignNode(tokenizer.current());
			tokenizer.moveNext();
			if (tokenizer.current().token() == Token.ASSIGN_OP){

			}
//		}
		return assignNode;
	}
	private INode constructExprNode() throws IOException, TokenizerException {
		exprNode = new ExprNode();
		exprNode.setLexeme(tokenizer.current());
//		assignNode.setRightNode(exprNode);
		tokenizer.moveNext();
//		exprNode.setRightNode(new ExprNode(tokenizer.current()));
		tokenizer.moveNext();

		return exprNode;
	}

	private INode constructTermNode() throws IOException, TokenizerException {
		termNode = new TermNode();
		termNode.setLexeme(tokenizer.current());
//		exprNode.setLeftNode(termNode);
		tokenizer.moveNext();
//		termNode.setRightNode(new TermNode(tokenizer.current()));
		tokenizer.moveNext();
		return termNode;
	}

	private INode constructFactorNode() throws IOException, TokenizerException {
		factorNode = new FactorNode();
		factorNode.setLexeme(tokenizer.current());
		termNode.setLeftNode(factorNode);
		tokenizer.moveNext();
		factorNode.setLeftNode(tokenizer.current());
		tokenizer.moveNext();
//		factorNode.setRightNode(exprNode.getRightNode());
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
