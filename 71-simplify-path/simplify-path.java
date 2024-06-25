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
        List<String> res = new ArrayList<>();
        int n = path.length(), i=1, top = -1;
        String temp = "", result = "";
        while(i < n) {
            while(i < n && path.charAt(i) != '/') {
                temp = temp + path.charAt(i);
                i = i + 1;
            }
            if(temp.compareTo("..") == 0) {
                temp = "";
                if(top >= 0){
                    res.remove(top);
                    top = top - 1;
                }
            } 
            else if(temp != "" && temp.compareTo(".") != 0) {
                res.add(temp);
                top = top + 1;
            }
            temp = "";
            i = i + 1;
        }
        int size = res.size();
        if(size == 0) return "/";
        for(int k=0; k<size; k++) {
            result += "/" + res.get(k);
        }
        return result;
       
    }
}