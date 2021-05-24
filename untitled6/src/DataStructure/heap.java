package DataStructure;
import java.util.Arrays;
public class heap<T extends Comparable>{
    /*堆内节点的下沉，如果一个节点左右节点小的话，就交换，交换后继续比较交换后的节点和它的子节点，直到它没子节点*/
    public  void heapify(T[] array, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }
            //只有左孩子 肯定是左孩子大
            //左右都有判断哪个大 就跟哪个换
            int max = left;
            if (left + 1 < size && array[left + 1].compareTo( array[left])>0) {
                max = left + 1;
            }
            if (array[index].compareTo( array[max])>=0) {
                return;
            }
            swap(array, index, max);
            index = max;
        }
    }/*交换数组中两个元素的位置*/
    private  void swap(T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }/*建立堆，从中间结点向后交换*/
    public  void createHeap(T[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }
    public  void adjustUp(T[] array, int size, int index) {
        while (true) {
            if (index == 0) {
                return;
            }

            int pareant = (index - 1) / 2;
            if (array[pareant].compareTo( array[index])>=0) {
                return;
            }
            swap(array,pareant, index);
            index = pareant;
        }

    }}
