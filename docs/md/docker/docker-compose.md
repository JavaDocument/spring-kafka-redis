# 🐳 docker-compose

## Docker 설치하기

Docker 와 DockerDesktop 을 설치한다.

## 실행하기

```shell
$ docker-compose up
```

<img src="../../image/docker/ops-1.png" align="center" height="300"/>

## 결과

```shell
$ docker ps
```

<img src="../../image/docker/ops-2.png" align="center"/>

## Redis CLI 접속

```shell
$ docker exec -it lkdcode-redis bash
$ redis-cli
$ keys *
```

<img src="../../image/docker/ops-3.png" align="center"/>

## Kafak CLI 접속

```shell
$ docker exec -it kafka bash
$ kafka-topics.sh --list --bootstrap-server localhost:9092
```

<img src="../../image/docker/ops-4.png" align="center" width="600"/>