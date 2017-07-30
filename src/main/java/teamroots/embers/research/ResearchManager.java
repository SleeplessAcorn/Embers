package teamroots.embers.research;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import teamroots.embers.item.IEmberItem;
import teamroots.embers.registry.RegistrarEmbersBlocks;
import teamroots.embers.registry.RegistrarEmbersItems;

import java.util.ArrayList;
import java.util.List;

public class ResearchManager {
    public static List<ResearchCategory> researches = new ArrayList<ResearchCategory>();

    public static ResearchBase dials, boiler, ores, hammer, ancient_golem, gauge, caminite, bore, crystals, activator, pipes, tank, bin,//WORLD
            copper_cell, emitters, dawnstone, dropper, melter, stamper, mixer, breaker, hearth_coil, access, reservoir, vacuum, transfer, //MECHANISMS
            ember_ejector, beam_cannon, splitter, dawnstone_anvil, autohammer, crystal_cell, cinder_staff, clockwork_tools, blazing_ray, charger, jars, alchemy, cinder_plinth, aspecti, //METALLURGY
            tyrfing, waste, wildfire, cluster, combustor, catalyzer, reactor, injector, ashen_cloak, inflictor, materia, misc_alchemy, adhesive, //ALCHEMY
            modifiers, inferno_forge, heat, superheater, cinder_jet, caster_orb, resonating_bell, eldritch_insignia, blasting_core, intelligent_apparatus, flame_barrier //SMITHING
            ;

    public static void initResearches() {
        //WORLD
        ores = new ResearchBase("ores", new ItemStack(RegistrarEmbersBlocks.ORE_COPPER), 0, 7);
        hammer = new ResearchBase("hammer", new ItemStack(RegistrarEmbersItems.TINKER_HAMMER), 0, 3).addAncestor(ores);
        ancient_golem = new ResearchBase("ancient_golem", new ItemStack(RegistrarEmbersItems.ANCIENT_MOTIVE_CORE), 0, 0);
        gauge = new ResearchBase("gauge", new ItemStack(RegistrarEmbersItems.EMBER_DETECTOR), 4, 3).addAncestor(ores);
        caminite = new ResearchBase("caminite", new ItemStack(RegistrarEmbersItems.BRICK_CAMINITE), 6, 7);
        tank = new ResearchBase("tank", new ItemStack(RegistrarEmbersBlocks.BLOCK_TANK), 3, 7).addAncestor(caminite);
        bore = new ResearchBase("bore", new ItemStack(RegistrarEmbersBlocks.EMBER_BORE), 9, 0).addAncestor(hammer).addAncestor(caminite);
        crystals = new ResearchBase("crystals", new ItemStack(RegistrarEmbersItems.CRYSTAL_EMBER), 12, 3).addAncestor(bore);
        activator = new ResearchBase("activator", new ItemStack(RegistrarEmbersBlocks.EMBER_ACTIVATOR), 9, 5).addAncestor(crystals);
        boiler = new ResearchBase("boiler", new ItemStack(RegistrarEmbersBlocks.BOILER), 9, 7).addAncestor(activator);
        pipes = new ResearchBase("pipes", new ItemStack(RegistrarEmbersBlocks.PUMP), 3, 0).addAncestor(ores);
        bin = new ResearchBase("bin", new ItemStack(RegistrarEmbersBlocks.BIN), 12, 7);
        dials = new ResearchBase("dials", new ItemStack(RegistrarEmbersBlocks.EMBER_GAUGE), 5, 5).addAncestor(ores);

        //MECHANISMS
        emitters = new ResearchBase("emitters", new ItemStack(RegistrarEmbersBlocks.EMBER_EMITTER), 0, 2);
        melter = new ResearchBase("melter", new ItemStack(RegistrarEmbersBlocks.BLOCK_FURNACE), 2, 0).addAncestor(emitters);
        stamper = new ResearchBase("stamper", new ItemStack(RegistrarEmbersBlocks.STAMPER), 2, 4).addAncestor(melter).addAncestor(emitters);
        access = new ResearchBase("access", new ItemStack(RegistrarEmbersBlocks.MECH_CORE), 7, 5).addAncestor(stamper);
        hearth_coil = new ResearchBase("hearth_coil", new ItemStack(RegistrarEmbersBlocks.HEAT_COIL), 10, 1).addAncestor(access);
        mixer = new ResearchBase("mixer", new ItemStack(RegistrarEmbersBlocks.MIXER), 5, 2).addAncestor(stamper).addAncestor(melter);
        reservoir = new ResearchBase("reservoir", new ItemStack(RegistrarEmbersBlocks.LARGE_TANK), 8, 0).addAncestor(access);
        transfer = new ResearchBase("transfer", new ItemStack(RegistrarEmbersBlocks.ITEM_TRANSFER), 0, 7);
        vacuum = new ResearchBase("vacuum", new ItemStack(RegistrarEmbersBlocks.VACUUM), 8, 7);
        breaker = new ResearchBase("breaker", new ItemStack(RegistrarEmbersBlocks.BREAKER), 4, 7).addAncestor(stamper);
        dropper = new ResearchBase("dropper", new ItemStack(RegistrarEmbersBlocks.ITEM_DROPPER), 12, 7);
        dawnstone = new ResearchBase("dawnstone", new ItemStack(RegistrarEmbersItems.INGOT_DAWNSTONE), 11, 4).addAncestor(mixer);
        copper_cell = new ResearchBase("copper_cell", new ItemStack(RegistrarEmbersBlocks.COPPER_CELL), 0, 5).addAncestor(emitters);

        //METALLURGY
        splitter = new ResearchBase("splitter", new ItemStack(RegistrarEmbersBlocks.BEAM_SPLITTER), 0, 6);
        ember_ejector = new ResearchBase("ember_ejector", new ItemStack(RegistrarEmbersBlocks.EMBER_PULSER), 0, 3.5);
        dawnstone_anvil = new ResearchBase("dawnstone_anvil", new ItemStack(RegistrarEmbersBlocks.DAWNSTONE_ANVIL), 3, 7);
        autohammer = new ResearchBase("autohammer", new ItemStack(RegistrarEmbersBlocks.AUTO_HAMMER), 7, 7).addAncestor(dawnstone_anvil);
        crystal_cell = new ResearchBase("crystal_cell", new ItemStack(RegistrarEmbersBlocks.CRYSTAL_CELL), 0, 1);
        charger = new ResearchBase("charger", new ItemStack(RegistrarEmbersBlocks.CHARGER), 3, 0);
        ItemStack fullJar = new ItemStack(RegistrarEmbersItems.EMBER_JAR);
        fullJar.setTagCompound(new NBTTagCompound());
        ((IEmberItem) RegistrarEmbersItems.EMBER_JAR).setEmberCapacity(fullJar, 1000.0);
        ((IEmberItem) RegistrarEmbersItems.EMBER_JAR).setEmber(fullJar, ((IEmberItem) RegistrarEmbersItems.EMBER_JAR).getEmberCapacity(fullJar));
        jars = new ResearchBase("jars", fullJar, 6, 1).addAncestor(charger);
        clockwork_tools = new ResearchBase("clockwork_tools", new ItemStack(RegistrarEmbersItems.AXE_CLOCKWORK), 2, 4).addAncestor(jars);
        cinder_staff = new ResearchBase("cinder_staff", new ItemStack(RegistrarEmbersItems.STAFF_EMBER), 5, 5).addAncestor(jars);
        blazing_ray = new ResearchBase("blazing_ray", new ItemStack(RegistrarEmbersItems.IGNITION_CANNON), 8, 4).addAncestor(jars);
        aspecti = new ResearchBase("aspecti", new ItemStack(RegistrarEmbersItems.ASPECTUS_DAWNSTONE), 12, 1);
        cinder_plinth = new ResearchBase("cinder_plinth", new ItemStack(RegistrarEmbersBlocks.CINDER_PLINTH), 9, 0);
        beam_cannon = new ResearchBase("beam_cannon", new ItemStack(RegistrarEmbersBlocks.BEAM_CANNON), 12, 7);
        alchemy = new ResearchBase("alchemy", new ItemStack(RegistrarEmbersBlocks.ALCHEMY_TABLET), 9, 6).addAncestor(cinder_plinth).addAncestor(aspecti).addAncestor(beam_cannon);

        //TRANSMUTATION
        waste = new ResearchBase("waste", new ItemStack(RegistrarEmbersItems.ALCHEMIC_WASTE), 6, 0);
        misc_alchemy = new ResearchBase("misc_alchemy", new ItemStack(Blocks.NETHERRACK), 0, 1).addAncestor(waste);
        materia = new ResearchBase("materia", new ItemStack(RegistrarEmbersItems.ISOLATED_MATERIA), 6, 3).addAncestor(waste);
        adhesive = new ResearchBase("adhesive", new ItemStack(RegistrarEmbersItems.ADHESIVE), 12, 1).addAncestor(waste);
        cluster = new ResearchBase("cluster", new ItemStack(RegistrarEmbersItems.EMBER_CLUSTER), 3, 2).addAncestor(waste);
        ashen_cloak = new ResearchBase("ashen_cloak", new ItemStack(RegistrarEmbersItems.ASHEN_CLOAK_CHEST), 9, 2).addAncestor(waste);
        wildfire = new ResearchBase("wildfire", new ItemStack(RegistrarEmbersItems.WILDFIRE_CORE), 1, 4).addAncestor(cluster);
        inflictor = new ResearchBase("inflictor", new ItemStack(RegistrarEmbersItems.INFLICTOR_GEM), 11, 5).addAncestor(ashen_cloak);
        injector = new ResearchBase("injector", new ItemStack(RegistrarEmbersBlocks.EMBER_INJECTOR), 0, 7).addAncestor(wildfire);
        combustor = new ResearchBase("combustor", new ItemStack(RegistrarEmbersBlocks.COMBUSTOR), 6, 5).addAncestor(wildfire);
        catalyzer = new ResearchBase("catalyzer", new ItemStack(RegistrarEmbersBlocks.CATALYZER), 5, 7).addAncestor(wildfire);
        reactor = new ResearchBase("reactor", new ItemStack(RegistrarEmbersBlocks.REACTOR), 9, 7).addAncestor(combustor).addAncestor(catalyzer);
        tyrfing = new ResearchBase("tyrfing", new ItemStack(RegistrarEmbersItems.TYRFING), 8, 4).addAncestor(waste);

        //SMITHING
        modifiers = new ResearchBase("modifiers", new ItemStack(RegistrarEmbersItems.ANCIENT_MOTIVE_CORE), 5, 7);
        heat = new ResearchBase("heat", new ItemStack(RegistrarEmbersItems.CRYSTAL_EMBER), 7, 7);
        inferno_forge = new ResearchBase("inferno_forge", new ItemStack(RegistrarEmbersBlocks.INFERNO_FORGE), 6, 4).addAncestor(heat);
        superheater = new ResearchBase("superheater", new ItemStack(RegistrarEmbersItems.SUPERHEATER), 1, 7).addAncestor(inferno_forge);
        cinder_jet = new ResearchBase("cinder_jet", new ItemStack(RegistrarEmbersItems.JET_AUGMENT), 0, 5).addAncestor(inferno_forge);
        blasting_core = new ResearchBase("blasting_core", new ItemStack(RegistrarEmbersItems.BLASTING_CORE), 0, 3).addAncestor(inferno_forge);
        caster_orb = new ResearchBase("caster_orb", new ItemStack(RegistrarEmbersItems.CASTER_ORB), 1, 1).addAncestor(inferno_forge);
        flame_barrier = new ResearchBase("flame_barrier", new ItemStack(RegistrarEmbersItems.FLAME_BARRIER), 11, 1).addAncestor(inferno_forge);
        eldritch_insignia = new ResearchBase("eldritch_insignia", new ItemStack(RegistrarEmbersItems.ELDRITCH_INSIGNIA), 12, 3).addAncestor(inferno_forge);
        intelligent_apparatus = new ResearchBase("intelligent_apparatus", new ItemStack(RegistrarEmbersItems.INTELLIGENT_APPARATUS), 12, 5).addAncestor(inferno_forge);
        resonating_bell = new ResearchBase("resonating_bell", new ItemStack(RegistrarEmbersItems.RESONATING_BELL), 11, 7).addAncestor(inferno_forge);

        researches.add(new ResearchCategory("world", 16)
                .addResearch(ores)
                .addResearch(hammer)
                .addResearch(ancient_golem)
                .addResearch(gauge)
                .addResearch(caminite)
                .addResearch(bore)
                .addResearch(tank)
                .addResearch(pipes)
                .addResearch(bin)
                .addResearch(crystals)
                .addResearch(activator)
                .addResearch(boiler)
                .addResearch(dials));
        researches.add(new ResearchCategory("mechanisms", 32)
                .addResearch(melter)
                .addResearch(stamper)
                .addResearch(hearth_coil)
                .addResearch(mixer)
                .addResearch(access)
                .addResearch(reservoir)
                .addResearch(transfer)
                .addResearch(vacuum)
                .addResearch(dropper)
                .addResearch(breaker)
                .addResearch(dawnstone)
                .addResearch(emitters)
                .addResearch(copper_cell));
        researches.add(new ResearchCategory("metallurgy", 48)
                .addResearch(splitter)
                .addResearch(dawnstone_anvil)
                .addResearch(autohammer)
                .addResearch(crystal_cell)
                .addResearch(charger)
                .addResearch(jars)
                .addResearch(clockwork_tools)
                .addResearch(cinder_staff)
                .addResearch(blazing_ray)
                .addResearch(cinder_plinth)
                .addResearch(aspecti)
                .addResearch(alchemy)
                .addResearch(beam_cannon));
        researches.add(new ResearchCategory("alchemy", 64)
                .addResearch(waste)
                .addResearch(misc_alchemy)
                .addResearch(adhesive)
                .addResearch(cluster)
                .addResearch(ashen_cloak)
                .addResearch(inflictor)
                .addResearch(wildfire)
                .addResearch(injector)
                .addResearch(reactor)
                .addResearch(combustor)
                .addResearch(catalyzer)
                .addResearch(materia)
                .addResearch(tyrfing));
        researches.add(new ResearchCategory("smithing", 80)
                .addResearch(modifiers)
                .addResearch(heat)
                .addResearch(inferno_forge)
                .addResearch(superheater)
                .addResearch(cinder_jet)
                .addResearch(blasting_core)
                .addResearch(caster_orb)
                .addResearch(eldritch_insignia)
                .addResearch(intelligent_apparatus)
                .addResearch(resonating_bell)
                .addResearch(flame_barrier));
        //researches.add(new ResearchCategory("materia", 80));
        //researches.add(new ResearchCategory("core", 96));
    }
}
