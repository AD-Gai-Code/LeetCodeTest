package leetcodeTest.algorithm.sort;

import java.util.Random;

public class SortTestHelper {

    // SortTestHelper 不允许产生任何实例
    private SortTestHelper(){}

    // 生成有 n 个元素的随机数组，每个元素的随即范围为[rangL,rangR]
    public static Integer[] generateRandomArray(int n){


        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i ++){
            Random r = new Random();
            arr[i] = r.nextInt(n);
        }
        return arr;
    }

    // 打印 arr 数组的所有内容
    public static void printArray(Object arr[]){

            for(int i = 0; i < arr.length; i ++){
                System.out.print( arr[i] );
                System.out.print( ' ' );
            }

            System.out.println();
            return ;
    }

    // 判断数组是否有序
    public static boolean isSorted(Comparable[] arr){

        for(int i = 0; i < arr.length - 1; i ++){
            if(arr[i].compareTo(arr[i + 1]) > 0){
                return false;
            }
        }
        return true;
    }

    // 测试 sortClassName 所对应的排序算法排序 arr 数组所得到结果的正确性和算法运行的时间
    public static <E extends Comparable<E>> void testSort(String sortName,E[] arr){

        long startTime = System.nanoTime();
        if(sortName.equals("MergeSort")){
            MergeSort.sort(arr);
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if( !SortTestHelper.isSorted(arr)){
            throw new RuntimeException(sortName + "failed");
        }
        System.out.println(String.format("%s , n = %d : %f s" , sortName,arr.length,time));
    }
    /*public static void testSort(String sortClassName, Comparable[] arr){
        // 通过 Java 的反射机制，通过排序的类名，运行排序函数

         try{
             // 通过 sortClassName 获得排序函数的 Class 对象
             Class sortClass = Class.forName(sortClassName);
             // 通过排序函数的 Class 对象获取排序方法
             Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
             // 排序参数只有一个，是可比较数组 arr
             Object[] params = new Object[]{arr};

             long startTime = System.currentTimeMillis();

             // 调用排序函数
             sortMethod.invoke(null,params);
             long endTime = System.currentTimeMillis();

             assert isSorted( arr );

             System.out.println( sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
         } catch (Exception e) {
             e.printStackTrace();
         }
    }*/
}
