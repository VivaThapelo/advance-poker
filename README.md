Build the Docker image:
Open a terminal and navigate to the root directory of your project.
Run the following command to build the Docker image:

```
docker build -t poker-app .
```

Run the Docker container:
After the Docker image is built, you can run the container using the following command:

```
docker run -p 8085:8085 poker-app
```