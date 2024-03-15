package dev.svero.playground.helloworld;

import org.apache.commons.cli.*;

/**
 * Implements the entry point for running this Java application.
 *
 * @author Sven Röseler
 */
public class Application {
    /**
     * The entry point.
     *
     * @param args String array with all command-line arguments.
     */
    public static void main(String[] args) {
        Application application = new Application();
        application.run(args);
    }

    /**
     * Creates all available CLI options.
     *
     * @return Instance of the Options class with all available CLI options
     */
    private Options createOptions() {
        Options options = new Options();

        options.addOption("u", "username", true, "The username");

        return options;
    }

    /**
     * Contains the application logic.
     *
     * @param args String array with all command-line arguments.
     */
    private void run(String[] args) {
        final Options options = createOptions();

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException ex) {
            System.err.println("Could not parse the command-line arguments: " + ex.getMessage());
            return;
        }

        String username = "World";
        if (cmd.hasOption('u')) {
            username = cmd.getOptionValue('u');
        }

        System.out.printf("Hello, %s! Greetings from Java!%n", username);
    }
}