# Docker Images

This is the place where are located the images from the services used for development, test, or create a POC.

## Useful Commands

### List the containers
```Docker ps```
### Docker run
```docker run [image]```

### Information about images

```docker images``` 

### Information about images less verbose

```docker images | head```

### Stop container

```docker stop [container id]```

### Stop all the containers

```docker stop $(docker ps -a -q).```