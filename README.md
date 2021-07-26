# Automation Test

## Overview ##
The Automation Test Service detects the business integrity of the glory service in a customized environment by quickly calling the API interface.

The service includes
- API service
- UI service


## Sonar ##
https://tss-sonarqube01.aiaazure.biz/dashboard?id=automationtest

## How to Run Automation Test

```bash
mvn test
```

### Env Variables/Config to start Automation Test
| Name | Description | Default Value|
| :-----| :----: | :---- |
| server.url.user | User module service address | |
| server.url.channel | Channeladminservice module service address|  |
| server.auth.username | The username of the login user required to obtain the token |  |
| server.auth.password | The password of the login user required to obtain the token | |

## How to Build Docker Image

```bash
docker build -t automation -f Dockerfile .

docker run --name  automation  -d automation
```

## Develop Tips ##
If you want to start the application in IDE, 
please use the local and production otherwise.


