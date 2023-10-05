
> sudo service redis-server start
> 
> 12345

> redis-cli 
>
> 127.0.0.1:6379> ping 
> 
> PONG

# Refer
[[Chat-GPT-Redis](https://chat.openai.com/share/53958acc-cc91-41d1-bacc-6d589d134752)] 

```shell
# Set the value of fields in a hash
> HSET cart:123 product1 5
(integer) 1
> HSET cart:123 product2 3
(integer) 1

# Get the value of a specific field in the hash
> HGET cart:123 product1
"5"

# Get all fields and values in the hash
> HGETALL cart:123
1) "product1"
2) "5"
3) "product2"
4) "3"

# Delete a field from the hash
> HDEL cart:123 product2
(integer) 1

# Increment the value of a field
> HINCRBY cart:123 product1 2
(integer) 7

# Get all field names in the hash
> HKEYS cart:123
1) "product1"

# Get all values in the hash
> HVALS cart:123
1) "7"
```