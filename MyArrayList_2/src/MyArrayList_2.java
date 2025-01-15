import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс MyArrayList представляет собой пользовательскую реализацию динамического массива,
 * аналогичного ArrayList в Java.
 *
 * <p> Этот класс поддерживает добавление, удаление, доступ, очистку и сортировку элементов.
 * Благодаря использованию дженериков (Generics) он может работать с данными любого типа.</p>
 *
 * @param <T> Тип элементов, которые будут храниться в этом списке.
 */
public class MyArrayList_2<T> {

    private Object[] elements;
    private int size;

    /**
     * Конструктор, который создает пустой список с начальной вместимостью 10.
     */
    public MyArrayList_2() {
        elements = new Object[10];
        size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент, который нужно добавить.
     */
    public void add(T element) {
        checkElement();
        elements[size++] = element;
    }

    /**
     * Adds an element at a specific index in the list.
     *
     * @param index Индекс, куда будет добавлен элемент.
     * @param element Элемент, который нужно добавить.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимых значений
     *                                   (index < 0 || index > size)
     */
    public void add(int index, T element) {
        checkIndex(index);
        checkElement();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Возвращаем элемент по заданному индексу.
     *
     * @param index Индекс элемента
     * @return Элемент по заданному индексу
     *
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    /**
     * Удаление элементов по заданному индексу.
     *
     * @param index Индекс элемента который нужно удалить.
     * @return Удаленный элемент.
     *
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // позволяет освободить память
        return removedElement;
    }

    /**
     * Удаляет все элементы из списка.
     * Размер списка становится равен 0.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Сортирует элементы списка с использованием переданного компаратора.
     *
     * @param comparator Компаратор для определения порядка сортировки.
     * @throws NullPointerException если компаратор равен null.
     */
    public void sort(Comparator<T> comparator) {
        if (comparator == null) {
            throw new NullPointerException("Comparator cannot be null");
        }
        Arrays.sort((T[]) elements, 0, size, comparator);
    }

    /**
     * Сортирует элементы списка с использованием алгоритма QuickSort.
     *
     * @param comparator Компаратор для определения порядка сортировки.
     * @throws NullPointerException если компаратор равен null
     */
    public void quicksort(Comparator<T> comparator) {
        if (comparator == null) {
            throw new NullPointerException("Компаратор не может быть null");
        }
        quicksort(0, size - 1, comparator);
    }

    private void quicksort(int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quicksort(low, pivotIndex - 1, comparator);
            quicksort(pivotIndex + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<T> comparator) {
        T pivot = (T) elements[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare((T) elements[j], pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        checkIndex(i);
        checkIndex(j);
        T temp = (T) elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    /**
     Увеличиваем массив если он заполнен.
     */
    private void checkElement() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }
    /**@throws IndexOutOfBoundsException если индекс выходит за пределы допустимых значений
      (index < 0 || index >= size)*/
    private void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
    @return Кол-во элементов списка.
     */
    public int size() {
        return size;
    }
}