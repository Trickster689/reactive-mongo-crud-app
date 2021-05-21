<h1>Spring Boot Reactive Mongo CRUD App</h1>

<p>This app demonstrates the CRUD operation on mongodb database
using the Spring Boot reactive API.
The application shows all the api endpoints using
swagger documents which is accessible on:
<a href="http://localhost:9292/swagger-ui/">Swagger UI</a>
</p>

<p>
This application also uses Prometheus and Grafana Dashboard
To start Prometheus, run the following docker command:
`docker run -d -p 9090:9090 -v [path-to-prometheus.yml directory]\prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus`
</p>

<p>Then access the Prometheus Dashboard on the following url:
<a href="http://localhost:9090/">Prometheus Dashboard</a>
</p>

<p>
Run the following command on docker for Grafana:
`docker run -d -p 3000:3000 grafana/grafana`

Then access the Grafana on the following url:
<a href="http://localhost:3000/">Grafana Dashboard</a>

The default username and password are 'admin' and 'admin'

Add the Prometheus Datasource in the Grafana using the Prometheus url and set the
access from 'Browser' in the datasource window.
</p>

