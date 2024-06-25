class Solution {

    public int what(String a){
        if(a.compareTo("..") == 0) {
            return -1;
        }
        else {
            return 1;
        }
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> myList = new ArrayList<>();
        for(String i: path.split("/", -2)) {
            if(i.compareTo("")!=0 && i.compareTo(" ")!=0 && i.compareTo(".") != 0){
                myList.add(i);
                //System.out.print(what(i) + " ");
            }
                
        }
        for(String i: myList){
            System.out.println(i);
            if(what(i) == 1){
                stack.push(i);
                //System.out.println(stack.peek());
            }
            else if(what(i) == -1 && !stack.isEmpty()){
                stack.pop();
                //System.out.println(stack.peek());
            }
        }

        String a = "";
        while(!stack.isEmpty()) {

            a = "/" + stack.pop() + a;
            System.out.print(a);
        }
        
        if(a.compareTo("") == 0){
            return "/";

        }
        else {
             return a;
        }
       
    }
}