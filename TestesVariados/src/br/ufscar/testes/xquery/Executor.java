package br.ufscar.testes.xquery;

import java.sql.SQLException;
import java.util.ArrayList;

import org.basex.core.BaseXException;
import org.basex.query.QueryException;

public class Executor {

	public static void main(String[] args) throws SQLException, QueryException {

		
		//Open query file
		PropertyFileManager.getQueries();
		try 
		{
			//Load KDM model
			BaseXManager baseXManager = new BaseXManager("./","SystemExampleMVC-Simples_kdm.xmi","kdm");
			//Open KDM model
			baseXManager.openDB();
			
			//Method who call
			ArrayList<String> arrTo = baseXManager.getCallsTo();
			//System.out.println(arrTo.size());
			//for(String line: arrTo)
			//	System.out.println(line);
			
			//Method Called
			ArrayList<String> arrFrom = baseXManager.getCallsFrom();
			//System.out.println(arrFrom.size());
			//for(String line: arrFrom)
			//	System.out.println(line);
			
			//Method Calls
			ArrayList<String> arrCheck = baseXManager.getArtifactName(arrTo,arrFrom);
			
			for(String s:arrCheck)
				System.out.println(s);
			
			//Close KDM Model
			baseXManager.closeDB();

		} catch (BaseXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
