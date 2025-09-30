# personal-projects

This repository now contains a tiny Java HTTP server that can be used with
[`chaosd`](https://github.com/chaos-mesh/chaosd) to inject a
`java.lang.RuntimeException("CHAOS-TEST")` into a running JVM.

## Running the demo server

```bash
mvn package
java -cp target/personal-projects-1.0-SNAPSHOT.jar com.calsoft.App
```

The application listens on `http://localhost:8080/` and logs every request
via `ChaosDemoService.processRequest()`.

## Triggering a chaos experiment

1. Find the JVM process ID (PID) of the running server.
2. Execute the following command, replacing placeholders with the actual
   class, method and PID values:

```bash
chaosd attack jvm exception \
  -c com.calsoft.ChaosDemoService \
  -m processRequest \
  --exception 'java.lang.RuntimeException("CHAOS-TEST")' \
  --pid <PID>
```

The injected exception is caught by the HTTP handler and printed to the
application console so it is easy to verify that the chaos attack worked.
