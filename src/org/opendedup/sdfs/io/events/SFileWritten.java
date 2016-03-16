package org.opendedup.sdfs.io.events;

import org.opendedup.sdfs.io.SparseDedupFile;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class SFileWritten {
	public SparseDedupFile sf = null;

	public SFileWritten(SparseDedupFile f) {
		this.sf = f;
	}

	public String toJSON() {
		JsonObject dataset = new JsonObject();
		dataset.addProperty("actionType", "sfileWritten");
		dataset.addProperty("GUID", sf.getGUID());
		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				.create();
		return gson.toJson(dataset);
	}

}
