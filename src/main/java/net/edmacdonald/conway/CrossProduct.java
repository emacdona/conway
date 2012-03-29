package net.edmacdonald.conway;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CrossProduct<A> implements Iterable<Pair<A,A>> {
    private Set<Pair<A,A>> crossProduct = new HashSet<Pair<A, A>>();

    public CrossProduct(Set<A> elements) {
        for(A first: elements){
            for(A second: elements){
                crossProduct.add(new Pair<A, A>(first, second));
            }
        }
    }

    @Override
    public Iterator<Pair<A, A>> iterator() {
        return crossProduct.iterator();
    }
}
