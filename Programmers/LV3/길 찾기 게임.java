import java.util.*;
class Solution {
    static int[][] result;
    static int num = 0;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        result = new int[2][nodeinfo.length];
        
        ArrayList<Node> list = new ArrayList<>();
        
        for(int idx = 0; idx<nodeinfo.length;idx++)
        {
            list.add(new Node(nodeinfo[idx][0],nodeinfo[idx][1],idx+1,null,null));
        }
        //노드의 Y좌표가 가장 큰 것이 Root , 그러므로 Y기준 내림차순 , X기준 오름차순 정렬
        Collections.sort(list, new Comparator<Node>(){
           public int compare(Node n1, Node n2){
               if(n1.y == n2.y){
                   return n1.x-n2.x;
               }
               else{
                   return n2.y-n1.y;
               }
           } 
        });
   
        //정렬 후 0번째가 Root
        Node root = list.get(0);
        
        //Insert
        for(int idx = 1; idx<list.size();idx++)
        {
            insert(root,list.get(idx));
        }
        
        //전위 순회
        preorder(root);
        num = 0;
        
        //후위 순회
        postorder(root);
        
        return result;
    }
    
    public void insert(Node root,Node child)
    {
        if(root.x > child.x){
            if(root.left == null) root.left = child;
            else insert(root.left,child);
        } else {
            if(root.right == null) root.right = child;
            else insert(root.right,child);
        }
    }
    // Root,Left,Right
    public void preorder(Node root){
        if(root == null) return;      
        
        result[0][num++] = root.index;        
        
        preorder(root.left);
        preorder(root.right);        
    }
    //Left,Right,Root
    public void postorder(Node root)
    {
        if(root == null) return;
        
        postorder(root.left);
        postorder(root.right);
        
        result[1][num++] = root.index;
    }
}
class Node
{
    int x;
    int y;
    int index;
    Node left;
    Node right;
    
    Node(int x, int y, int index,Node left, Node right)
    {
        this.x = x;
        this.y = y;
        this.index = index;
        this.left = left;
        this.right = right;
    }
}
