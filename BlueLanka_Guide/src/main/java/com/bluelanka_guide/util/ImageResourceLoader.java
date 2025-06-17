package com.bluelanka_guide.util;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Utility class for loading and caching images in JavaFX applications
 */
public class ImageResourceLoader {

    // Cache to avoid reloading the same images
    private static final Map<String, Image> imageCache = new HashMap<>();

    /**
     * Loads an image from the resources folder with proper error handling
     *
     * @param path The path to the image relative to the resources folder
     * @return The loaded image or null if the image couldn't be loaded
     */
    public static Image loadImage(String path) {
        // Normalize path to ensure it starts with /
        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        // Check cache first
        if (imageCache.containsKey(path)) {
            System.out.println("Loading image from cache: " + path);
            return imageCache.get(path);
        }

        try {
            // Try to load the image from the classpath
            InputStream is = ImageResourceLoader.class.getResourceAsStream(path);
            if (is == null) {
                System.err.println("Could not find image: " + path);
                return null;
            }

            // Create image with backgroundLoading=false to ensure it's loaded immediately
            // This helps with error detection
            Image image = new Image(is.toString(), 0, 0, true, true, false);

            if (image.isError()) {
                System.err.println("Error loading image: " + path + " - " + image.getException().getMessage());
                return null;
            }

            // Cache the image for future use
            imageCache.put(path, image);
            System.out.println("Successfully loaded and cached image: " + path);
            return image;
        } catch (Exception e) {
            System.err.println("Exception loading image: " + path + " - " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Attempts to load an image from multiple possible paths
     *
     * @param possiblePaths Array of possible paths to try
     * @return The loaded image or null if none of the paths worked
     */
    public static Image loadImageFromMultiplePaths(String... possiblePaths) {
        for (String path : possiblePaths) {
            Image image = loadImage(path);
            if (image != null) {
                System.out.println("Successfully loaded image from: " + path);
                return image;
            }
        }

        System.err.println("Failed to load image from any of the provided paths:");
        for (String path : possiblePaths) {
            System.err.println("  - " + path);
        }
        return null;
    }

    /**
     * Loads an image asynchronously (useful for background loading)
     *
     * @param path The path to the image
     * @return A CompletableFuture that will contain the image when loaded
     */
    public static CompletableFuture<Image> loadImageAsync(String path) {
        return CompletableFuture.supplyAsync(() -> {
            Image image = loadImage(path);
            return image;
        });
    }

    /**
     * Creates a placeholder rectangle that can be used while images are loading
     *
     * @return A placeholder image
     */
    public static Image createPlaceholderImage(int width, int height) {
        // This creates a 1x1 transparent image that can be scaled
        return new Image("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=", width, height, true, true);
    }

    /**
     * Clears the image cache
     */
    public static void clearCache() {
        imageCache.clear();
        System.out.println("Image cache cleared");
    }

    /**
     * Gets the current cache size
     */
    public static int getCacheSize() {
        return imageCache.size();
    }

    /**
     * Preloads a set of images in the background
     *
     * @param paths The paths of images to preload
     */
    public static void preloadImages(String... paths) {
        new Thread(() -> {
            for (String path : paths) {
                loadImage(path);
            }
            System.out.println("Preloaded " + paths.length + " images");
        }).start();
    }
}