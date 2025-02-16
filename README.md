
## Components

1. **Producer Service**
   - Spring Boot application that produces MQTT messages
   - Runs on port 8081
   - Configurable via application.properties

2. **Consumer Service**
   - Spring Boot application that consumes MQTT messages
   - Runs on port 8080
   - Configurable via application.properties

3. **MQTT Broker (Eclipse Mosquitto)**
   - MQTT message broker
   - Runs on port 1884 for MQTT
   - WebSocket support on port 9001
   - Configurable via mosquitto.conf

## Deployment Options

### Docker Compose

To run the application using Docker Compose:

```bash
docker-compose up -d
```

This will start:
- Producer service on port 8081
- Consumer service on port 8080
- MQTT broker on ports 1884 (MQTT) and 9001 (WebSocket)

## API Endpoints

### Producer Service

**Endpoint:** `POST /api/messages`  
**Port:** 8081  
**Description:** Publishes a message to a specified MQTT topic

**Request Payload:**
```json
{
    "topic": "string",    // The MQTT topic to publish to
    "message": "string"   // The message content to be published
}
```

**Response:**
- Status: 200 OK
- Body: "Message published successfully"

**Example Request:**
```bash
curl -X POST http://localhost:8081/api/messages \
     -H "Content-Type: application/json" \
     -d '{
           "topic": "test/topic",
           "message": "Hello, MQTT!"
         }'
``` 
