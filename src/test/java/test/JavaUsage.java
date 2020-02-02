package test;

import br.com.gamemods.nbtmanipulator.NbtInt;
import br.com.gamemods.nbtmanipulator.NbtList;
import br.com.gamemods.nbtmanipulator.NbtUtil;
import junit.framework.TestCase;

import java.util.Arrays;

public class JavaUsage extends TestCase {
    public void testIntListIterableToList() {
        NbtList<NbtList<NbtInt>> tag = NbtUtil.intListIterableToList(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5, 6)
                )
        );
    }

    public void testIntIterableToList() {
        NbtList<NbtInt> tags = NbtUtil.intIterableToList(Arrays.asList(1,2,3));
    }

    public void testNbtList() {
        NbtList<NbtInt> tags = NbtList.create(1, 2, 3);
    }

    public void testCreateSublist() {
        NbtList<NbtList<NbtInt>> tags = NbtList.createIntSublist(
                new int[]{1,2,3},
                new int[]{4,5,6}
        );
    }
}
