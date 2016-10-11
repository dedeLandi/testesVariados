package br.ufscar.testes.instanciacaoArquiteturaArtigo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmt.modisco.omg.kdm.action.ActionElement;
import org.eclipse.gmt.modisco.omg.kdm.action.ActionFactory;
import org.eclipse.gmt.modisco.omg.kdm.action.Calls;
import org.eclipse.gmt.modisco.omg.kdm.action.Creates;
import org.eclipse.gmt.modisco.omg.kdm.action.UsesType;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeElement;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeFactory;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeModel;
import org.eclipse.gmt.modisco.omg.kdm.code.Extends;
import org.eclipse.gmt.modisco.omg.kdm.code.HasValue;
import org.eclipse.gmt.modisco.omg.kdm.code.Implements;
import org.eclipse.gmt.modisco.omg.kdm.code.Imports;
import org.eclipse.gmt.modisco.omg.kdm.code.Module;
import org.eclipse.gmt.modisco.omg.kdm.core.AggregatedRelationship;
import org.eclipse.gmt.modisco.omg.kdm.core.CoreFactory;
import org.eclipse.gmt.modisco.omg.kdm.core.KDMRelationship;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmFactory;
import org.eclipse.gmt.modisco.omg.kdm.kdm.KdmPackage;
import org.eclipse.gmt.modisco.omg.kdm.kdm.Segment;
import org.eclipse.gmt.modisco.omg.kdm.structure.AbstractStructureElement;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureFactory;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureModel;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

public class Instanciar {

	public static void main(String[] args) {
		//criar raiz
		Segment raizKDM = KdmFactory.eINSTANCE.createSegment();
		raizKDM.setName("Planned Architecture");

		//criar modelo
		StructureModel structureModel = StructureFactory.eINSTANCE.createStructureModel();
		structureModel.setName("Planned Architecture");

		raizKDM.getModel().add(structureModel);

		Subsystem ss1 = StructureFactory.eINSTANCE.createSubsystem();
		ss1.setName("ss1");
		structureModel.getStructureElement().add(ss1);

		//criar layer
		Layer l3 = StructureFactory.eINSTANCE.createLayer();
		l3.setName("l3");
		ss1.getStructureElement().add(l3);

		//criar layer
		Layer l4 = StructureFactory.eINSTANCE.createLayer();
		l4.setName("l4");
		l3.getStructureElement().add(l4);

		//criar layer
		Layer l5 = StructureFactory.eINSTANCE.createLayer();
		l5.setName("l5");
		l3.getStructureElement().add(l5);

		//criar layer
		Layer l2 = StructureFactory.eINSTANCE.createLayer();
		l2.setName("l2");
		ss1.getStructureElement().add(l2);

		Component c1 = StructureFactory.eINSTANCE.createComponent();
		c1.setName("c1");
		l2.getStructureElement().add(c1);

		Component c2 = StructureFactory.eINSTANCE.createComponent();
		c1.setName("c2");
		l2.getStructureElement().add(c2);

		//criar layer
		Layer l1 = StructureFactory.eINSTANCE.createLayer();
		l1.setName("l1");
		ss1.getStructureElement().add(l1);

		//		--------------
		Subsystem ss2 = StructureFactory.eINSTANCE.createSubsystem();
		ss2.setName("ss2");
		structureModel.getStructureElement().add(ss2);

		Component c3 = StructureFactory.eINSTANCE.createComponent();
		c3.setName("c3");
		ss2.getStructureElement().add(c3);

		Component c4 = StructureFactory.eINSTANCE.createComponent();
		c4.setName("c4");
		ss2.getStructureElement().add(c4);

		Component c5 = StructureFactory.eINSTANCE.createComponent();
		c5.setName("c5");
		ss2.getStructureElement().add(c5);

		//criar layer
		Layer l6 = StructureFactory.eINSTANCE.createLayer();
		l6.setName("l6");
		c5.getStructureElement().add(l6);

		//criar layer
		Layer l7 = StructureFactory.eINSTANCE.createLayer();
		l7.setName("l7");
		c5.getStructureElement().add(l7);

		//--------------------------------------------------
		//aggregateds

		createAggregatedRelationship(l3, l2, createActionsExamples(l3.getName(), l2.getName()));

		createAggregatedRelationship(l2, l1, createActionsExamples(l2.getName(), l1.getName()));


		raizKDM.getModel().add(codeModelForRelations);
		
		//salvar
		KdmPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

		Resource resource = resSet.createResource(URI.createURI("file://C:/Java/workspaceMestradoMars64/testesVariados/TestesVariados/src/br/ufscar/testes/instanciacaoArquiteturaArtigo/archHypot.xmi"));

		resource.getContents().add(raizKDM);

		try {

			resource.save(Collections.EMPTY_MAP);

		} catch (IOException e) {

		}
	}


	private static CodeModel codeModelForRelations = CodeFactory.eINSTANCE.createCodeModel();


	public static ArrayList<KDMRelationship> createActionsExamples (String from, String to) {
		ArrayList<KDMRelationship> lisfOfRelationshipsToAdd = new ArrayList<KDMRelationship>();

		if(Instanciar.codeModelForRelations == null){
			Instanciar.codeModelForRelations = CodeFactory.eINSTANCE.createCodeModel(); 

			Instanciar.codeModelForRelations.setName("Elements Instances");
		}
		Module moduleForRelations = CodeFactory.eINSTANCE.createModule();

		moduleForRelations.setName("Module Instance From: " + from + " To: " + to);

		Instanciar.codeModelForRelations.getCodeElement().add(moduleForRelations);

		//Andre - cria o eContainer das relacoes de action
		ActionElement actionElementForRelations = ActionFactory.eINSTANCE.createActionElement();

		actionElementForRelations.setName("actionElement Instance");

		moduleForRelations.getCodeElement().add(actionElementForRelations);

		//Andre - cria o eContainer das relações de código
		CodeElement codeElementForRelations = CodeFactory.eINSTANCE.createCodeElement();

		codeElementForRelations.setName("codeElement Instance");

		moduleForRelations.getCodeElement().add(codeElementForRelations);

		//Andre - tipos de relacao de action:
		Calls relation = ActionFactory.eINSTANCE.createCalls();
		lisfOfRelationshipsToAdd.add(relation);												
		actionElementForRelations.getActionRelation().add(relation);

		UsesType relation2 = ActionFactory.eINSTANCE.createUsesType();
		lisfOfRelationshipsToAdd.add(relation2);
		actionElementForRelations.getActionRelation().add(relation2);

		Creates relation3 = ActionFactory.eINSTANCE.createCreates();
		lisfOfRelationshipsToAdd.add(relation3);
		actionElementForRelations.getActionRelation().add(relation3);

		//Andre - Tipos de relação de code:
		Extends relation4 = CodeFactory.eINSTANCE.createExtends();
		lisfOfRelationshipsToAdd.add(relation4);
		codeElementForRelations.getCodeRelation().add(relation4);

		Implements relation5 = CodeFactory.eINSTANCE.createImplements();
		lisfOfRelationshipsToAdd.add(relation5);
		codeElementForRelations.getCodeRelation().add(relation5);

		HasValue relation6 = CodeFactory.eINSTANCE.createHasValue();
		lisfOfRelationshipsToAdd.add(relation6);
		codeElementForRelations.getCodeRelation().add(relation6);

		Imports relation7 = CodeFactory.eINSTANCE.createImports();
		lisfOfRelationshipsToAdd.add(relation7);
		codeElementForRelations.getCodeRelation().add(relation7);

		return lisfOfRelationshipsToAdd;
	}

	public static void createAggregatedRelationship (AbstractStructureElement from, AbstractStructureElement to, ArrayList<KDMRelationship> relations) {

		//Andre - verifica se ja existe um aggregated no na layer from
		if (from.getAggregated().size() > 0) {
			//System.out.println("MAIOR QUE 1, TODO");

			//Andre - pega os aggragated que ja estão no from
			EList<AggregatedRelationship> aggregatedFROM = from.getAggregated();		

			//Andre - começa um for nesses aggregated
			for (int i = 0; i < aggregatedFROM.size(); i++) {

				//Andre - verifica se o aggregated que ja existe tem o mesmo destino que o que esta pra ser criado 
				if (to.getName().equalsIgnoreCase(aggregatedFROM.get(i).getTo().getName())) {

					//Andre - se tiver o mesmo destino ele adiciona as relacoes novas e atualiza a densidade, depois disso ele pega e sai do for
					//ADICIONAR

					aggregatedFROM.get(i).setDensity(aggregatedFROM.get(i).getDensity()+relations.size());
					aggregatedFROM.get(i).getRelation().addAll(relations);

					break;
				}

				//Andre - se for o ultimo aggregated do for e mesmo assim não encontrou o com o mesmo destino que esta pra ser criado 
				//Andre - entao cria um novo aggregated para ser adicionado
				//se chegar no ultimo e nao encontrar
				if (i == (aggregatedFROM.size()-1)) {

					AggregatedRelationship newRelationship = CoreFactory.eINSTANCE.createAggregatedRelationship();
					newRelationship.setDensity(relations.size());
					newRelationship.setFrom(from);
					newRelationship.setTo(to);
					newRelationship.getRelation().addAll(relations);
					from.getAggregated().add(newRelationship);
					break;

				}


			}

		} else {
			//Andre - se não tiver um agrregated na layer from adiciona um com as relacoes que podem entre duas layers
			AggregatedRelationship newRelationship = CoreFactory.eINSTANCE.createAggregatedRelationship();
			newRelationship.setDensity(relations.size());
			newRelationship.setFrom(from);
			newRelationship.setTo(to);
			newRelationship.getRelation().addAll(relations);
			from.getAggregated().add(newRelationship);
		}

		//Fernando - Limpando lista 
		relations.clear();
		from = null;
		to = null;


	}


}
