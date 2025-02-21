# SpringRedisDemo

## Docker compose file

```
version: '3.8'

services:
  redis:
    image: redis:latest
    container_name: redis
    ports:
      - "6379:6379"

  postgres:
    image: postgres:latest
    container_name: postgres
    environment:
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: password
      POSTGRES_DB: mydatabase
    ports:
      - "5432:5432"


```



### Redis Commands


 **Start Redis Container**
```bash
docker-compose up -d
```

 **Stop Redis Container**
```bash
docker-compose down
```

 **Access Redis CLI**
```bash
docker exec -it redis redis-cli
```

- **Set a key-value pair:**
  ```bash
  SET mykey "Hello, Redis!"
  ```
- **Get the value of a key:**
  ```bash
  GET mykey
  ```
- **Check if a key exists:**
  ```bash
  EXISTS mykey
  ```
- **Delete a key:**
  ```bash
  DEL mykey
  ```
- **List all keys:**
  ```bash
  KEYS *
  ```
- **Set a key with an expiration time (in seconds):**
  ```bash
  SETEX mykey 10 "This will expire in 10 seconds"
  ```
- **Increment a key's value:**
  ```bash
  INCR mycounter
  ```
- **Push to a list:**
  ```bash
  LPUSH mylist "item1"
  RPUSH mylist "item2"
  ```
- **Get items from a list:**
  ```bash
  LRANGE mylist 0 -1
  ```

