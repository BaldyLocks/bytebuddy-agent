# bytebuddy-agent

1. Build JAR with `mvn package`
2. Build & Run Docker image with `docker-compose up --build`
3. Test with `curl -I http://localhost:8888/`

    Expected response should contain header **`X-Instrumented-By: Sqreen`**
    
    e.g. similar to:
    ```bash
    HTTP/1.1 200 
    X-Instrumented-By: Sqreen
    Content-Type: text/html;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Fri, 06 Dec 2019 10:32:14 GMT
    ```
   
TODO
* Fix integration test using Cargo plugin.