/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.datagen.recipes.machine.industrial_grinder

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.fluid.Fluids
import net.minecraft.item.Items
import net.minecraft.registry.RegistryWrapper
import techreborn.datagen.recipes.TechRebornRecipesProvider
import techreborn.init.ModFluids
import techreborn.init.TRContent

import java.util.concurrent.CompletableFuture

class IndustrialGrinderRecipesProvider extends TechRebornRecipesProvider {

	public final int ARMOR_POWER = 128
	public final int ARMOR_TIME = 140
	public final long ARMOR_FLUID_AMOUNT = 1000L // in millibuckets
	public final int TOOL_POWER = ARMOR_POWER
	public final int TOOL_TIME = ARMOR_TIME
	public final long TOOL_FLUID_AMOUNT = 500L // in millibuckets
	var dustMap = TRContent.SmallDusts.SD2DMap

	IndustrialGrinderRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture)
	}

	@Override
	void generateRecipes() {
		generateBoots()
		generateChestplate()
		generateHelmet()
		generateLeggings()
		generateHorseArmor()
		generateSword()
		generateShovel()
		generateHoe()
		generateAxe()
		generatePickaxe()
		generateTrimTemplates()
		generateOres()
	}

	void generateBoots() {
		final int count = 2
		[
			(Items.DIAMOND_BOOTS)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_BOOTS)  : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_BOOTS)     : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_BOOTS) : TRContent.SmallDusts.SAPPHIRE
		].each {boots, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients boots
				outputs stack(dustMap.get(smallDust), count-1), stack(smallDust, 2)
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				source "boots_with_water"
				criterion getCriterionName(boots), getCriterionConditions(boots)
			}
			offerIndustrialGrinderRecipe {
				ingredients boots
				outputs stack(dustMap.get(smallDust), count+1), smallDust
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "boots_with_mercury"
				criterion getCriterionName(boots), getCriterionConditions(boots)
			}
		}
	}

	void generateChestplate() {
		final int count = 5
		[
			(Items.DIAMOND_CHESTPLATE)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_CHESTPLATE)  : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_CHESTPLATE)     : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_CHESTPLATE) : TRContent.SmallDusts.SAPPHIRE
		].each {chestplate, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients chestplate
				outputs stack(dustMap.get(smallDust), count-1), stack(smallDust, 2)
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				source "chestplate_with_water"
				criterion getCriterionName(chestplate), getCriterionConditions(chestplate)
			}
			offerIndustrialGrinderRecipe {
				ingredients chestplate
				outputs stack(dustMap.get(smallDust), count+1), smallDust
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "chestplate_with_mercury"
				criterion getCriterionName(chestplate), getCriterionConditions(chestplate)
			}
		}
	}

	void generateHelmet() {
		final int count = 3
		[
			(Items.DIAMOND_HELMET)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_HELMET)  : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_HELMET)     : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_HELMET) : TRContent.SmallDusts.SAPPHIRE
		].each {helmet, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients helmet
				outputs stack(dustMap.get(smallDust), count-1), stack(smallDust, 2)
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				source "helmet_with_water"
				criterion getCriterionName(helmet), getCriterionConditions(helmet)
			}
			offerIndustrialGrinderRecipe {
				ingredients helmet
				outputs stack(dustMap.get(smallDust), count+1), smallDust
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "helmet_with_mercury"
				criterion getCriterionName(helmet), getCriterionConditions(helmet)
			}
		}
	}

	void generateLeggings() {
		final int count = 4
		[
			(Items.DIAMOND_LEGGINGS)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_LEGGINGS)  : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_LEGGINGS)     : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_LEGGINGS) : TRContent.SmallDusts.SAPPHIRE
		].each {leggings, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients leggings
				outputs stack(dustMap.get(smallDust), count-1), stack(smallDust, 2)
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				source "leggings_with_water"
				criterion getCriterionName(leggings), getCriterionConditions(leggings)
			}
			offerIndustrialGrinderRecipe {
				ingredients leggings
				outputs stack(dustMap.get(smallDust), count+1), smallDust
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "leggings_with_mercury"
				criterion getCriterionName(leggings), getCriterionConditions(leggings)
			}
		}
	}

	void generateHorseArmor() {
		final int count = 4
		[
			(Items.DIAMOND_HORSE_ARMOR) : TRContent.SmallDusts.DIAMOND
		].each {horseArmor, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients horseArmor
				outputs stack(dustMap.get(smallDust), count-1), stack(smallDust, 2)
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				source "horse_armor_with_water"
				criterion getCriterionName(horseArmor), getCriterionConditions(horseArmor)
			}
			offerIndustrialGrinderRecipe {
				ingredients horseArmor
				outputs stack(dustMap.get(smallDust), count+1), smallDust
				power ARMOR_POWER
				time ARMOR_TIME
				fluidAmount ARMOR_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "horse_armor_with_mercury"
				criterion getCriterionName(horseArmor), getCriterionConditions(horseArmor)
			}
		}
	}

	void generateSword() {
		[
			(Items.DIAMOND_SWORD)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_SWORD)  : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_SWORD)     : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_SWORD) : TRContent.SmallDusts.SAPPHIRE
		].each {sword, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients sword
				outputs stack(smallDust, 2), TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				source "sword_with_water"
				criterion getCriterionName(sword), getCriterionConditions(sword)
			}
			offerIndustrialGrinderRecipe {
				ingredients sword
				outputs dustMap.get(smallDust), smallDust, TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "sword_with_mercury"
				criterion getCriterionName(sword), getCriterionConditions(sword)
			}
		}
	}

	void generateShovel() {
		[
			(Items.DIAMOND_SHOVEL)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_SPADE)   : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_SPADE)      : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_SPADE)  : TRContent.SmallDusts.SAPPHIRE
		].each {shovel, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients shovel
				outputs smallDust, TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				source "shovel_with_water"
				criterion getCriterionName(shovel), getCriterionConditions(shovel)
			}
			offerIndustrialGrinderRecipe {
				ingredients shovel
				outputs stack(smallDust, 2), TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "shovel_with_mercury"
				criterion getCriterionName(shovel), getCriterionConditions(shovel)
			}
		}
	}

	void generateHoe() {
		[
			(Items.DIAMOND_HOE)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_HOE)  : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_HOE)     : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_HOE) : TRContent.SmallDusts.SAPPHIRE
		].each {hoe, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients hoe
				outputs stack(smallDust, 2), TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				source "hoe_with_water"
				criterion getCriterionName(hoe), getCriterionConditions(hoe)
			}
			offerIndustrialGrinderRecipe {
				ingredients hoe
				outputs dustMap.get(smallDust), smallDust, TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "hoe_with_mercury"
				criterion getCriterionName(hoe), getCriterionConditions(hoe)
			}
		}
	}

	void generateAxe() {
		[
			(Items.DIAMOND_AXE)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_AXE)  : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_AXE)     : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_AXE) : TRContent.SmallDusts.SAPPHIRE
		].each {axe, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients axe
				outputs stack(smallDust, 3), TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				source "axe_with_water"
				criterion getCriterionName(axe), getCriterionConditions(axe)
			}
			offerIndustrialGrinderRecipe {
				ingredients axe
				outputs dustMap.get(smallDust), stack(smallDust, 3), TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "axe_with_mercury"
				criterion getCriterionName(axe), getCriterionConditions(axe)
			}
		}
	}

	void generatePickaxe() {
		[
			(Items.DIAMOND_PICKAXE)      : TRContent.SmallDusts.DIAMOND,
			(TRContent.PERIDOT_PICKAXE)  : TRContent.SmallDusts.PERIDOT,
			(TRContent.RUBY_PICKAXE)     : TRContent.SmallDusts.RUBY,
			(TRContent.SAPPHIRE_PICKAXE) : TRContent.SmallDusts.SAPPHIRE
		].each {pickaxe, smallDust ->
			offerIndustrialGrinderRecipe {
				ingredients pickaxe
				outputs stack(smallDust, 3), TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				source "pickaxe_with_water"
				criterion getCriterionName(pickaxe), getCriterionConditions(pickaxe)
			}
			offerIndustrialGrinderRecipe {
				ingredients pickaxe
				outputs dustMap.get(smallDust), stack(smallDust, 3), TRContent.SmallDusts.SAW
				power TOOL_POWER
				time TOOL_TIME
				fluidAmount TOOL_FLUID_AMOUNT
				fluid ModFluids.MERCURY.getFluid()
				source "pickaxe_with_mercury"
				criterion getCriterionName(pickaxe), getCriterionConditions(pickaxe)
			}
		}
	}

	void generateTrimTemplates() {
		var trim = tag("minecraft:trim_templates");
		offerIndustrialGrinderRecipe {
			ingredients trim
			outputs stack(TRContent.Dusts.DIAMOND, 2), stack(TRContent.SmallDusts.DIAMOND, 3)
			power 128
			time 140
			fluidAmount 1000L
			fluid Fluids.WATER
			source "smithing_template_with_water"
			criterion getCriterionName(trim), getCriterionConditions(trim)
		}
		offerIndustrialGrinderRecipe {
			ingredients trim
			outputs stack(TRContent.Dusts.DIAMOND, 3), stack(TRContent.SmallDusts.DIAMOND, 2)
			power 128
			time 140
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "smithing_template_with_mercury"
			criterion getCriterionName(trim), getCriterionConditions(trim)
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Parts.TEMPLATE_TEMPLATE
			outputs stack(TRContent.Dusts.DIAMOND, 2), stack(TRContent.SmallDusts.DIAMOND, 3)
			power 128
			time 140
			fluidAmount 1000L
			fluid Fluids.WATER
			source "trim_template_with_water"
			criterion getCriterionName(trim), getCriterionConditions(trim)
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Parts.TEMPLATE_TEMPLATE
			outputs stack(TRContent.Dusts.DIAMOND, 3), stack(TRContent.SmallDusts.DIAMOND, 2)
			power 128
			time 140
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "trim_template_with_mercury"
			criterion getCriterionName(trim), getCriterionConditions(trim)
		}
	}

	void generateOres() {
		offerIndustrialGrinderRecipe {
			ingredients Items.ANCIENT_DEBRIS
			outputs stack(Items.NETHERITE_SCRAP, 2), stack(Items.GOLD_NUGGET, 5)
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "ancient_debris_with_water"
			criterion getCriterionName(Items.ANCIENT_DEBRIS), getCriterionConditions(Items.ANCIENT_DEBRIS)
		}
		offerIndustrialGrinderRecipe {
			ingredients Items.ANCIENT_DEBRIS
			outputs stack(Items.NETHERITE_SCRAP, 3), stack(Items.GOLD_NUGGET, 3)
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "ancient_debris_with_mercury"
			criterion getCriterionName(Items.ANCIENT_DEBRIS), getCriterionConditions(Items.ANCIENT_DEBRIS)
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Ores.BAUXITE.asTag()
			outputs stack(TRContent.Dusts.BAUXITE, 4), TRContent.Dusts.ALUMINUM
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "bauxite_ore_with_water"
			criterion getCriterionName(TRContent.Ores.BAUXITE.asTag()), getCriterionConditions(TRContent.Ores.BAUXITE.asTag())
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Ores.CINNABAR.asTag()
			outputs stack(TRContent.Dusts.CINNABAR, 5), stack(TRContent.SmallDusts.REDSTONE, 2), TRContent.SmallDusts.GLOWSTONE
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "cinnabar_ore_with_water"
			criterion getCriterionName(TRContent.Ores.CINNABAR.asTag()), getCriterionConditions(TRContent.Ores.CINNABAR.asTag())
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:coal_ores")
			outputs stack(Items.COAL, 3)
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "coal_ore_with_water"
			criterion getCriterionName(tag("c:coal_ores")), getCriterionConditions(tag("c:coal_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:coal_ores")
			outputs stack(Items.COAL, 4)
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "coal_ore_with_mercury"
			criterion getCriterionName(tag("c:coal_ores")), getCriterionConditions(tag("c:coal_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:copper_ores")
			outputs stack(Items.RAW_COPPER, 2), stack(Items.GOLD_NUGGET, 3)
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "copper_ore_with_water"
			criterion getCriterionName(tag("c:copper_ores")), getCriterionConditions(tag("c:copper_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:copper_ores")
			outputs stack(Items.RAW_COPPER, 3), stack(Items.GOLD_NUGGET, 3)
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "copper_ore_with_mercury"
			criterion getCriterionName(tag("c:copper_ores")), getCriterionConditions(tag("c:copper_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:copper_ores")
			outputs stack(Items.RAW_COPPER, 2), Items.RAW_GOLD, TRContent.Dusts.NICKEL
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.SODIUM_PERSULFATE.getFluid()
			source "copper_ore_with_sodium_persulfate"
			criterion getCriterionName(tag("c:copper_ores")), getCriterionConditions(tag("c:copper_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:diamond_ores")
			outputs Items.DIAMOND, stack(TRContent.SmallDusts.DIAMOND, 6), TRContent.Dusts.COAL
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "diamond_ore_with_water"
			criterion getCriterionName(tag("c:diamond_ores")), getCriterionConditions(tag("c:diamond_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:diamond_ores")
			outputs stack(Items.DIAMOND, 2), stack(TRContent.SmallDusts.DIAMOND, 3)
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "diamond_ore_with_mercury"
			criterion getCriterionName(tag("c:diamond_ores")), getCriterionConditions(tag("c:diamond_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:emerald_ores")
			outputs Items.EMERALD, stack(TRContent.SmallDusts.EMERALD, 6)
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "emerald_ore_with_water"
			criterion getCriterionName(tag("c:emerald_ores")), getCriterionConditions(tag("c:emerald_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:emerald_ores")
			outputs stack(Items.EMERALD, 2), stack(TRContent.SmallDusts.EMERALD, 3)
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "emerald_ore_with_mercury"
			criterion getCriterionName(tag("c:emerald_ores")), getCriterionConditions(tag("c:emerald_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Ores.GALENA.asTag()
			outputs stack(TRContent.Dusts.GALENA, 2), TRContent.Dusts.SULFUR
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "galena_ore_with_water"
			criterion getCriterionName(TRContent.Dusts.GALENA.asTag()), getCriterionConditions(TRContent.Dusts.GALENA.asTag())
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Ores.GALENA.asTag()
			outputs stack(TRContent.Dusts.GALENA, 2), TRContent.Dusts.SULFUR, TRContent.RawMetals.SILVER
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "galena_ore_with_mercury"
			criterion getCriterionName(TRContent.Ores.GALENA.asTag()), getCriterionConditions(TRContent.Ores.GALENA.asTag())
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("minecraft:gold_ores")
			outputs stack(Items.RAW_GOLD, 2), stack(TRContent.Nuggets.COPPER, 3), stack(TRContent.Nuggets.NICKEL)
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "gold_ore_with_water"
			criterion getCriterionName(tag("minecraft:gold_ores")), getCriterionConditions(tag("minecraft:gold_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:gold_ores")
			outputs stack(Items.RAW_GOLD, 3), stack(TRContent.Nuggets.COPPER, 3), stack(TRContent.Nuggets.NICKEL)
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "gold_ore_with_mercury"
			criterion getCriterionName(tag("minecraft:gold_ores")), getCriterionConditions(tag("minecraft:gold_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:gold_ores")
			outputs stack(Items.RAW_GOLD, 2), Items.RAW_COPPER, TRContent.Dusts.NICKEL
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.SODIUM_PERSULFATE.getFluid()
			source "gold_ore_with_sodium_persulfate"
			criterion getCriterionName(tag("minecraft:gold_ores")), getCriterionConditions(tag("minecraft:gold_ores"))
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Ores.IRIDIUM.asTag()
			outputs TRContent.RawMetals.IRIDIUM, stack(TRContent.SmallDusts.PLATINUM, 2)
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "iridium_ore_with_water"
			criterion getCriterionName(TRContent.Ores.IRIDIUM.asTag()), getCriterionConditions(TRContent.Ores.IRIDIUM.asTag())
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Ores.IRIDIUM.asTag()
			outputs stack(TRContent.RawMetals.IRIDIUM, 2), stack(TRContent.SmallDusts.PLATINUM, 2)
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.MERCURY.getFluid()
			source "iridium_ore_with_mercury"
			criterion getCriterionName(TRContent.Ores.IRIDIUM.asTag()), getCriterionConditions(TRContent.Ores.IRIDIUM.asTag())
		}
		offerIndustrialGrinderRecipe {
			ingredients TRContent.Ores.IRIDIUM.asTag()
			outputs TRContent.RawMetals.IRIDIUM, TRContent.Dusts.PLATINUM
			power 64
			time 100
			fluidAmount 1000L
			fluid ModFluids.SODIUM_PERSULFATE.getFluid()
			source "iridium_ore_with_sodium_persulfate"
			criterion getCriterionName(TRContent.Ores.IRIDIUM.asTag()), getCriterionConditions(TRContent.Ores.IRIDIUM.asTag())
		}
		offerIndustrialGrinderRecipe {
			ingredients tag("c:iron_ores")
			outputs stack(Items.RAW_IRON, 3), stack(TRContent.Nuggets.TIN, 3), stack(TRContent.Nuggets.NICKEL, 3)
			power 64
			time 100
			fluidAmount 1000L
			fluid Fluids.WATER
			source "iron_ore_with_water"
			criterion getCriterionName(tag("c:iron_ores")), getCriterionConditions(tag("c:iron_ores"))
		}
	}
}
