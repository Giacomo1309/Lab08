package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.model.*;
import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

//per capire come ho fatto inserire query su database e
	// a partire da quella poi ho fatto in modo che se
	// in un database ce "il ritorno" ricalcolo la media nel DAO

	private Graph<Airport, DefaultWeightedEdge> grafo;
	private Map<Integer, Airport> idMap;
	private ExtFlightDelaysDAO dao;

	public Model() {
		idMap = new HashMap<Integer, Airport>();
		this.dao = new ExtFlightDelaysDAO();
		dao.loadAllAirports(idMap);

	}

	public void creaGrafo(int distanza) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, idMap.values());
		// idea assurda, non risolvibile in SQL risolvo in java, nel DAO prima di
		// aggiungere un nuovo elemento nella lista di appoggio
		// verifico che non esista gia un oggetto che abbia : " origine = fine e fine =
		// origine " in caso ci sia calcolo la media tra i due
		// e l'aggiorno fra !!!!!! vaffanculo!

		for (Supporto s : dao.getSupporto(distanza).values()) {

			Graphs.addEdge(this.grafo, idMap.get(s.getPartenza()), idMap.get(s.getArrivo()), s.getMedia());
		}

	}

	public int nVertici() { //verificare un po se vuole i vertici anche vuoti oppure no 
		int nVertici = 0;
		for (Airport a : this.grafo.vertexSet()) {
			if (this.grafo.edgesOf(a).size() > 0) {
				nVertici++;
			}
		}
		return nVertici;
		// return this.grafo.vertexSet().size();
	}

	public int nArchi() {
		return this.grafo.edgeSet().size();
	}

	public Graph<Airport, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}

	public void setGrafo(Graph<Airport, DefaultWeightedEdge> grafo) {
		this.grafo = grafo;
	}

}
