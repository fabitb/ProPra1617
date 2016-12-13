package Blatt08;

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
            int i = first;
            int out = 1;
            while (i != last){
                out ++;
                i = (i + 1) % data.length;
            }
            return out;
        }
        return 0;
    }

    public void increase() {
        if (isFull()){
            int[] newData = new int[data.length * 2];
            int _first = data.length / 2;
            int j = _first;
            int _last = _first + data.length - 1;

            int i = first;

            for (int counter = 0; counter < data.length ; counter++){
                newData[j] = data[i];
                j++;
                i = (i + 1) % data.length;
            }

            setData(newData);
            setFirst(_first);
            setLast(_last);
        }
    }

    public void decrease() {
        if (getNumberOfElements() <= data.length / 4){
            int[] newData = new int[data.length / 2];
            int _first = data.length / 8;
            int _last = _first + getNumberOfElements() - 1;

            int j = _first;
            int i = first;

            for (int counter = 0; counter <= getNumberOfElements(); counter ++){
                newData[j] = data[i];
                j++;
                i = (i + 1) % data.length;
            }

            setData(newData);
            setFirst(_first);
            setLast(_last);
        }
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return getNumberOfElements() == data.length;
    }

    public void prepend(int x) {
        if (isEmpty()){
            setFirst(data.length / 2);
            setLast(first);
            prepend(x);
        }
        else{
            increase();
            setFirst((first - 1) % data.length);
            data[first] = x;
        }
    }

    public void append(int x) {
        if (isEmpty()){
            setFirst(data.length / 2);
            setLast(first);
            append(x);
        }
        else{
            increase();
            setLast((last + 1) % data.length);
            data[last] = x;
        }
    }

    public void removeFirst() {
        setFirst((first + 1) % data.length);
        decrease();
    }

    public void removeLast() {
        setLast((last - 1) % data.length);
        decrease();
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

    public static void main(String[] args) {
        SymmetricStack ss = new SymmetricStack();
        ss.setData(new int[]{1,-1,-1,-1,-1,-1,-1,-1,-1,10});
        ss.setFirst(9);
        ss.setLast(0);
        System.out.println(ss.toString());
        ss.removeFirst();
        System.out.println(ss.toString());
    }
}
