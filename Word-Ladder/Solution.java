class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // myidea：我分析感觉像是最短路径问题，如果两个单词只有一个字母不一样那么就建立一条无向边，切权值为1，最后记录由beginWord到endWord的路径paths即可
        // 实现点1：如何构建图,想法：按照单词的下标对应最终的图邻接矩阵的下标,然后beginWord的下标为n，n是wordList的长度
        // 
        int n = wordList.size();
        // 大小是n+1的原因是0--n存储的是wordList中的元素，n存储的是beginWorld
        int[][] graph = new int[n+1][n+1];
        // 找到endword在wordList中的下标位置
        int end = -1;
        for(int i = 0;i<n;i++) if(wordList.get(i).equals(endWord)) end = i;
        // 如果wordList中不包含endWord
        if(end == -1) return 0;
        // 初始化graph
        for(int i = 0;i<n;i++) 
            if(calcDis(beginWord,wordList.get(i))){
                graph[n][i] = 1;
                graph[i][n] = 1;
            }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i!=j && calcDis(wordList.get(i),wordList.get(j))){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        // 图构建完成之后，接下来就是计算单源最短路径，使用dijskra
        return dijskra(graph,n,end)==0?0:dijskra(graph,n,end)+1;
    }
    // 计算两个单词之间是否只有1个字符不相同，是则为true反之false
    public boolean calcDis(String s1,String s2){
        // 因为题目说了所有的单词具有一样的长度，所以没有必要进行长度的判断
        int dis = 0;
        for(int i = 0;i<s1.length();i++) if(s1.charAt(i) != s2.charAt(i)) dis++;
        return dis == 1;
    }
    // dijskra
    public int dijskra(int[][] graph,int start,int end){
        int n = graph.length;
        // 存放start到各个下标节点的距离,初始化
        int[] distance = new int[n];
        for(int i = 0;i<n;i++) distance[i] = graph[start][i];
        distance[start] = 0;
        // 判断start到下标位置的节点是否有最短路径
        boolean[] visited = new boolean[n];
        visited[start] = true;
        // 遍历除了start本身节点的所有节点、也就是说循环n-1次
        for(int i = 1;i < n;i++){
            // 当前最短距离
            int minDistance = Integer.MAX_VALUE;
            // 当前最短距离的节点下标
            int minIndex = 1;
            // 遍历所有的节点，找到距离start的最近的节点
            for(int j =0;j < n;j++){
                if(!visited[j] && distance[j] != 0 && distance[j]<=minDistance){
                    minDistance = distance[j];
                    minIndex = j;
                }
            }
            // 标记最近距离节点已经找到了
            visited[minIndex] = true;
            // 根据刚刚找到的最近距离节点，更新start节点到其他节点的距离
            for(int j=0;j< n;j++){
                // 如果已更新的最短距离节点可以到达当前便利的节点
                if(graph[minIndex][j] == 1){
                    if(distance[j] != 0) distance[j] = Math.min(distance[j],distance[minIndex] + graph[minIndex][j]);
                    else distance[j] = distance[minIndex] + graph[minIndex][j];
                }
            }
        }

        return distance[end];
    }

}