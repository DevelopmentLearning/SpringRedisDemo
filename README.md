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
```

