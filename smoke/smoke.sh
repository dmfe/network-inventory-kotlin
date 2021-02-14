#!/bin/bash

set -e

ne_json="./ne.json"
hw_json="./hw.json"
host=localhost
port=8080
ne_post_path="/v1/network-elements"
hw_post_path="/v1/hardware-components/network-element"

ne_id=$(curl -d "@${ne_json}" \
    -H "Content-Type: application/json" \
    -XPOST "${host:-localhost}:${port:-8080}/${ne_post_path}")
curl -d "@${hw_json}" \
    -H "Content-Type: application/json" \
    -XPOST "${host:-localhost}:${port:-8080}/${hw_post_path}/${ne_id}"
