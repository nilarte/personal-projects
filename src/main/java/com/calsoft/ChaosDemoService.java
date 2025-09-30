package com.calsoft;

/**
 * Service class with a method that chaosd can instrument to throw an exception.
 * The {@link #processRequest()} method simply logs to stdout and returns a
 * message when no chaos experiment is running.
 */
public class ChaosDemoService {

    /**
     * Method intentionally left simple so chaosd can inject
     * {@code java.lang.RuntimeException("CHAOS-TEST")} via the JVM attack.
     *
     * @return message for successful calls.
     */
    public String processRequest() {
        System.out.println("Processing request in ChaosDemoService.processRequest()");
        return "Request processed successfully";
    }
}
