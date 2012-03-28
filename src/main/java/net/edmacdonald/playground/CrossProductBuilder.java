package net.edmacdonald.playground;

import java.util.HashSet;
import java.util.Set;

public class CrossProductBuilder<A> {
    Set<A> elements;

    public CrossProductBuilder(Set<A> elements) {
        this.elements = elements;
    }

    public Set<Pair<A,A>> getCrossProduct(){
        Set<Pair<A,A>> crossProduct = new HashSet<Pair<A, A>>();
        for(A first: elements){
            for(A second: elements){
                crossProduct.add(new Pair<A, A>(first, second));
            }
        }
        return crossProduct;
    }
}
