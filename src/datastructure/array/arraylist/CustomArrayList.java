package datastructure.array.arraylist;

public class CustomArrayList<T> {
    private T[] datas;
    private int size;

    public CustomArrayList() {
        datas = (T[]) new Object[10];
        size = 0;
    }

    public void add(T object) {
        if (object == null) {
            throw new RuntimeException("null 불가");
        }
        if (datas.length == size) {
            copyToNewArray();
        }
        datas[size] = object;
        size++;
    }

    public void remove(T object) {
        if (size == 0) {
            throw new RuntimeException("데이터가 없습니다.");
        }
        for (int i = 0; i < size; i++) {
            if (datas[i].equals(object)) {
                pullArray(i);
                size--;
            }
        }
    }

    public int size() {
        return size;
    }

    private void pullArray(int idx) {
        for (int i = idx; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        datas[size - 1] = null;
    }

    private void copyToNewArray() {
        T[] newArray = (T[]) new Object[(size << 1)];
        System.arraycopy(datas, 0, newArray, 0, datas.length);
        datas = newArray;
    }
}
