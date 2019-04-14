package ee.taltech.cs.mbt.tdl.commons.utils.data_structures;

import sun.security.provider.certpath.Vertex;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DirectedMultigraph<V, E> {
	private Set<V> vertices = new LinkedHashSet<>();
	private Set<E> edges = new LinkedHashSet<>();

	private Map<V, Set<E>> mapVertexEgressEdges = new LinkedHashMap<>();
	private Map<V, Set<E>> mapVertexIngressEdges = new LinkedHashMap<>();

	private Map<E, V> mapEdgeToSourceVertex = new LinkedHashMap<>();
	private Map<E, V> mapEdgeToTargetVertex = new LinkedHashMap<>();

	private Set<E> getOrCreateEgressEdgeSet(V vertex) {
		return mapVertexEgressEdges.computeIfAbsent(vertex, v -> new LinkedHashSet<>());
	}

	private Set<E> getOrCreateIngressEdgeSet(V vertex) {
		return mapVertexIngressEdges.computeIfAbsent(vertex, v -> new LinkedHashSet<>());
	}

	private void removeFromEgressEdges(V vertex, E edge) {
		if (mapVertexEgressEdges.containsKey(vertex))
			mapVertexEgressEdges.get(vertex).remove(edge);
	}

	private void removeFromIngressEdges(V vertex, E edge) {
		if (mapVertexIngressEdges.containsKey(vertex))
			mapVertexIngressEdges.get(vertex).remove(edge);
	}

	private void addNewEdge(V source, V target, E edge) {
		edges.add(edge);
		vertices.add(source);
		vertices.add(target);
		getOrCreateEgressEdgeSet(source).add(edge);
		getOrCreateIngressEdgeSet(target).add(edge);
		mapEdgeToSourceVertex.put(edge, source);
		mapEdgeToTargetVertex.put(edge, target);
	}

	private void splitExistingEdge(E edge, V middleVertex, E firstEdge, E secondEdge) {
		V sourceVertex = mapEdgeToSourceVertex.get(edge);
		V targetVertex = mapEdgeToTargetVertex.get(edge);
		removeExistingEdge(edge);
		addNewEdge(sourceVertex, middleVertex, firstEdge);
		addNewEdge(middleVertex, targetVertex, secondEdge);
	}

	private void removeExistingVertex(V vertex) {
		vertices.remove(vertex);
		Set<E> invalidatedEdges = new LinkedHashSet<>();
		Set<E> egressEdges = mapVertexEgressEdges.getOrDefault(vertex, new LinkedHashSet<>());
		Set<E> ingressEdges = mapVertexIngressEdges.getOrDefault(vertex, new LinkedHashSet<>());
		invalidatedEdges.addAll(egressEdges);
		invalidatedEdges.addAll(ingressEdges);
		removeExistingEdges(invalidatedEdges);
	}

	private void removeExistingEdges(Collection<E> edges) {
		edges.forEach(this::removeExistingEdge);
	}

	private void removeExistingEdge(E edge) {
		edges.remove(edge);
		V sourceVertex = mapEdgeToSourceVertex.remove(edge);
		V targetVertex = mapEdgeToTargetVertex.remove(edge);
		removeFromEgressEdges(sourceVertex, edge);
		removeFromIngressEdges(targetVertex, edge);
	}

	private Set<E> getConnectingEdges(V source, V target) {
		Set<E> sourceEgressEdges = mapVertexEgressEdges.getOrDefault(source, new LinkedHashSet<>());
		Set<E> targetIngressEdges = mapVertexIngressEdges.getOrDefault(target, new LinkedHashSet<>());
		Set<E> connectingEdges = new HashSet<>(sourceEgressEdges);
		connectingEdges.retainAll(targetIngressEdges);
		return connectingEdges;
	}

	private Set<E> getConnectedEdges(V vertex) {
		Set<E> egressEdges = mapVertexEgressEdges.getOrDefault(vertex, new LinkedHashSet<>());
		Set<E> ingressEdges = mapVertexIngressEdges.getOrDefault(vertex, new LinkedHashSet<>());
		Set<E> connectedEdges = new LinkedHashSet<>();
		connectedEdges.addAll(egressEdges);
		connectedEdges.addAll(ingressEdges);
		return connectedEdges;
	}

	public boolean isEmpty() {
		return getVertices().isEmpty();
	}

	public boolean hasVertex(V vertex) {
		return vertices.contains(vertex);
	}

	public Set<V> getVertices() {
		return Collections.unmodifiableSet(vertices);
	}

	public int vertexCount() {
		return vertices.size();
	}

	public int edgeCount() {
		return edges.size();
	}

	public int getDegree(V vertex) {
		return getInDegree(vertex) + getOutDegree(vertex);
	}

	public int getInDegree(V vertex) {
		return mapVertexIngressEdges.getOrDefault(vertex, Collections.emptySet()).size();
	}

	public int getOutDegree(V vertex) {
		return mapVertexEgressEdges.getOrDefault(vertex, Collections.emptySet()).size();
	}

	public void addVertex(V vertex) {
		if (hasVertex(vertex))
			throw new IllegalArgumentException("Vertex already exists.");
		vertices.add(vertex);
	}

	public boolean removeVertex(V vertex) {
		if (!hasVertex(vertex))
			return false;
		removeExistingVertex(vertex);
		return true;
	}

	public boolean hasEdge(E edge) {
		return edges.contains(edge);
	}

	public boolean hasEdge(V source, V target) {
		return !getEdges(source, target).isEmpty();
	}

	public Set<E> getEdges() {
		return Collections.unmodifiableSet(edges);
	}

	public Set<E> getEdges(V source, V target) {
		if (!hasVertex(source))
			return Collections.emptySet();
		if (!hasVertex(target))
			return Collections.emptySet();
		return Collections.unmodifiableSet(getConnectingEdges(source, target));
	}

	public Set<E> getEdges(V vertex) {
		if (!hasVertex(vertex))
			return Collections.emptySet();
		return Collections.unmodifiableSet(getConnectedEdges(vertex));
	}

	public Set<E> getEdgesFrom(V vertex) {
		return Collections.unmodifiableSet(mapVertexEgressEdges.getOrDefault(vertex, Collections.emptySet()));
	}

	public Set<E> getEdgesTo(V vertex) {
		return Collections.unmodifiableSet(mapVertexIngressEdges.getOrDefault(vertex, Collections.emptySet()));
	}

	public void addEdge(V source, V target, E edge) {
		if (hasEdge(edge))
			throw new IllegalArgumentException("Edge already exists.");
		addNewEdge(source, target, edge);
	}

	public boolean removeEdge(E edge) {
		if (!hasEdge(edge))
			return false;
		removeExistingEdge(edge);
		return true;
	}

	public V getSourceVertex(E edge) {
		if (!hasEdge(edge))
			return null;
		return mapEdgeToSourceVertex.get(edge);
	}

	public V getTargetVertex(E edge) {
		if (!hasEdge(edge))
			return null;
		return mapEdgeToTargetVertex.get(edge);
	}

	public void splitEdge(E edge, V middleVertex, E firstEdge, E secondEdge) {
		if (!hasEdge(edge))
			throw new IllegalArgumentException("Edge does not exist.");
		if (hasEdge(firstEdge))
			throw new IllegalArgumentException("First replacement edge already exists.");
		if (hasEdge(secondEdge))
			throw new IllegalArgumentException("Second replacement edge already exists.");
		splitExistingEdge(edge, middleVertex, firstEdge, secondEdge);
	}
}
