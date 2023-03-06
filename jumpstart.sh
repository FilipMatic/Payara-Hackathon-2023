#!/bin/bash
#
# Helper script to run Jakarta EE Jumpstart project

function deploy() {
  sudo mvn clean package -DskipTests
  # sudo mvn install
  docker-compose up -d
  # docker-compose up --force-recreate
}

function shutdown() {
  docker-compose stop
  sudo mvn clean
}

function clean() {
  docker-compose down
  sudo mvn clean
}

COMMAND="${1:-help}"

if [ "$COMMAND" = "deploy" ]; then
  deploy
fi

if [ "$COMMAND" = "stop" ]; then
  shutdown
fi

if [ "$COMMAND" = "clean" ]; then
  clean
fi

if [ "$COMMAND" = "help" ]; then
  echo ""
  echo "Usage:"
  echo "  jumpstartl.sh <command>"
  echo "Commands:"
  echo "  deploy       : Build and deploy the application in Payara container"
  echo "  stop         : Shutdown the application"
  echo "  clean     : Shutdown and remove containers"
  echo ""
fi
