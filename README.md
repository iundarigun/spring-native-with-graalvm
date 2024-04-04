# Testing native app


Execution in local machine:
```shell
export GRADLE_OPTS="-Xmx4096m -Dorg.gradle.daemon=false"
./gradlew nativeCompile
build/native/nativeCompile/test-native-app -Dspring.profiles.active=dev
```

Execution in docker:
```shell
docker build -t iundarigun/native . 
docker run --rm -p 1980:8080 -e SPRING_PROFILES_ACTIVE=docker iundarigun/native
```

## Steps
- Simple get endpoint returning string ✅
- Simple get endpoint returning string using profiles ✅
- Simple get endpoint returning an object ✅
- simple get endpoint returning an object across Service ✅
- simple get endpoint returning an object across Service adding Lombok ✅
- simple post endpoint adding an object across Service ✅
- simple post endpoint with @Valid to add an object across Service ✅ 
- Add swagger ✅
- simple get and post endpoint with snake_case ✅
- Add mapstruct ✅
- Add dockerfile ✅
  - Issues: need to add `GRADLE_OPTS="-Xmx4096m -Dorg.gradle.daemon=false"` in the dockerfile to avoid compilation errors (out of memory)
- database ✅
  - Issues: need to add `export GRADLE_OPTS="-Xmx4096m -Dorg.gradle.daemon=false"` before compile in local

- database @CreatedDate and @LastModifiedDate
- flyway
- Feign to call external endpoint
- configure url by env vars
- security