import java.util.AbstractList;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        return new AbstractList<Integer>() {
            List<Integer> list;

            @Override
            public Integer get(int index) {
                if(list == null) list = getResults(s, words);
                return list.get(index);
            }

            @Override
            public int size() {
                if(list == null) list = getResults(s, words);
                return list.size();
            }

        };
    }
    private static List<Integer> getResults(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = words.length * wordLen;

        if (s.length() < totalLen) return result;
        Map<String, Integer> wordMap = new HashMap<>();

        for(String word: words) wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            int count = 0;
            Map<String,Integer> windowMap = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String part = s.substring(right, right + wordLen);
                right += wordLen;
                if(!wordMap.containsKey(part)) {
                    windowMap.clear();
                    count = 0;
                    left = right;
                    continue;
                }
                windowMap.put(part, windowMap.getOrDefault(part, 0) + 1);
                count++;

                while (windowMap.get(part) > wordMap.get(part)) {
                    String leftWord = s.substring(left, left + wordLen);
                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                    count--;
                    left += wordLen;
                }
                if (count == words.length) result.add(left);
            }

        }
        return result;
    }




    public static List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || s.isEmpty() || words.length == 0) return result;

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String w : words) wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);

        int m = s.length();
        int n = words.length;
        int wordLen = words[0].length();

        // Try all starting points modulo wordLen
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for (int right = i; right + wordLen <= m; right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordFreq.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    // Too many of this word → shrink from left
                    while (seen.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Window is exactly n words → valid index
                    if (count == n) {
                        result.add(left);
                        // Move left by one word to continue
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                } else {
                    // reset window
                    seen.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return result;
    }





    /**
        01234567
        barfoothefoobarman
             i

           

     */
    public List<Integer> findSubstringNotWorking(String s, String[] words) {
        Set<String> set = new HashSet<>();
        for(String word: words) {
            set.add(word);
        }

        List<Integer> startIndexes = new ArrayList<>();
        String tempS = new String("");
        int prevWordEndIndex = -2;
        for(int i=0; i<s.length(); i++) {
            tempS += s.charAt(i);
            if(set.contains(tempS)) {
                System.out.println(tempS);
                int tempStrStartI = i-tempS.length()+1;
                if(tempStrStartI-1 != prevWordEndIndex) { // (tempStrStartI-1 == prevWordEndIndexstill) means --> still under same combination
                    startIndexes.add(tempStrStartI);
                }
                tempS = new String("");
                prevWordEndIndex = i;
            }
            if(tempS.length() == words[0].length()) {
                tempS = new String("");
            }
        }

        return startIndexes;
    }
}