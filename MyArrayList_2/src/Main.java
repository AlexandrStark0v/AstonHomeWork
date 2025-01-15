
public class Main {
    public static void main(String[] args) {
        MyArrayList_2<String> list2 = new MyArrayList_2<>();
        list2.add("Саня");
        list2.add("Ваня");
        list2.add("Коля");
        list2.add("Петя");
        list2.add("Толя");
        list2.add("Эдик");
//        System.out.println(list2.get(2));
        list2.quicksort(String::compareTo);

        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
//        list2.remove(2);
//        list2.sort(Integer::compareTo);
    }
}