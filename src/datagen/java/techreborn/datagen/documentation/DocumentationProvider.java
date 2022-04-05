/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package techreborn.datagen.documentation;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.impl.datagen.FabricDataGenHelper;
import net.minecraft.advancement.Advancement;
import net.minecraft.data.DataCache;
import net.minecraft.data.DataProvider;
import net.minecraft.util.Identifier;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Extend this class and implement {@link DocumentationProvider#generateDocumentation}.
 *
 * <p>Register an instance of the class with {@link FabricDataGenerator#addProvider} in a {@link net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint}
 */
public abstract class DocumentationProvider implements DataProvider {
	private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();

	protected final FabricDataGenerator dataGenerator;

	protected DocumentationProvider(FabricDataGenerator dataGenerator) {
		this.dataGenerator = dataGenerator;
	}

	/**
	 * Implement this method to generate documentation files.
	 */
	public abstract void generateDocumentation(Consumer<Documentation> consumer);

	@Override
	public void run(DataCache cache) throws IOException {
		final Set<Identifier> identifiers = Sets.newHashSet();
		final Set<Documentation> documentations = Sets.newHashSet();

		generateDocumentation(documentations::add);
		System.out.println("It worked!");

		for (Documentation advancement : documentations) {

		}
	}

	@Override
	public String getName() {
		return "Documentations";
	}
}
