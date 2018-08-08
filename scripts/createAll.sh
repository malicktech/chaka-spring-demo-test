#!/bin/bash
for f in *.json
do
    echo processing $f
    curl http://localhost:8080/users -i -H "Content-Type:application/json"  -d @$f
done