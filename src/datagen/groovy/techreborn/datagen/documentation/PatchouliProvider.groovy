package techreborn.datagen.documentation

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.data.server.recipe.RecipeJsonProvider

import java.util.function.Consumer

class PatchouliProvider extends DocumentationProvider {
	protected Consumer<Documentation> exporter

	PatchouliProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator)
	}

	@Override
	void generateDocumentation(Consumer<Documentation> exporter) {
		this.exporter = exporter
	}

	protected void generateDocumentation() {

	}

}
