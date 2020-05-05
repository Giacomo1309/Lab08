package it.polito.tdp.extflightdelays.db;

import java.util.HashMap;
import java.util.Map;

import it.polito.tdp.extflightdelays.model.Airport;

public class TestDAO {

	public static void main(String[] args) {

		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		Map<Integer, Airport> idMap = new HashMap<Integer,Airport>();
		
		//System.out.println(dao.loadAllAirlines());
		//dao.loadAllAirports(idMap);
	//	System.out.println(dao.loadAllFlights().size());
		System.out.println("sperimento" + "\n");
//		System.out.println( dao.getSupporto().values());
		
		
	}

}
