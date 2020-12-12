import java.util.*;
​
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(List<String> strings:tickets){
            if(!map.containsKey(strings.get(0))){
                map.put(strings.get(0),new ArrayList<>());
            }
            map.get(strings.get(0)).add(strings.get(1));
        }
        for(String s:map.keySet()){
            map.get(s).sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
        }
        return func(map,"JFK");
    }
    public List<String> func(HashMap<String,List<String>> map,String s){
        List<String> ret=new ArrayList<>();
        ret.add(s);
        if(map.containsKey(s)){
            List<String> list=map.get(s);
            if(list.size()>0){
                for(int i=0;i<list.size();i++){
                    String end=list.get(i);
                    list.remove(i);
                    List<String> tmp=func(map,end);
                    if(tmp!=null){
                        ret.addAll(tmp);
                        return ret;
                    }
                    list.add(i,end);
                }
            }
        }
        for(String key:map.keySet()){
            if(map.get(key).size()>0){
                return null;
            }
        }
        return ret;
    }
}
