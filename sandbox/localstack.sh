#!/usr/bin/env bash

echo "BadmintonDb About to Create!---------------------------"

awslocal dynamodb create-table \
    --table-name badmintonDb \
    --attribute-definitions AttributeName=pk,AttributeType=S AttributeName=sk,AttributeType=S \
    --key-schema AttributeName=pk,KeyType=HASH AttributeName=sk,KeyType=RANGE \
    --billing-mode PAY_PER_REQUEST \
    --region us-east-1

echo "BadmintonDb Ready!"