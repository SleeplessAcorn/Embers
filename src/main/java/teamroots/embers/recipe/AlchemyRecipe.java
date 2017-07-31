package teamroots.embers.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teamroots.embers.item.ItemAlchemicWaste;
import teamroots.embers.util.MatchUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlchemyRecipe {
    public int ironAspectMin = 0, dawnstoneAspectMin = 0, copperAspectMin = 0, silverAspectMin = 0, leadAspectMin = 0;
    public int ironAspectRange = 0, dawnstoneAspectRange = 0, copperAspectRange = 0, silverAspectRange = 0, leadAspectRange = 0;
    public List<ItemStack> inputs = new ArrayList<ItemStack>();
    public ItemStack centerInput = ItemStack.EMPTY;
    public ItemStack result = ItemStack.EMPTY;
    Random random = new Random();

    public AlchemyRecipe(int ironMin, int ironMax, int dawnstoneMin, int dawnstoneMax, int copperMin, int copperMax, int silverMin, int silverMax, int leadMin, int leadMax, ItemStack center, ItemStack east, ItemStack west, ItemStack north, ItemStack south, ItemStack result) {
        this.ironAspectMin = ironMin;
        this.ironAspectRange = ironMax - ironMin;
        this.dawnstoneAspectMin = dawnstoneMin;
        this.dawnstoneAspectRange = dawnstoneMax - dawnstoneMin;
        this.copperAspectMin = copperMin;
        this.copperAspectRange = copperMax - copperMin;
        this.silverAspectMin = silverMin;
        this.silverAspectRange = silverMax - silverMin;
        this.leadAspectMin = leadMin;
        this.leadAspectRange = leadMax - leadMin;
        this.centerInput = center;
        if (!east.isEmpty()) {
            inputs.add(east);
        }
        if (!west.isEmpty()) {
            inputs.add(west);
        }
        if (!north.isEmpty()) {
            inputs.add(north);
        }
        if (!south.isEmpty()) {
            inputs.add(south);
        }
        this.result = result;
    }

    public int getIron(World world) {
        random = new Random(world.getSeed());
        return this.ironAspectMin + random.nextInt(this.ironAspectRange + 1);
    }

    public int getDawnstone(World world) {
        random = new Random(world.getSeed());
        return this.dawnstoneAspectMin + random.nextInt(this.dawnstoneAspectRange + 1);
    }

    public int getCopper(World world) {
        random = new Random(world.getSeed());
        return this.copperAspectMin + random.nextInt(this.copperAspectRange + 1);
    }

    public int getSilver(World world) {
        random = new Random(world.getSeed());
        return this.silverAspectMin + random.nextInt(this.silverAspectRange + 1);
    }

    public int getLead(World world) {
        random = new Random(world.getSeed());
        return this.leadAspectMin + random.nextInt(this.leadAspectRange + 1);
    }

    public ItemStack getResult(World world, int iron, int dawnstone, int copper, int silver, int lead) {
        double dIron = Math.abs((double) (iron - getIron(world)));
        double dDawnstone = Math.abs((double) (dawnstone - getDawnstone(world)));
        double dCopper = Math.abs((double) (copper - getCopper(world)));
        double dSilver = Math.abs((double) (silver - getSilver(world)));
        double dLead = Math.abs((double) (lead - getLead(world)));
        double accuracy = Math.max(0, 1.0 - (dIron + dDawnstone + dCopper + dSilver + dLead) / (double) (getIron(world) + getDawnstone(world) + getCopper(world) + getSilver(world) + getLead(world)));
        accuracy = Math.round(accuracy * 100.0) / 100.0;
        if (accuracy == 1.0) {
            return this.result;
        }
        return ItemAlchemicWaste.create((int) dIron, (int) dCopper, (int) dSilver, (int) dDawnstone, (int) dLead, iron + dawnstone + copper + silver + lead);
    }

    public boolean matches(ItemStack center, List<ItemStack> test) {
        if (MatchUtil.areStacksEqualOreDict(center, this.centerInput)) {
            return MatchUtil.stackListsMatch(this.inputs, test);
        }
        return false;
    }
}
