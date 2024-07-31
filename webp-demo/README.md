
# Howto

## Build and run the demo for debugging purpose

```bash
mvn clean package
cd webp-demo
docker build . -t webp-demo
docker run -it --rm -p 5005:5005 --name webp-demo-debug webp-demo sh
export LD_LIBRARY_PATH=/tmp/webp.lib
java -Dlibrary.extract.dir=/tmp/webp.lib -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:5005 -jar webp-demo.jar /tmp/rose.webp /tmp/rose.raw
```
