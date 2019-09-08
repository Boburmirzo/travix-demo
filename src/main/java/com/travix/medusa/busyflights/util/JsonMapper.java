package com.travix.medusa.busyflights.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.apache.commons.io.FileUtils;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import lombok.NonNull;

import static java.lang.ClassLoader.getSystemResource;

/**
 * Utility class wrapping a ObjectMapper to serializes and deserializes JSON to/from Java objects that handles the
 * checked JSON processing exception thrown.
 * <p>
 * This class has been converted to a utility class from a spring bean as it only offers utility methods around the
 * ObjectMapper which is created manually.  This approach should not be widely used as it breaks the dependency
 * injection / inversion of controller patterns.
 */
public final class JsonMapper {
	@NonNull
	private static ObjectMapper objectMapper;

	private JsonMapper() {
	}

	static {
		final JavaTimeModule module = new JavaTimeModule();

		objectMapper = new Jackson2ObjectMapperBuilder()
				.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.featuresToEnable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN)
				.failOnUnknownProperties(false)
				.findModulesViaServiceLoader(true)
				.modulesToInstall(module)
				.build();
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	/**
	 * Serialize object to JSON
	 *
	 * @param obj The object to serialize
	 * @return JSON string
	 */
	public static String toJson(final Object obj) {
		if (null == obj) {
			return null;
		}
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (final JsonProcessingException e) {
			throw new IllegalArgumentException("Error");
		}
	}


	/**
	 * Deserialize JSON to Java object
	 *
	 * @param json  the JSON string
	 * @param clazz Java class of object to create from JSON
	 * @param <T>   type of return object
	 * @return Java object representation of JSON data
	 */
	public static <T> T fromJson(final String json, final Class<T> clazz) {
		if (null == json) {
			return null;
		}
		try {
			return objectMapper.readValue(json, clazz);
		} catch (final IOException e) {
			throw new IllegalArgumentException("Error");
		}
	}

	public static String getResource(final String resourceName) {
		try {
			final File file = new File(getSystemResource(resourceName).getFile());
			return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		} catch (final IOException e) {
			throw new RuntimeException(String.format("could not load resource: %s", resourceName), e);
		}
	}

	public static <T> T getResource(final String resourceName, final Class<T> t) {
		return fromJson(getResource(resourceName), t);
	}
}

