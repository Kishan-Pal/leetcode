class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index=0;
        while(index < words.length) {
            int numWords = 0;
            int numSpaces = -1;
            int curLength = 0;
            List<String> addedWords = new ArrayList<>();
            int i;
            for(i=index; i<words.length; i++) {
                if(curLength + numSpaces + 1 + words[i].length() <= maxWidth) {
                    addedWords.add(words[i]);
                    numWords++;
                    numSpaces = numWords - 1;
                    curLength = curLength + words[i].length();
                }
                else break;
            }
            // System.out.println(numWords + " " + numSpaces + " " + curLength);
            // for(String j: addedWords) {
            //     System.out.print(j);
            // }
            // System.out.println();
            String temp;
            if(i == words.length) {
                temp = leftJustify(addedWords, numSpaces, curLength, maxWidth);
            }
            else {
                temp = fullJustify(addedWords, numSpaces, curLength, maxWidth);
            }
            
            // System.out.println(temp);
            res.add(temp);
            index = i;
        }
        return res;
    }

    public String fullJustify(List<String> words, int numSpaces, int curLength, int maxWidth) {
        if(numSpaces == 0) {
            return leftJustify(words, numSpaces, curLength, maxWidth);
        }
        StringBuilder res = new StringBuilder(words.get(0));
        int totalSpace = maxWidth - curLength;
        int dividedSpace = totalSpace / numSpaces;
        int remainingSpace = totalSpace % numSpaces;
        for(int i=1; i<words.size(); i++) {
            if(i<=remainingSpace) {
                res.append(" ".repeat(dividedSpace + 1));
            }
            else {
                res.append(" ".repeat(dividedSpace));
            }
            res.append(words.get(i));
        }
        return res.toString();
    }
    public String leftJustify(List<String> words, int numSpaces, int curLength, int maxWidth) {
        if(words.size() == 0) return "";
        StringBuilder res = new StringBuilder(words.get(0));
        for(int i=1; i<words.size(); i++) {
            res.append(" ");
            res.append(words.get(i));

        }
        int remainingSpace = maxWidth - curLength - numSpaces;
        //res.append(" ".repeat(Math.max(0, remainingSpace)));
        res.append(" ".repeat(remainingSpace));
        return res.toString();
    }
}