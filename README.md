# Echo-Websocket-Server
Simple websocket server for testing  
It returns the same message from client

# Usage
```
./gradlew bootRun
```

# Test on Js console
```js
var ws = new WebSocket("ws://localhost:8080/ws");

ws.onmessage = function(e) {console.log("FromServer: " + e.data);};

ws.send("hello");
# "FromServer: hello"
```
