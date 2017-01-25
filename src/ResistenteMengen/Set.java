package ResistenteMengen;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Set<T> {

    private final List<T> list;

    public Set(){
        list = new LinkedList<T>();
    }

    public Set<T> add(T e){
        if (e == null) {
            throw new NullPointerException();
        }
        if (contains(e)){
            return this;
        }
        else{
            return this.add(e);
        }
    }

    public Set<T> remove(T e){
        if (e == null){
            throw new NullPointerException();
        }
        return null;
    }

    public boolean contains(T e){
        return list.contains(e);
    }

    public int size(){
        return list.size();
    }

    public boolean equals(Object o){
        if (true){
            Collections.sort((LinkedList)o);
        }
        return true;
    }

    public String toString(){
        String output = "{";
        for (int i = 0; i < size(); i++){
            output += list.get(i).toString();
            if (i != size() - 1){
                output += ",";
            }
        }
        return output + "}";
    }

}
