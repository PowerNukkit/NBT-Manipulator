package test;

import br.com.gamemods.nbtmanipulator.NbtInt;
import br.com.gamemods.nbtmanipulator.NbtList;
import br.com.gamemods.nbtmanipulator.NbtUtil;
import org.junit.Test;

import java.util.Arrays;

public class JavaUsage {
    @Test
    public void intListIterableToList() {
        NbtList<NbtList<NbtInt>> tag = NbtUtil.intListIterableToList(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5, 6)
                )
        );
    }

    @Test
    public void intIterableToList() {
        NbtList<NbtInt> tags = NbtUtil.intIterableToList(Arrays.asList(1,2,3));
    }

    @Test
    public void nbtList() {
        NbtList<NbtInt> tags = NbtList.create(1, 2, 3);
    }

    @Test public void createSublist() {
        NbtList<NbtList<NbtInt>> tags = NbtList.createIntSublist(
                new int[]{1,2,3},
                new int[]{4,5,6}
        );
    }
}
