package br.ufscar.testes.xquery;

/*
 *   Copyright 2013 Daniel Gustavo San Martín Santibáñez

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */


import java.sql.SQLException;
import java.util.ArrayList;

import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.Close;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.DropDB;
import org.basex.core.cmd.Export;
import org.basex.core.cmd.Open;
import org.basex.query.QueryException;
import org.basex.query.QueryProcessor;
import org.basex.query.iter.Iter;
import org.basex.query.value.item.Item;



public class BaseXManager   {

	Context context; 
	CreateDB createDB;
	String path;
	Open openDb;
	Close closeDb;
	DropDB dropDB;
	Export export;

	public BaseXManager(String path, String file, String dbName) throws BaseXException
	{
		// Create a database from a local or remote XML document or XML String
		context = new Context();
		createDB = new CreateDB(dbName, path + file);
		createDB.execute(context);
		this.path = path + file; 
		openDb = new Open(dbName);
		closeDb = new Close();
		export = new Export(this.path); 
		dropDB = new DropDB(dbName);
	}

	public void createDB(String path, String file, String dbName) throws BaseXException {
		// TODO Auto-generated method stub
		context = new Context();
		createDB = new CreateDB(dbName, path + file);
		createDB.execute(context);
		openDb = new Open(dbName);
	}


	public void openDB() throws BaseXException
	{
		openDb.execute(context);
	}


	public void closeDB() throws BaseXException
	{
		closeDb.execute(context);
	}

	public void exportDB() throws BaseXException
	{
		export.execute(context);
	}

	public void dropDB() throws BaseXException
	{
		dropDB.execute(context);
	}

	public ArrayList<String> getCallsTo() throws SQLException, QueryException
	{
		ArrayList<String> arrayTo = new ArrayList<String>();
		String query = PropertyFileManager.getQuery("query-1");
		QueryProcessor proc = new QueryProcessor(query, context);
		// Execute the query
		Iter iter = proc.iter();
		Item item;

		while ((item = iter.next()) != null) 
		{
			arrayTo.add(item.toJava().toString());
		}
		proc.close();

		return arrayTo;
	}

	public ArrayList<String> getCallsFrom() throws SQLException, QueryException
	{
		ArrayList<String> arrayTo = new ArrayList<String>();
		String query = PropertyFileManager.getQuery("query-2");
		QueryProcessor proc = new QueryProcessor(query, context);
		// Execute the query
		Iter iter = proc.iter();
		Item item;

		while ((item = iter.next()) != null) 
		{
			arrayTo.add(item.toJava().toString());
		}
		proc.close();

		return arrayTo;
	}

	public ArrayList<String> getArtifactName(ArrayList<String> to , ArrayList<String> from) throws SQLException, QueryException
	{
		ArrayList<String> arrayList = new ArrayList<String>();	
		String iString = " let $prod := //kdm:Segment/";
		String fString = " return data($prod) ";
		String result = "";
		String modelE = "";
		QueryProcessor proc = null;
		String f1 = "";
	
		
		for (int i=0; i<to.size(); i++)
		{
			//Get path for each element of the array
			String line = to.get(i);
			String[] element = line.split("\\/");
			for (int j=0; j<element.length; j++)
			{ 
				if (j==2)
				{
					String[] modelElement = element[j].split("\\.");
					String mElement = modelElement[0].substring(1);
					int nElement = Integer.parseInt(modelElement[1]) + 1;
					modelE = mElement+"["+nElement+"]/";
				}	 
				
				if (j>2)
				{
					String[] codeElement = element[j].split("\\.");
					String sElement = codeElement[0].substring(1);
					int nElement = Integer.parseInt(codeElement[1]) + 1;
					String f1Element = sElement+"["+nElement+"]/@name";
					
					String query = PropertyFileManager.getQuery("query-3");
					query = query + iString + modelE + f1 + f1Element + fString;
					proc = new QueryProcessor(query, context);
					String name = proc.value().toJava().toString();
					proc.close();
				
					result = result+"."+name;
					
					f1Element = f1Element.substring(0, f1Element.length()-6);
					f1 = f1 + f1Element + "/";
				}
			}
			arrayList.add(result.substring(1)); 
			result = "";
			f1 = "";
			
		}
		
		for (int i=0; i<from.size(); i++)
		{
			//Get path for each element of the array
			String line = from.get(i);
			String[] element = line.split("\\/");
			for (int j=0; j<element.length; j++)
			{ 
				if (j==2)
				{
					String[] modelElement = element[j].split("\\.");
					String mElement = modelElement[0].substring(1);
					int nElement = Integer.parseInt(modelElement[1]) + 1;
					modelE = mElement+"["+nElement+"]/";
				}	 
				
				if (j>2)
				{
					String[] codeElement = element[j].split("\\.");
					String sElement = codeElement[0].substring(1);
					int nElement = Integer.parseInt(codeElement[1]) + 1;
					
					
					String f1Element = sElement+"["+nElement+"]/@name";
					String query = PropertyFileManager.getQuery("query-3");
					query = query + iString + modelE + f1 + f1Element + fString;
					proc = new QueryProcessor(query, context);
					String name = proc.value().toJava().toString();
					proc.close();

					result = result+"."+name;
					f1Element = f1Element.substring(0, f1Element.length()-6);
					f1 = f1 + f1Element + "/";
				}
			}
			String str = arrayList.get(i); 
			arrayList.set(i, result.substring(1) +" ----> "+str );
			result = "";
			f1 = "";
		}
	
		return arrayList;
	}
}
