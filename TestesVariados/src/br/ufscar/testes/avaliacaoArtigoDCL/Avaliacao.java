/**
 * @author André
 * 
 */
package br.ufscar.testes.avaliacaoArtigoDCL;

import java.util.ArrayList;

import org.eclipse.gmt.modisco.omg.kdm.action.ActionFactory;
import org.eclipse.gmt.modisco.omg.kdm.action.Calls;
import org.eclipse.gmt.modisco.omg.kdm.action.Creates;
import org.eclipse.gmt.modisco.omg.kdm.action.UsesType;
import org.eclipse.gmt.modisco.omg.kdm.code.CodeFactory;
import org.eclipse.gmt.modisco.omg.kdm.code.Extends;
import org.eclipse.gmt.modisco.omg.kdm.code.HasValue;
import org.eclipse.gmt.modisco.omg.kdm.code.Implements;
import org.eclipse.gmt.modisco.omg.kdm.core.AggregatedRelationship;
import org.eclipse.gmt.modisco.omg.kdm.core.CoreFactory;
import org.eclipse.gmt.modisco.omg.kdm.core.KDMRelationship;
import org.eclipse.gmt.modisco.omg.kdm.structure.Component;
import org.eclipse.gmt.modisco.omg.kdm.structure.Layer;
import org.eclipse.gmt.modisco.omg.kdm.structure.StructureFactory;
import org.eclipse.gmt.modisco.omg.kdm.structure.Subsystem;

/**
 * @author André
 *
 */
public class Avaliacao {

	
	/**
	 * @author André
	 */
	private void generatePart1() {
		Subsystem ss1 = StructureFactory.eINSTANCE.createSubsystem();
		ss1.setName("ss1");	
		
		Layer l3 = StructureFactory.eINSTANCE.createLayer();
		l3.setName("l3");
		Layer l2 = StructureFactory.eINSTANCE.createLayer();
		l2.setName("l2");
		Layer l1 = StructureFactory.eINSTANCE.createLayer();
		l1.setName("l1");
		
		ss1.getStructureElement().add(l1);
		ss1.getStructureElement().add(l2);
		ss1.getStructureElement().add(l3);
			
		ArrayList<KDMRelationship> lisfOfRelationships;
		lisfOfRelationships = new ArrayList<KDMRelationship>();
			
		Calls relation = ActionFactory.eINSTANCE.createCalls();
		lisfOfRelationships.add(relation);			
		UsesType relation2 = ActionFactory.eINSTANCE.createUsesType();
		lisfOfRelationships.add(relation2);
		Creates relation3 = ActionFactory.eINSTANCE.createCreates();
		lisfOfRelationships.add(relation3);
		Extends relation4 = CodeFactory.eINSTANCE.createExtends();
		lisfOfRelationships.add(relation4);
		Implements relation5 = CodeFactory.eINSTANCE.createImplements();
		lisfOfRelationships.add(relation5);
		HasValue relation6 = CodeFactory.eINSTANCE.createHasValue();
		lisfOfRelationships.add(relation6);
		
		AggregatedRelationship newRelationship = CoreFactory
				.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(l3);
		newRelationship.setTo(l2);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		l3.getAggregated().add(newRelationship);
		
		AggregatedRelationship newRelationship2 = CoreFactory
				.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(l2);
		newRelationship.setTo(l1);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		l2.getAggregated().add(newRelationship2);
		
		AggregatedRelationship newRelationship3 = CoreFactory
				.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(ss1);
		newRelationship.setTo(l3);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		ss1.getAggregated().add(newRelationship3);
		
		AggregatedRelationship newRelationship4 = CoreFactory
				.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(ss1);
		newRelationship.setTo(l2);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		ss1.getAggregated().add(newRelationship4);
		
		AggregatedRelationship newRelationship5 = CoreFactory
				.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(ss1);
		newRelationship.setTo(l1);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		ss1.getAggregated().add(newRelationship5);
			
	}
	
	/**
	 * @author André
	 */
	private void generatedPart2() {
		Subsystem ss2 = StructureFactory.eINSTANCE.createSubsystem();
		ss2.setName("ss2");
		
		Component c3 = StructureFactory.eINSTANCE.createComponent();
		c3.setName("c3");
		Component c4 = StructureFactory.eINSTANCE.createComponent();
		c4.setName("c4");
		Component c5 = StructureFactory.eINSTANCE.createComponent();
		c5.setName("c5");
		
		ss2.getStructureElement().add(c3);
		ss2.getStructureElement().add(c4);
		ss2.getStructureElement().add(c5);

		ArrayList<KDMRelationship> lisfOfRelationships;
		lisfOfRelationships = new ArrayList<KDMRelationship>();
			
		Calls relation = ActionFactory.eINSTANCE.createCalls();
		lisfOfRelationships.add(relation);			
		UsesType relation2 = ActionFactory.eINSTANCE.createUsesType();
		lisfOfRelationships.add(relation2);
		Creates relation3 = ActionFactory.eINSTANCE.createCreates();
		lisfOfRelationships.add(relation3);
		Extends relation4 = CodeFactory.eINSTANCE.createExtends();
		lisfOfRelationships.add(relation4);
		Implements relation5 = CodeFactory.eINSTANCE.createImplements();
		lisfOfRelationships.add(relation5);
		HasValue relation6 = CodeFactory.eINSTANCE.createHasValue();
		lisfOfRelationships.add(relation6);
		
		AggregatedRelationship newRelationship = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(c4);
		newRelationship.setTo(c3);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		c4.getAggregated().add(newRelationship);
		
		AggregatedRelationship newRelationship2 = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(c5);
		newRelationship.setTo(c4);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		c5.getAggregated().add(newRelationship2);
		
		AggregatedRelationship newRelationship3 = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(c5);
		newRelationship.setTo(c3);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		c5.getAggregated().add(newRelationship3);
		

		AggregatedRelationship newRelationship4 = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(ss2);
		newRelationship.setTo(c3);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		ss2.getAggregated().add(newRelationship4);
		

		AggregatedRelationship newRelationship5 = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(ss2);
		newRelationship.setTo(c4);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		ss2.getAggregated().add(newRelationship5);
		

		AggregatedRelationship newRelationship6 = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(ss2);
		newRelationship.setTo(c5);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		ss2.getAggregated().add(newRelationship6);
	}
	
	/**
	 * @author André
	 */
	private void generatedPart3() {
		Subsystem ss1 = StructureFactory.eINSTANCE.createSubsystem();
		ss1.setName("ss1");	
		
		Layer l2 = StructureFactory.eINSTANCE.createLayer();
		l2.setName("l2");
		
		Component c1 = StructureFactory.eINSTANCE.createComponent();
		c1.setName("c1");
		Component c2 = StructureFactory.eINSTANCE.createComponent();
		c2.setName("c2");
		
		ss1.getStructureElement().add(l2);
		
		l2.getStructureElement().add(c1);
		l2.getStructureElement().add(c2);
			
		ArrayList<KDMRelationship> lisfOfRelationships;
		lisfOfRelationships = new ArrayList<KDMRelationship>();
			
		Calls relation = ActionFactory.eINSTANCE.createCalls();
		lisfOfRelationships.add(relation);			
		UsesType relation2 = ActionFactory.eINSTANCE.createUsesType();
		lisfOfRelationships.add(relation2);
		Creates relation3 = ActionFactory.eINSTANCE.createCreates();
		lisfOfRelationships.add(relation3);
		Extends relation4 = CodeFactory.eINSTANCE.createExtends();
		lisfOfRelationships.add(relation4);
		Implements relation5 = CodeFactory.eINSTANCE.createImplements();
		lisfOfRelationships.add(relation5);
		HasValue relation6 = CodeFactory.eINSTANCE.createHasValue();
		lisfOfRelationships.add(relation6);
		
		AggregatedRelationship newRelationship = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(ss1);
		newRelationship.setTo(l2);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		ss1.getAggregated().add(newRelationship);
		
		AggregatedRelationship newRelationship2 = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(l2);
		newRelationship.setTo(c1);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		l2.getAggregated().add(newRelationship2);
		
		AggregatedRelationship newRelationship3 = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(l2);
		newRelationship.setTo(c2);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		l2.getAggregated().add(newRelationship3);
		
		AggregatedRelationship newRelationship4 = CoreFactory.eINSTANCE.createAggregatedRelationship();
		newRelationship.setDensity(lisfOfRelationships.size());
		newRelationship.setFrom(c2);
		newRelationship.setTo(c1);
		newRelationship.getRelation().addAll(lisfOfRelationships);
		
		c2.getAggregated().add(newRelationship4);
	}
}
