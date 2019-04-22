import java.util.HashMap;
import java.util.*;
import java.util.ArrayList;

public class FindTwoNumbers {




    static public void findTwoNumbers(Integer[] tempArr, Integer sum) {
        HashMap<Integer, Integer> arrayMap = new HashMap<>();

        for (Integer index = 0; index < (Integer)tempArr.length; index++) {
            Integer target = sum - tempArr[index];

            if (!arrayMap.containsValue(target)) {
                arrayMap.put(index, tempArr[index]);
            } else {

                System.out.println("[" + target + " , " + tempArr[index] + "]");

                // remove elements after used
                arrayMap.remove(index);
                ArrayList<Integer> targetList = getKey(arrayMap, target);
                Integer targetListCount = targetList.size();
                arrayMap.remove(targetList.get(targetListCount - 1));

            }
        }

    }

    public static ArrayList<Integer> getKey(HashMap<Integer, Integer> map, Object value){
        ArrayList<Integer> keyList = new ArrayList<>();
        for(Integer key: map.keySet()){
            if(map.get(key).equals(value)){
                keyList.add(key);
            }
        }
        return keyList;
    }


    public static void main(String[] args) {
        Integer[] array = {10, 2, 3, 1, 2, 4, -1, 7, 5};
//        Integer[] array = {2, 2, 2, 2, 3, 4, 3, 3, 3, 3};
        System.out.println("Array: " + Arrays.toString(array));
        Integer sum = 9;
        System.out.println("Target sum: " + sum);


        System.out.println("The answer should be: ");
        findTwoNumbers(array, sum);


    }
}
