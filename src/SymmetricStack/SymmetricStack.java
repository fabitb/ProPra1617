package SymmetricStack;

public class SymmetricStack {

    private int[] data;
    private int first;
    private int last;

    public SymmetricStack() {
        first = last = -1;
        data = new int[10];
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getNumberOfElements() {
        if (first != -1){
            if (first <= last){
                return (last - first) + 1;
            }
            else{
                return (data.length - first) + (last + 1);
            }
        }
        return 0;
    }

    public void increase() {
        if (isFull()){
            int[] newData = new int[data.length * 2]; // create new double-sized Stack
            int _first = data.length / 2; // first index of new array
            int j = _first;
            int i = first;
            for (int counter = 0; counter < data.length ; counter++){
                newData[j] = data[i];
                j++;
                i = (i + 1) % data.length;
            }
            setLast(_first + data.length - 1);
            setData(newData);
            setFirst(_first);
        }
    }

    public void decrease() {
        if (getNumberOfElements() <= data.length / 4){
            int[] newData = new int[data.length / 2];
            int _first = data.length / 8;
            int j = _first;
            int i = first;
            for (int counter = 0; counter <= getNumberOfElements(); counter ++){
                newData[j] = data[i];
                j++;
                i = (i + 1) % data.length;
            }
            setLast(_first + getNumberOfElements() - 1);
            setData(newData);
            setFirst(_first);
        }
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return getNumberOfElements() == data.length;
    }

    public void prepend(int x) {
        // Wenn Stack leer, dann first und last neu setzen und x an dieser Stelle einfügen
        if (isEmpty()){
            setFirst(data.length / 2);
            setLast(first);
            data[first] = x;
        }
        // Wenn Stack nicht leer, increase aufrufen, um es eventuell zu vergrößern und Platz zu schaffen.
        // Dann first einen runter setzen und x einfügen.
        else{
            increase();
            setFirst((first - 1) % data.length);
            data[first] = x;
        }
    }

    public void append(int x) {
        // Wenn Stack leer, dann first und last neu setzen und x an dieser Stelle einfügen
        if (isEmpty()){
            setFirst(data.length / 2);
            setLast(first);
            data[last] = x;
        }
        // Wenn Stack nicht leer, increase aufrufen, um es eventuell zu vergrößern und Platz zu schaffen.
        // Dann last einen rauf setzen und x einfügen.
        else{
            increase();
            setLast((last + 1) % data.length);
            data[last] = x;
        }
    }

    public void removeFirst() {
        // Wenn nur noch ein Element drin ist im Stack, dann ist er danach leer!
        // Deshalt first und last auf -1 setzen!
        if (getNumberOfElements() == 1){
            setFirst(-1);
            setLast(-1);
        }
        // Wenn noch mehr als ein Element enthalten ist dann einfach first einen rauf setzen!
        // Danach decrease aufrufen, da es vllt verkleinert werden muss (Dieser Test erfolgt in decrease selbst)
        else {
            setFirst((first + 1) % data.length);
            decrease();
        }
    }

    public void removeLast() {
        // Wenn nur noch ein Element drin ist im Stack, dann ist er danach leer!
        // Deshalt first und last auf -1 setzen!
        if (getNumberOfElements() == 1) {
            setLast(-1);
            setFirst(-1);
        }
        // Wenn noch mehr als ein Element enthalten ist dann einfach last einen runter setzen!
        // Danach decrease aufrufen, da es vllt verkleinert werden muss (Dieser Test erfolgt in decrease selbst)
        else{
            setLast((last - 1) % data.length);
            decrease();
        }
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < data.length; i++) {
            if (first <= last && (i < first || i > last))
                out += "* ";
            if (first <= last && i > first && i < last)
                out += " " + data[i];
            if (first > last && i > last && i < first)
                out += "* ";
            if (first > last && (i > first || i < last))
                out += " " + data[i];
            if (i == first)
                out = out + "(" + data[i];
            if (i == last)
                out += (first == last ? "" : " " + data[i]) + ")";
        }
        return out;
    }
}
