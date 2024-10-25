class Solution {

    public String getDir(String folder1) {
        for(int i=folder1.length()-1; i>=0; i--) {
            if(folder1.charAt(i) == '/') {
                return folder1.substring(0, i+1);
            }
        }
        return "";
    }

    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<String>();
        Arrays.sort(folder);
        // for(String i: folder) {
        //     System.out.println(i);
        // }
        boolean[] removed = new boolean[folder.length];
        for(int i=0; i<folder.length; i++) {
            if(removed[i]) continue;
            result.add(folder[i]);
            for(int j=i+1; j<folder.length; j++) {
                if(getDir(folder[j]).startsWith(folder[i] + '/')) removed[j] = true;
            }
        }

        return result;
    }
}