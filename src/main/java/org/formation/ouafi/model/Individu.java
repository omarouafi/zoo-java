/**
 * 
 */
package org.formation.ouafi.model;

import org.formation.ouafi.model.technique.BeurkException;

/**
 * @author jacques
 *
 */
public interface Individu {
	public void dormir();
	public void manger();
	public String crier();
	public String manger(Mangeable m) throws BeurkException ;
	@Deprecated(since="1.2", forRemoval=true)
	public String manger(Gazelle g);

}
