import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SociopathTest{
    @Test
    void TwoLikesNoOne(){
        Sociopath sc = new Sociopath();
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});


        assertEquals(2, sc.findTheSociopath(2, likeList));
    }

    @Test
    void NoOneLikesThree(){
        Sociopath sc = new Sociopath();
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});

        assertEquals(-1, sc.findTheSociopath(3, likeList));
    }

    @Test
    void SociopathIsThree(){
        Sociopath sc = new Sociopath();
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});
        likeList.add(new int[]{1, 3});
        likeList.add(new int[]{2, 3});

        assertEquals(3, sc.findTheSociopath(3, likeList));
    }

    @Test
    void EveryoneLikesSomeoneElse(){
        Sociopath sc = new Sociopath();
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 3});
        likeList.add(new int[]{2, 3});
        likeList.add(new int[]{3, 1});

        assertEquals(-1, sc.findTheSociopath(3, likeList));
    }

    @Test
    void InvalidGroupSize(){
        Sociopath sc = new Sociopath();
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 2});

        assertEquals(-1, sc.findTheSociopath(0, likeList));
    }

    @Test
    void InvalidMember(){
        Sociopath sc = new Sociopath();
        List<int[]> likeList = new ArrayList<>();
        likeList.add(new int[]{1, 0});

        assertEquals(-1, sc.findTheSociopath(3, likeList));
    }
}