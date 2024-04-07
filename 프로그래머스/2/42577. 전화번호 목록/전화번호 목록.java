import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phoneBook) {

        HashMap<String, Integer> hm = new HashMap<>();


        for (int i = 0; i < phoneBook.length; i++) 
            hm.put(phoneBook[i], i);
        
        for (int i = 0; i < phoneBook.length; i++)
            for (int j = 0; j < phoneBook[i].length(); j++)
                if (hm.containsKey(phoneBook[i].substring(0, j)))
                    return false;

        return true;
    }
}