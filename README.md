# observation-deck

Summarise the status and latest activity of github repositories.
Optionally configure a GoCD server to included deployment status tracking
See application.conf.template for config options

![Observation Deck screenshot](https://github.com/insano10/observation-deck/blob/master/dash_pic.png)

## Running

Set the appropriate hostname in `src/main/webapp/app/app.js`

through sbt:

    > sbt run
    
    browse to http://localhost:8080

or with docker:

    > sbt docker:publishLocal
    > docker run -p 8080:8080 observation-deck:0.1.0-SNAPSHOT
    
    browse to http://localhost:8080/repositories

Handy docker commands while testing:

    # delete all stopped containers
    > docker ps -a -q | xargs docker rm

    # delete all untagged images
    > docker rmi $(docker images -q --filter "dangling=true")
    

The webserver runs on port 8080 through sbt but 8090 through docker.
Nginx is then running on port 8080 to proxy through to the webserver or serve static content based on the URL
