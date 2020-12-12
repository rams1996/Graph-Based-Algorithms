            else res=Math.min(res,cnt+(newr/K)+1);
            return;
        }
        combination(list,0,K,new ArrayList<>(),com);
        for(int i=0;i<com.size();i++){
            List<Integer>course=com.get(i);
            for(int c:course){
                set.add(c);
                List<Integer>childs=adjecent[c];
                for(int chi:childs){
                    in[chi]--;
                }
            }
            int newr=remain-course.size();
            if(course.size()<K){
                int more=(K-course.size());
                have-=more;
                have=Math.max(have,0);
            }
            dfs(cnt+1,newr,have);
            for(int c:course){
                set.remove(c);
                List<Integer>childs=adjecent[c];
                for(int chi:childs)in[chi]++;
            }
        }
        
    }
    public void combination(List<Integer>list,int start,int k,List<Integer>cur,List<List<Integer>>com){
        if(k==0||start>=list.size()){
            if(cur.size()==Math.min(list.size(),K))com.add(new ArrayList<>(cur));
        }
        for(int i=start;i<list.size();i++){
            cur.add(list.get(i)); 
            combination(list,i+1,k-1,cur,com);
            cur.remove(cur.size()-1);
        }
    }
    
    public List<Integer> get(){
        List<Integer>list=new ArrayList<>();
        for(int i=1;i<in.length;i++){
            if(in[i]==0&&!set.contains(i)&&has.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}
