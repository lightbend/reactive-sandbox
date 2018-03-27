# reactive-sandbox

This project is a component of [Lightbend Orchestration for Kubernetes](https://developer.lightbend.com/docs/lightbend-orchestration-kubernetes/latest/). Refer to its documentation for usage, examples, and reference information.

It implements a small Docker image containing common dependencies for running [Lightbend Reactive Platform](https://www.lightbend.com/products/reactive-platform) applications. This includes minimal versions of:

* Cassandra
* Elasticsearch
* Kafka
* ZooKeeper

This image is meant to be used during development. It is not production grade.

## Kubernetes Installation

Reactive Sandbox is installed using [helm](https://helm.sh/). To do this, follow the instructions below:

```bash
# Install Helm and add the Lightbend repository
helm init
helm repo add lightbend-helm-charts https://lightbend.github.io/helm-charts
helm update

# Install the reactive-sandbox
helm install lightbend-helm-charts/reactive-sandbox --name reactive-sandbox
```

## Published Docker Images

Lightbend publishes builds of this image to its [Bintray Registry](https://bintray.com/lightbend/registry/rp%3Areactive-sandbox).

```bash
docker pull lightbend-docker-registry.bintray.io/rp/reactive-sandbox:<version>
```

## Configuration

The following environment variables are available:

**RS_ENABLE_CASSANDRA**

If set to `0`, Cassandra will not be started.

**RS_ENABLE_ELASTICSEARCH**

If set to `0`, Elasticsearch will not be started.

**RS_ENABLE_KAFKA**

If set to `0`, Kafka will not be started.

**RS_ENABLE_ZOOKEEPER**

If set to `0`, ZooKeeper will not be started.

**RS_CASSANDRA_HEAP**

Declares heap size for Cassandra. Defaults to 256.

**RS_ELASTICSEARCH_HEAP**

Declares heap size for Elasticsearch. Defaults to 128.

**RS_KAFKA_HEAP**

Declares heap size for Kafka. Defaults to 256.

**RS_ZOOKEEPER_HEAP**

Declares heap size for ZooKeeper. Defaults to 128.

## Maintenance

Enterprise Suite Platform Team <es-platform@lightbend.com>

## Releasing

Consult the _Platform Tooling Release Process_ document in Google Drive.

## License

Copyright (C) 2017 Lightbend Inc. (https://www.lightbend.com).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

