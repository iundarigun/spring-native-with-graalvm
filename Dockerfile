# Using Oracle GraalVM for JDK 17
FROM ghcr.io/graalvm/native-image:ol7-java17-22.3.0 AS builder

# Set the working directory to /home/app
WORKDIR /build

# Copy the source code into the image for building
COPY . /build

RUN java --version

ENV GRADLE_OPTS="-Xmx4096m -Dorg.gradle.daemon=false"
    # Build
RUN ./gradlew nativeCompile

# The deployment Image
FROM container-registry.oracle.com/os/oraclelinux:8-slim

EXPOSE 8080

# Copy the native executable into the containers
COPY --from=builder /build/build/native/nativeCompile/test-native-app app
ENTRYPOINT ["/app"]