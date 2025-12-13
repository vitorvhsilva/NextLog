#!/bin/bash
set -e

awslocal sqs create-queue \
  --queue-name pedidos-queue

awslocal sns create-topic \
  --name pedidos-topic

awslocal sqs set-queue-attributes \
  --queue-url http://localhost:4566/000000000000/pedidos-queue \
  --attributes '{"Policy":"{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"Service\":\"sns.amazonaws.com\"},\"Action\":\"sqs:SendMessage\",\"Resource\":\"arn:aws:sqs:us-east-1:000000000000:pedidos-queue\",\"Condition\":{\"ArnEquals\":{\"aws:SourceArn\":\"arn:aws:sns:us-east-1:000000000000:pedidos-topic\"}}}]}"}'

awslocal sns subscribe \
  --topic-arn arn:aws:sns:us-east-1:000000000000:pedidos-topic \
  --protocol sqs \
  --notification-endpoint arn:aws:sqs:us-east-1:000000000000:pedidos-queue