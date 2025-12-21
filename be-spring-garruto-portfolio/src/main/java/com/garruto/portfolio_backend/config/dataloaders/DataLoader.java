package com.garruto.portfolio_backend.config.dataloaders;

/**
 * Interface for all data loaders in the application.
 * Each loader is responsible for loading a specific section of the portfolio data.
 */
public interface DataLoader {

    /**
     * Loads data into the database using the provided context.
     *
     * @param context The data loading context containing repositories and shared entities
     * @throws Exception if any error occurs during data loading
     */
    void load(DataLoadContext context) throws Exception;

    /**
     * Returns the order in which this loader should be executed.
     * Lower numbers execute first.
     *
     * @return the execution order
     */
    int getOrder();

    /**
     * Returns the name of this data loader for logging purposes.
     *
     * @return the loader name
     */
    String getName();
}