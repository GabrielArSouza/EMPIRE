package ufrn.sgl.service.interfaces;

import java.util.List;

import ufrn.sgl.model.Bidding;

public interface BiddingServiceInterface {

	/**
	 * create a new bidding in the database
	 * @param bidding the bidding to create
	 */
	public long create ( Bidding bidding );
	
	/**
	 * get a bidding of database by a ID
	 * @param id the Bidding ID
	 * @return the bidding that match with ID
	 */
	public Bidding read (long id);
	
	public Bidding read(Bidding bidding);
	
	/**
	 * update the bidding in a database
	 * @param bidding the bidding for update
	 */
	public void update (Bidding bidding);

	/**
	 * delete the bidding of database
	 * @param bidding the bidding for delete
	 */
	public void delete (long id);
	
	public List<Bidding> list ();
	
}
