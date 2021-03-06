package com.ferreusveritas.growingtrees;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static float seedDropRate;
	public static float seedPlantRate;
	public static int seedTimeToLive;
	public static float treeGrowthRateMultiplier;
	public static float treeHarvestMultiplier;
	public static boolean ignoreBiomeGrowthRate;
	public static float diseaseChance;
	
	public static void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		seedDropRate = config.getFloat("dropRate", "seeds", 1f/256f, 0, 1, "The rate at which seeds automatically drop from branches");
		seedPlantRate = config.getFloat("plantRate", "seeds", 1f/16f, 0, 1, "The rate at which seeds plant themselves in their ideal biomes");
		seedTimeToLive = config.getInt("timeToLive", "seeds", 1200, 0, 6000, "Ticks before a seed in the world attempts to plant itself or despawn. 1200 = 1 minute");

		treeGrowthRateMultiplier = config.getFloat("growthRateMultiplier", "trees", 1f, 0, 16f, "Factor that multiplies the rate at which trees grow. Use at own risk");
		treeHarvestMultiplier = config.getFloat("harvestMultiplier", "trees", 1f, 0f, 128f, "Factor that multiplies the wood returned from harvesting a tree.  You cheat.");
		ignoreBiomeGrowthRate = config.getBoolean("ignoreBiomeGrowthRate", "trees", false, "If enabled all trees grow as if they are in their native biome");
		diseaseChance = config.getFloat("diseaseChance", "trees", 0.0f, 0.0f, 1.0f, "The chance of a tree on depleted soil to die. 1/256(~0.004) averages to about 1 death every 16 minecraft days");

		config.save();
	}
}
