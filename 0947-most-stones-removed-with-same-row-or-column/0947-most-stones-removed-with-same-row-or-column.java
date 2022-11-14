class Solution {
//     Just copy Pasted Please do visit again and solve by self
    
    public int removeStones(int[][] stones) {
        int res=0;
        boolean[] flag = new boolean[stones.length];
        Queue<Integer> col = new LinkedList();
        Queue<Integer> row = new LinkedList();
        HashSet<Integer> visitedrow = new HashSet();
        HashSet<Integer> visitedcol = new HashSet();
        for(int i=0; i<stones.length; i++){
        	if(flag[i]==true)
        		continue;
        int a=stones[i][0];
        int b=stones[i][1];
        visitedrow.add(a);
        visitedcol.add(b);
        for(int j=i+1; j<stones.length; j++){
        	if(stones[j][0]==a){
        		flag[j]=true;
        		if(!visitedcol.contains(stones[j][1]))
        			col.add(stones[j][1]);
        		continue;
        	}
        	if(stones[j][1]==b){
        		flag[j]=true;
        		if(!visitedrow.contains(stones[j][0]))
        			row.add(stones[j][0]);
        		continue;
        	}
        }
        while(!row.isEmpty() || !col.isEmpty()){
        while(!row.isEmpty()){
        	a=row.poll();
        	visitedrow.add(a);
        	for(int j=i+1; j<stones.length; j++){
        		if(flag[j]==true)
            		continue;
        		if(stones[j][0]==a){
            		flag[j]=true;
            		if(!visitedcol.contains(stones[j][1]))
            			col.add(stones[j][1]);
            		continue;
            	}
        	}
        }
        while(!col.isEmpty()){
        	b=col.poll();
            visitedcol.add(b);
        	for(int j=i+1; j<stones.length; j++){
        		if(flag[j]==true)
            		continue;
        		if(stones[j][1]==b){
            		flag[j]=true;
            		if(!visitedrow.contains(stones[j][0]))
            			row.add(stones[j][0]);
            		continue;
            	}
        	}
        }
        }
        }
        for(int i=0; i<stones.length; i++){
        	if(flag[i]==true)
        		res++;
        }
        return res;
    }
}