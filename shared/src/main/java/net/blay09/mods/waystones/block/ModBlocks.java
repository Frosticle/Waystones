package net.blay09.mods.waystones.block;

import net.blay09.mods.balm.api.Balm;
import net.blay09.mods.balm.api.block.BalmBlocks;
import net.blay09.mods.waystones.Waystones;
import net.blay09.mods.waystones.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class ModBlocks {

    public static Block waystone;
    public static Block andesiteWaystone;
    public static Block dioriteWaystone;
    public static Block graniteWaystone;
    public static Block deepslateWaystone;
    public static Block smoothWaystone;
    public static Block prismarineWaystone;
    public static Block mossyWaystone;
    public static Block sandyWaystone;
    public static Block redSandyWaystone;
    public static Block basaltWaystone;
    public static Block quartzWaystone;
    public static Block blackWaystone;
    public static Block netherWaystone;
    public static Block endWaystone;
    public static Block purpurWaystone;
    public static Block sharestone;
    public static Block warpPlate;
    public static Block portstone;
    public static Block[] scopedSharestones = new SharestoneBlock[DyeColor.values().length];

    public static void initialize(BalmBlocks blocks) {
        blocks.register(() -> waystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(waystone), id("waystone"));
        blocks.register(() -> andesiteWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(andesiteWaystone), id("andesite_waystone"));
        blocks.register(() -> dioriteWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(dioriteWaystone), id("diorite_waystone"));
        blocks.register(() -> graniteWaystone = new WaystoneBlock(defaultProperties()), ()-> itemBlock(graniteWaystone), id("granite_waystone"));
        blocks.register(() -> deepslateWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(deepslateWaystone), id("deepslate_waystone"));
        blocks.register(() -> smoothWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(smoothWaystone), id("smooth_waystone"));
        blocks.register(() -> prismarineWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(prismarineWaystone), id("prismarine_waystone"));
        blocks.register(() -> mossyWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(mossyWaystone), id("mossy_waystone"));
        blocks.register(() -> sandyWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(sandyWaystone), id("sandy_waystone"));
        blocks.register(() -> redSandyWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(redSandyWaystone), id("red_sandy_waystone"));
        blocks.register(() -> basaltWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(basaltWaystone), id("basalt_waystone"));
        blocks.register(() -> quartzWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(quartzWaystone), id("quartz_waystone"));
        blocks.register(() -> blackWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(blackWaystone), id("black_waystone"));
        blocks.register(() -> netherWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(netherWaystone), id("nether_waystone"));
        blocks.register(() -> endWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(endWaystone), id("end_waystone"));
        blocks.register(() -> purpurWaystone = new WaystoneBlock(defaultProperties()), () -> itemBlock(purpurWaystone), id("purpur_waystone"));

        blocks.register(() -> sharestone = new SharestoneBlock(defaultProperties(), null), () -> itemBlock(sharestone), id("sharestone"));
        blocks.register(() -> warpPlate = new WarpPlateBlock(defaultProperties()), () -> itemBlock(warpPlate), id("warp_plate"));
        blocks.register(() -> portstone = new PortstoneBlock(defaultProperties()), () -> itemBlock(portstone), id("portstone"));

        DyeColor[] colors = DyeColor.values();
        for (DyeColor color : colors) {
            blocks.register(() -> scopedSharestones[color.ordinal()] = new SharestoneBlock(defaultProperties(), color), () -> itemBlock(scopedSharestones[color.ordinal()]), id(color.getSerializedName() + "_sharestone"));
        }
    }

    private static BlockItem itemBlock(Block block) {
        return new BlockItem(block, Balm.getBlocks().itemProperties(ModItems.creativeModeTab));
    }

    private static ResourceLocation id(String name) {
        return new ResourceLocation(Waystones.MOD_ID, name);
    }

    private static BlockBehaviour.Properties defaultProperties() {
        return Balm.getBlocks().blockProperties(Material.STONE).sound(SoundType.STONE).strength(5f, 2000f);
    }
}
