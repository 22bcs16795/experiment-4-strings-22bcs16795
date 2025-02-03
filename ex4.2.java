class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length(), nLen = needle.length();
        if (nLen == 0) return 0;

        int[] lps = new int[nLen];
        computeLPS(needle, nLen, lps);

        int i = 0, j = 0; // i → haystack index, j → needle index
        while (i < hLen) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
            }
            if (j == nLen) return i - j;
            else if (i < hLen && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    private void computeLPS(String needle, int n, int[] lps) {
        int len = 0, i = 1;
        while (i < n) {
            if (needle.charAt(i) == needle.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
    }
}
