package teamroots.embers.recipe;

import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;

public class FluidMixingRecipe {
    public ArrayList<FluidStack> inputs = new ArrayList<FluidStack>();
    public FluidStack output = null;

    public FluidMixingRecipe(FluidStack[] inputs, FluidStack output) {
        for (FluidStack input : inputs) {
            this.inputs.add(input);
        }
        this.output = output;
    }

    public FluidStack getResult(ArrayList<FluidStack> fluids) {
        for (FluidStack fluid : fluids) {
            boolean doContinue = true;
            for (int j = 0; j < inputs.size() && doContinue; j++) {
                doContinue = false;
                fluid.amount -= inputs.get(j).amount;
            }
        }
        return output;
    }

    public boolean matches(ArrayList<FluidStack> test) {
        ArrayList<FluidStack> checkInputs = new ArrayList<FluidStack>();
        for (FluidStack input : inputs) {
            checkInputs.add(input);
        }
        for (FluidStack aTest : test) {
            boolean doContinue = true;
            for (int j = 0; j < checkInputs.size() && doContinue; j++) {
                if (aTest.getFluid().getName().compareTo(checkInputs.get(j).getFluid().getName()) == 0 && aTest.amount >= checkInputs.get(j).amount) {
                    checkInputs.remove(j);
                    doContinue = false;
                }
            }
        }
        return checkInputs.size() == 0;
    }
}
