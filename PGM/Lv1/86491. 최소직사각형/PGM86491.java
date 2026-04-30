public class PGM86491 {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for(int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];

            if(width < height) {
                int temp = width;
                width = height;
                height = temp;
            }

            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
//            maxWidth = Math.max(maxWidth, Math.max(sizes[i][0], sizes[i][1]));
//            maxHeight = Math.max(maxHeight, Math.min(sizes[i][0], sizes[i][1]));
        }

        return maxWidth * maxHeight;
    }

}
