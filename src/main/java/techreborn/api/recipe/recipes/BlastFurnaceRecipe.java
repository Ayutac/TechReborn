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

package techreborn.api.recipe.recipes;

import com.google.gson.JsonObject;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import reborncore.common.crafting.RebornRecipe;
import reborncore.common.crafting.RebornRecipeType;
import reborncore.common.crafting.ingredient.RebornIngredient;
import techreborn.blockentity.machine.multiblock.IndustrialBlastFurnaceBlockEntity;
import techreborn.init.TRContent;

public class BlastFurnaceRecipe extends RebornRecipe {

	private int heat;

	public BlastFurnaceRecipe(RebornRecipeType<?> type, Identifier name) {
		super(type, name);
	}

	public BlastFurnaceRecipe(RebornRecipeType<?> type, Identifier name, DefaultedList<RebornIngredient> ingredients, DefaultedList<ItemStack> outputs, int power, int time, int heat) {
		super(type, name, ingredients, outputs, power, time);
		this.heat = heat;
	}

	public int getHeat() {
		return heat;
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(TRContent.Machine.INDUSTRIAL_BLAST_FURNACE);
	}

	@Override
	public void deserialize(JsonObject jsonObject) {
		super.deserialize(jsonObject);
		heat = JsonHelper.getInt(jsonObject, "heat");
	}

	@Override
	public void serialize(JsonObject jsonObject) {
		super.serialize(jsonObject);
		jsonObject.addProperty("heat", heat);
	}

	@Override
	public boolean canCraft(final BlockEntity blockEntity) {
		if (blockEntity instanceof final IndustrialBlastFurnaceBlockEntity blastFurnace) {
			return blastFurnace.getHeat() >= heat;
		}
		return false;
	}

}
