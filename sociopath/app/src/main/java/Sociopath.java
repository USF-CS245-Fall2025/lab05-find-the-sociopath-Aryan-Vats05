import java.util.List;

public class Sociopath {

    public int findTheSociopath (int groupSize, List<int []> likeList) {
        if(groupSize <= 0){
            return -1;
        }

        for(int[] pair : likeList){
            if(pair[0] < 1 || pair[0] > groupSize || pair[1] < 1 || pair[1] > groupSize){
                return -1;
            }
        }

        for(int p1 = 1; p1 <= groupSize; p1++) {
            boolean likes = false;
            boolean isLikedByEveryone = true;

            for (int[] pair : likeList) {
                if (pair[0] == p1) {
                    likes = true;
                    break;
                }
            }

            if (likes) {        //onto the next possible sociopath
                continue;
            }

            for (int member = 1; member <= groupSize; member++) {
                if (member == p1) {
                    continue;
                }

                boolean memberLikesP1 = false;      //checks if every member likes the possible sociopath
                for (int[] pair : likeList) {
                    if (pair[0] == member && pair[1] == p1) {
                        memberLikesP1 = true;
                        break;
                    }
                }

                if (!memberLikesP1) {
                    isLikedByEveryone = false;
                    break;
                }
            }

                if (isLikedByEveryone) {
                    return p1;
                }
            }
        return -1;
    }
}